CREATE TABLE DIVISION (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
    CODIGO CHAR(2),
    NOMBRE VARCHAR(20) NOT NULL,
    CONSTRAINT ID_DIVISION_PK PRIMARY KEY (ID)
);

CREATE TABLE ESTADIO (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, -- Id autonumérico
    NOMBRE VARCHAR(20) NOT NULL,
    LOCALIZACION VARCHAR(40) NOT NULL,
    TELEFONO VARCHAR(15),
    EMAIL VARCHAR(30),
    PROVINCIA VARCHAR(30),
    DIVISION INTEGER,
    FECHA_FUNDACION DATE,
    CATEGORIA_CLUBS CHAR(1),
    PRECIO DECIMAL(7,2),
    MEDIDA_CAMPO SMALLINT,
    ENTRADAS_DISPONIBLES BOOLEAN,
    FOTO_ESTADIO VARCHAR(30),
    CONSTRAINT ID_ESTADIO_PK PRIMARY KEY (ID),
    CONSTRAINT PROV_ESTADIO_FK FOREIGN KEY (DIVISION) REFERENCES DIVISION (ID)
);

