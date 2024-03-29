-- CRIAR SEQUENCES --

CREATE SEQUENCE CAMBIO_SEQ
        INCREMENT BY 1
        MINVALUE 1
        START WITH 1;
-- CRIAR TABELAS --

CREATE TABLE CAMBIO
(
    ID                    BIGINT DEFAULT nextval('CAMBIO_SEQ') PRIMARY KEY NOT NULL,
    FROM_CURRENCY         VARCHAR(3) NOT NULL,
    TO_CURRENCY           VARCHAR(3) NOT NULL,
    CONVERSION_FACTORY    DECIMAL(65,2) NOT NULL
);
