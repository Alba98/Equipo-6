-- GESTIONAR_ENTRENADORES_CABECERA
/* 
 Fecha: 03/05/2022
 Descripcion:  Porcedimientos publicos del paquete gestion de entrenadores
 */
 

CREATE OR REPLACE PACKAGE GEST_ENTRENADORES
AS
-- **************************************************************
    /*
    Procedimiento INSERT_PERSONA: insertar un entrenador insertando los datos en 
    persona
    */
    PROCEDURE INSERT_PERSONA(
        P_NICKNAME PERSONA.NICKNAME%TYPE,
        P_NOMBRE PERSONA.NOMBRE%TYPE,
        P_APELLIDO PERSONA.APELLIDO%TYPE,
        P_FECHA_NACIMIENTO PERSONA.FECHA_NACIMIENTO%TYPE,
        P_NACIONALIDAD PERSONA.NACIONALIDAD%TYPE,
        P_SUELDO PERSONA.SUELDO%TYPE
        );
        
END GEST_ENTRENADORES;