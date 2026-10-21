package com.julio.rcp.back.infrastructure.impl;

import com.julio.rcp.back.infrastructure.Dao;
import com.julio.rcp.back.infrastructure.dto.IncidenciaRow;
import com.julio.rcp.back.infrastructure.dto.ProgresoRow;
import com.julio.rcp.common.domain.exceptions.IncidenciaRunTimeException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DaoImpl implements Dao {
    private final DataSource dataSource;

    @Inject
    public DaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<IncidenciaRow> findById(int id) {
        final String SQL = """
                           SELECT id, descripcion, fecha, email, prioridad, tipo
                           FROM incidencias
                           WHERE id = ?
                           """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) return Optional.empty();
                return Optional.of(IncidenciaRow.builder()
                        .id(resultSet.getInt("id"))
                        .descripcion(resultSet.getString("descripcion"))
                        .fecha(resultSet.getDate("fecha").toLocalDate())
                        .email(resultSet.getString("email"))
                        .prioridad(resultSet.getString("prioridad"))
                        .tipo(resultSet.getString("tipo"))
                        .build());
            }
        } catch (SQLException sqlException) {
            throw new IncidenciaRunTimeException(sqlException);
        }
    }

    @Override
    public List<ProgresoRow> findProgresosByIncidenciaId(int id) {
        final String SQL = """
                           SELECT codigo, id, fecha, empleado, descripcion, estado
                           FROM progresos
                           WHERE id = ?
                           ORDER BY codigo
                           """;
        List<ProgresoRow> progresos = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    progresos.add(ProgresoRow.builder()
                            .codigo(resultSet.getInt("codigo"))
                            .id(resultSet.getInt("id"))
                            .fecha(resultSet.getDate("fecha").toLocalDate())
                            .empleado(resultSet.getString("empleado"))
                            .descripcion(resultSet.getString("descripcion"))
                            .estado(resultSet.getString("estado"))
                            .build());
                }
            }
            return progresos;
        } catch (SQLException sqlException) {
            throw new IncidenciaRunTimeException(sqlException);
        }
    }

    @Override
    public boolean existsIncidencia(int id) {
        final String SQL = """
                           SELECT 1
                           FROM incidencias
                           WHERE id = ?
                           """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException sqlException) {
            throw new IncidenciaRunTimeException(sqlException);
        }
    }

    @Override
    public ProgresoRow addProgreso(int id, ProgresoRow progresoRow) {
        final String SQL = """
                           INSERT INTO progresos(id, fecha, empleado, descripcion, estado)
                           VALUES (?, ?, ?, ?, ?)
                           """;
        final String[] fields = {"codigo"};

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL, fields)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, Date.valueOf(progresoRow.getFecha()));
            preparedStatement.setString(3, progresoRow.getEmpleado());
            preparedStatement.setString(4, progresoRow.getDescripcion());
            preparedStatement.setString(5, progresoRow.getEstado());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();
                return ProgresoRow.builder()
                        .codigo(resultSet.getInt(1))
                        .id(id)
                        .fecha(progresoRow.getFecha())
                        .empleado(progresoRow.getEmpleado())
                        .descripcion(progresoRow.getDescripcion())
                        .estado(progresoRow.getEstado())
                        .build();
            }
        } catch (SQLException sqlException) {
            throw new IncidenciaRunTimeException(sqlException);
        }
    }
}
