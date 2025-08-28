-- Tabla de estados de las solicitudes
CREATE TABLE "status"
(
    status_id   BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);

-- Tipos de préstamos
CREATE TABLE loan_type
(
    loan_type_id         BIGSERIAL PRIMARY KEY,
    name                 VARCHAR(100)   NOT NULL,
    min_amount           NUMERIC(15, 2) NOT NULL,
    max_amount           NUMERIC(15, 2) NOT NULL,
    interest_rate        NUMERIC(5, 2)  NOT NULL, -- en porcentaje (ej. 12.50 = 12.5%)
    automatic_validation BOOLEAN DEFAULT FALSE
);

-- Solicitudes de préstamo
CREATE TABLE loan_application
(
    loan_application_id BIGSERIAL PRIMARY KEY,
    application_date    DATE           NOT NULL,
    amount              NUMERIC(15, 2) NOT NULL,
    term                INT            NOT NULL, -- en meses
    email               VARCHAR(150)   NOT NULL,
    status_id           BIGINT         NOT NULL,
    loan_type_id        BIGINT         NOT NULL,
    CONSTRAINT fk_loan_application_status FOREIGN KEY (status_id) REFERENCES "status" (status_id),
    CONSTRAINT fk_loan_application_type FOREIGN KEY (loan_type_id) REFERENCES loan_type (loan_type_id)
);

INSERT INTO "status" (name, description)
VALUES ('EN_REVISION', 'La solicitud está siendo revisada por un analista'),
       ('APROBADA', 'La solicitud ha sido aprobada'),
       ('RECHAZADA', 'La solicitud ha sido rechazada'),
       ('CANCELADA', 'La solicitud fue cancelada por el usuario');


INSERT INTO loan_type (name, min_amount, max_amount, interest_rate, automatic_validation)
VALUES ('Préstamo Personal', 1000000, 50000000, 1.50, TRUE),
       ('Préstamo Hipotecario', 50000000, 500000000, 1.00, FALSE),
       ('Préstamo Vehicular', 5000000, 100000000, 1.20, FALSE),
       ('Préstamo Educativo', 2000000, 80000000, 0.80, FALSE),
       ('Préstamo Empresarial', 10000000, 200000000, 1.40, FALSE);
