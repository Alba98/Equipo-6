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
        P_NICKNAME PERSONAS.NICKNAME%TYPE,
        P_ROL JUGADORES.ROL%TYPE,
        P_NOMBRE PERSONAS.NOMBRE%TYPE,
        P_APELLIDO PERSONAS.APELLIDO%TYPE,
        P_FECHA_NACIMIENTO PERSONAS.FECHA_NACIMIENTO%TYPE,
        P_NACIONALIDAD PERSONAS.NACIONALIDAD%TYPE,
        P_SUELDO PERSONAS.SUELDO%TYPE
        );
END GEST_JUGADOR;