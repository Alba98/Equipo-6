-- GESTIONAR_PARTIDOS_TEST
/* 
 Fecha: 03/05/2022
 Descripcion:  Testeo paquete gestion de jornadas
 */
 
SET SERVEROUTPUT ON;

-- **************************************************************
/*
INSERT_PARTIDO
*/

INSERT INTO equipos (nombre, fecha_fundacion, ciudad, esponsor, nombre_duenio) 
    VALUES('Gasteiz-Goya', TO_DATE('23/01/2021','DD/MM/YYYY'), 'Vitoria', 'Goya', 'Eneko Alonso');
INSERT INTO equipos (nombre, fecha_fundacion, ciudad, esponsor, nombre_duenio) 
    VALUES('Real Horses', TO_DATE('02/05/2016','DD/MM/YYYY'), 'Madrid', 'SGAE', 'Pablo Luchs');

INSERT INTO jornadas (cod_temporada, fecha_jornada) VALUES (01, TO_DATE('04/11/2022','DD/MM/YYYY'));

INSERT INTO PARTIDOS (HORA_PARTIDO, COD_JORNADA) 
        VALUES ('19:00', 01);

DECLARE
    P_HORA_PARTIDO PARTIDOS.HORA_PARTIDO%TYPE := '19:00';
    P_COD_JORNADA PARTIDOS.COD_JORNADA%TYPE := 01;
    P_EQUIPO1 VARCHAR2(30) := 'Real Horses';
    P_EQUIPO2 VARCHAR2(30) := 'Gasteiz-Goya';
BEGIN
    GEST_PARTIDOS.INSERT_PARTIDO(P_HORA_PARTIDO, P_COD_JORNADA, P_EQUIPO1, P_EQUIPO2); 
END;

SELECT * FROM EQUIPOS;
SELECT * FROM JORNADAS;
SELECT * FROM PARTIDOS;
SELECT * FROM PARTICIPA;

-- **************************************************************
/*
INSERT_RESULTADO
*/
DECLARE
    P_COD_PARTIDO NUMBER(2) := 01;
    P_RESULTADO VARCHAR2(3) := '3-2';
BEGIN
    GEST_PARTIDOS.INSERT_RESULTADO(P_COD_PARTIDO, P_RESULTADO); 
END;


 -- genera error
DECLARE
    P_COD_PARTIDO NUMBER(2) := 05;
    P_RESULTADO VARCHAR2(3) := '3-2';
BEGIN
    GEST_PARTIDOS.INSERT_RESULTADO(P_COD_PARTIDO, P_RESULTADO); 
END;


--ROLLBACK;