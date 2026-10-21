CREATE TABLE incidencias 
(
    id          INT GENERATED ALWAYS AS IDENTITY,
    descripcion VARCHAR(255),
    fecha       DATE,
    email       VARCHAR(255),
    prioridad   VARCHAR(6),
    tipo        VARCHAR(13),

    CONSTRAINT PK_incidencias             PRIMARY KEY (id),
    CONSTRAINT NN_incidencias_descripcion CHECK (descripcion IS NOT NULL),
    CONSTRAINT NN_incidencias_fecha       CHECK (fecha IS NOT NULL),
    CONSTRAINT NN_incidencias_email       CHECK (email IS NOT NULL),
    CONSTRAINT NN_incidencias_prioridad   CHECK (prioridad IS NOT NULL),
    CONSTRAINT NN_incidencias_tipo        CHECK (tipo IS NOT NULL),
    CONSTRAINT CH_incidencias_prioridad   CHECK (prioridad IN ('LOW', 'MEDIUM', 'HIGH')),
    CONSTRAINT CH_incidencias_tipo        CHECK (tipo IN ('IT', 'MANTENIMIENTO', 'LIMPIEZA'))
);

CREATE TABLE progresos 
(
    codigo      INT GENERATED ALWAYS AS IDENTITY,
    id          INT,
    fecha       DATE,
    empleado    VARCHAR(255),
    descripcion VARCHAR(255),
    estado      VARCHAR(11),

    CONSTRAINT PK_progresos             PRIMARY KEY (codigo),
    CONSTRAINT NN_progresos_id          CHECK (id IS NOT NULL),
    CONSTRAINT NN_progresos_fecha       CHECK (fecha IS NOT NULL),
    CONSTRAINT NN_progresos_empleado    CHECK (empleado IS NOT NULL),
    CONSTRAINT NN_progresos_descripcion CHECK (descripcion IS NOT NULL),
    CONSTRAINT NN_progresos_estado      CHECK (estado IS NOT NULL),
    CONSTRAINT CH_progresos_estado      CHECK (estado IN ('OPEN', 'IN_PROGRESS', 'CLOSED')),
    CONSTRAINT FK_progresos_incidencias FOREIGN KEY (id) REFERENCES incidencias(id)
);


-- incidencias
INSERT INTO incidencias (descripcion, fecha, email, prioridad, tipo)
                 VALUES ('Se ha roto la pantalla de mi ordenador', '2026-05-21', 'paco@example.com', 'HIGH', 'IT');

INSERT INTO incidencias (descripcion, fecha, email, prioridad, tipo)
    VALUES ('El aire acondicionado no funciona', '2026-05-22', 'lucia@example.com', 'MEDIUM', 'MANTENIMIENTO');

INSERT INTO incidencias (descripcion, fecha, email, prioridad, tipo)
    VALUES ('La sala de reuniones está sucia', '2026-05-23', 'carlos@example.com', 'LOW', 'LIMPIEZA');

INSERT INTO incidencias (descripcion, fecha, email, prioridad, tipo)
    VALUES ('El servidor de correo no responde', '2026-05-24', 'ana@example.com', 'HIGH', 'IT');

INSERT INTO incidencias (descripcion, fecha, email, prioridad, tipo)
    VALUES ('La impresora del tercer piso no imprime', '2026-05-25', 'pedro@example.com', 'MEDIUM', 'IT');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (1, '2026-05-21', 'armando@example.com', 'Incidencia asignada', 'OPEN');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (1, '2026-05-22', 'armando@example.com', 'Retirada del monitor', 'IN_PROGRESS');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (1, '2026-05-23', 'armando@example.com', 'Instalación del nuevo monitor', 'IN_PROGRESS');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (1, '2026-05-24', 'armando@example.com', 'Incidencia resuelta', 'CLOSED');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (2, '2026-05-22', 'elena@example.com', 'Incidencia asignada al servicio técnico', 'OPEN');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (2, '2026-05-23', 'elena@example.com', 'Revisión del sistema de climatización', 'IN_PROGRESS');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (3, '2026-05-23', 'servicio@example.com', 'Incidencia registrada para el equipo de limpieza', 'OPEN');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (3, '2026-05-24', 'servicio@example.com', 'Limpieza de la sala completada', 'CLOSED');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (4, '2026-05-24', 'soporte@example.com', 'Incidencia abierta y asignada a sistemas', 'OPEN');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (4, '2026-05-25', 'soporte@example.com', 'Diagnóstico del servidor de correo', 'IN_PROGRESS');

INSERT INTO progresos (id, fecha, empleado, descripcion, estado)
    VALUES (5, '2026-05-25', 'it@example.com', 'Incidencia registrada', 'OPEN');