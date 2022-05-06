-- GESTIONAR_JUGADORES_CABECERA
/* 
 Fecha: 03/05/2022
 Descripcion:  Porcedimientos publicos del paquete gestion de jugadores
 */
 

CREATE OR REPLACE PACKAGE GEST_JUGADOR 
AS
-- **************************************************************
    /*
    Procedimiento INSERT_JUGADOR: insertar un jugador insertando los datos en 
    persona
    */
    PROCEDURE INSERT_PERSONA(
        P_NICKNAME PERSONA.NICKNAME%TYPE,
        P_ROL JUGADORES.ROL%TYPE,
        P_NOMBRE PERSONA.NOMBRE%TYPE,
        P_APELLIDO PERSONA.APELLIDO%TYPE,
        P_FECHA_NACIMIENTO PERSONA.FECHA_NACIMIENTO%TYPE,
        P_NACIONALIDAD PERSONA.NACIONALIDAD%TYPE,
        P_SUELDO PERSONA.SUELDO%TYPE
        );
END GEST_JUGADOR;