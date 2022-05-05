-- GESTIONAR_EQUIPOS_CABECERA
/* 
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
        P_FECHA_FUNDACION EQUIPOS.FECHA_NACIMIENTO%TYPE,
        P_CIUDAD EQUIPOS.CIUDAD%TYPE,
        P_ESPONSOR EQUIPOS.ESPONSOR%TYPE,
        P_NOMBRE_DUENIO EQUIPOS.NOMBRE_DUENIO%TYPE
        );
        
-- **************************************************************
/*
Procedimiento CONTRATO_JUGADOR: suponemos q sabemos cada codigo asociado al nombre
xq en java le ofrecemos los nombres directamente
*/        
     PROCEDURE CONTRATO_JUGADOR(
        P_COD_JUGADOR JUGAR_PARA.COD_JUGADOR%TYPE,
        P_COD_EQUIPO JUGAR_PARA.COD_EQUIPO%TYPE,
        P_FECHA_FIN JUGAR_PARA.FECHA_FIN%TYPE,
        P_FECHA_INICIO JUGAR_PARA.FECHA_INICIO%TYPE 
        );
    
-- **************************************************************
 /*
Procedimiento CONTRATO_ENTRENADOR: suponemos q sabemos cada codigo asociado al nombre
xq en java le ofrecemos los nombres directamente
*/        
     PROCEDURE CONTRATO_ENTRENADOR(
        P_COD_ENTRENADOR ENTRENA.COD_ENTRENADOR%TYPE,
        P_COD_EQUIPO ENTRENA.COD_EQUIPO%TYPE,
        P_FECHA_FIN ENTRENA.FECHA_FIN%TYPE,
        P_FECHA_INICIO ENTRENA.FECHA_INICIO%TYPE 
        );
        
-- **************************************************************
/*
Procedimiento CONTRATO_ASISTENTE: suponemos q sabemos cada codigo asociado al nombre
xq en java le ofrecemos los nombres directamente
    */        
PROCEDURE CONTRATO_ASISTENTE(
        P_COD_ASISTENTE ASISTE.COD_ASISTENTE%TYPE,
        P_COD_EQUIPO ASISTE.COD_EQUIPO%TYPE,
        P_FECHA_FIN ASISTE.FECHA_FIN%TYPE,
        P_FECHA_INICIO ASISTE.FECHA_INICIO%TYPE 
        );
        
END GEST_EQUIPO;