-- GESTIONAR_EQUIPOS_CABECERA
/* 
 Autor: Alba Alonso Marmany
 Fecha: 04/05/2022
 Descripcion:  Porcedimientos publicos del paquete gestion de equipos

 */
 

CREATE OR REPLACE PACKAGE GEST_EQUIPO 
AS
-- **************************************************************
    /*
    Procedimiento INSERT_JUGADOR: insertar un jugador insertando los datos en 
    persona
    */
    PROCEDURE INSERT_EQUIPO(
        P_NOMBRE EQUIPOS.NOMBRE%TYPE,
        P_FECHA_FUNDACION EQUIPOS.FECHA_FUNDACION%TYPE,
        P_CIUDAD EQUIPOS.CIUDAD%TYPE,
        P_ESPONSOR EQUIPOS.ESPONSOR%TYPE,
        P_NOMBRE_DUENIO EQUIPOS.NOMBRE_DUENIO%TYPE
        );
END GEST_EQUIPO;