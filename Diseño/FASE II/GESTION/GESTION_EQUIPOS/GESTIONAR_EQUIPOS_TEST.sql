-- GESTIONAR_EQUIPOS_TEST
/* 
 Fecha: 03/05/2022
 Descripcion:  Testeo paquete gestion de EQUIPOS

 */
 
SET SERVEROUTPUT ON;

-- **************************************************************
/*
    Procedimiento INSERT_EQUIPO: 
*/
DECLARE
    P_NOMBRE VARCHAR2(30) := 'Gasteiz-Goya';
    P_FECHA_FUNDACION DATE := TO_DATE('23/01/2021','DD/MM/YYYY');
    P_CIUDAD VARCHAR2(30) := 'Vitoria';
    P_ESPONSOR VARCHAR2(20) := 'Goya';
    P_NOMBRE_DUENIO VARCHAR2(20) := 'Eneko Alonso';
BEGIN
    GEST_EQUIPO.INSERT_EQUIPO(P_NOMBRE, P_FECHA_FUNDACION, P_CIUDAD, P_ESPONSOR, 
            P_NOMBRE_DUENIO); 
END;

 -- genera error de nombre de equipo duplicado
 DECLARE
    P_NOMBRE VARCHAR2(30) := 'Gasteiz-Goya';
    P_FECHA_FUNDACION DATE := TO_DATE('23/01/2021','DD/MM/YYYY');
    P_CIUDAD VARCHAR2(30) := 'Vitoria';
    P_ESPONSOR VARCHAR2(20) := 'Goya';
    P_NOMBRE_DUENIO VARCHAR2(20) := 'Eneko Alonso';
BEGIN
    GEST_EQUIPO.INSERT_EQUIPO(P_NOMBRE, P_FECHA_FUNDACION, P_CIUDAD, P_ESPONSOR, 
            P_NOMBRE_DUENIO); 
END;

SELECT * FROM EQUIPOS;

-- **************************************************************
/*
    Procedimiento INSERT_EQUIPO: 
*/



--ROLLBACK;