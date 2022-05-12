-- GESTIONAR_ASISTENTES_CABECERA
/* 
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
        P_NICKNAME PERSONAS.NICKNAME%TYPE,
        P_NOMBRE PERSONAS.NOMBRE%TYPE,
        P_APELLIDO PERSONAS.APELLIDO%TYPE,
        P_FECHA_NACIMIENTO PERSONAS.FECHA_NACIMIENTO%TYPE,
        P_NACIONALIDAD PERSONAS.NACIONALIDAD%TYPE,
        P_SUELDO PERSONAS.SUELDO%TYPE,
        P_NICKNAME_ENTRENADOR PERSONAS.NICKNAME%TYPE
        );
        
END GEST_ASISTENTES;