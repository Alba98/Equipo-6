-- GESTIONAR_ASISTENTES_CABECERA
/* 
 Autor: Alba Alonso Marmany
 Fecha: 03/05/2022
 Descripcion:  Porcedimientos publicos del paquete gestion de asistentes

 */
 

CREATE OR REPLACE PACKAGE GEST_ASISTENTES
AS
-- **************************************************************
    /*
    Procedimiento INSERT_PERSONA: insertar un asistentes insertando los datos en 
    persona
    */
    PROCEDURE INSERT_PERSONA(
        P_NICKNAME PERSONA.NICKNAME%TYPE,
        P_NOMBRE PERSONA.NOMBRE%TYPE,
        P_APELLIDO PERSONA.APELLIDO%TYPE,
        P_FECHA_NACIMIENTO PERSONA.FECHA_NACIMIENTO%TYPE,
        P_NACIONALIDAD PERSONA.NACIONALIDAD%TYPE,
        P_SUELDO PERSONA.SUELDO%TYPE,
        P_NICKNAME_ENTRENADOR PERSONA.NICKNAME%TYPE
        );
        
END GEST_ASISTENTES;