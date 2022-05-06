-- GESTIONAR_PARTIDOS_CABECERA
/* 
 Fecha: 04/05/2022
 Descripcion:  Porcedimientos publicos del paquete gestion de partidos
 */
 

CREATE OR REPLACE PACKAGE GEST_PARTIDOS
AS
-- **************************************************************
    /*
    Procedimiento INSERT_PARTIDO: insertar un nuevo partido
    */
    PROCEDURE INSERT_PARTIDO(
        P_HORA_PARTIDO PARTIDOS.HORA_PARTIDO%TYPE,
        P_COD_JORNADA PARTIDOS.COD_JORNADA%TYPE,
        P_EQUIPO1 EQUIPOS.NOMBRE%TYPE,
        P_EQUIPO2 EQUIPOS.NOMBRE%TYPE
        );
-- **************************************************************
    /*
    Procedimiento INSERT_RESULTADO: insertar resultado de un partido
    */        
    PROCEDURE INSERT_RESULTADO(
        P_COD_PARTIDO PARTIDOS.COD_PARTIDO%TYPE,
        P_RESULTADO PARTIDOS.RESULTADO%TYPE
        );
END GEST_PARTIDOS;