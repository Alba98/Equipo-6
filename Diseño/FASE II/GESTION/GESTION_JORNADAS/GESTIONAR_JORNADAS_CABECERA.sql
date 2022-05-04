-- GESTIONAR_JORNADAS_CABECERA
/* 
 Autor: Alba Alonso Marmany
 Fecha: 04/05/2022
 Descripcion:  Porcedimientos publicos del paquete gestion de jornadas

 */
 

CREATE OR REPLACE PACKAGE GEST_JORNADAS 
AS
-- **************************************************************
    /*
    Procedimiento INSERT_JORNADA: insertar una nueva jornada
    */
    PROCEDURE INSERT_JORNADA(
        P_COD_TEMPORADA JORNADAS.COD_TEMPORADA%TYPE,
        P_FECHA_JORNADA JORNADAS.FECHA_JORNADA%TYPE
        );
END GEST_JORNADAS;