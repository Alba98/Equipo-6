-- GESTIONAR_USUARIOS_CABECERA
/* 
 Fecha: 03/05/2022
 Descripcion:  Porcedimientos publicos del paquete gestion de usuaios

 */
 

CREATE OR REPLACE PACKAGE GEST_USUARIOS
AS
-- **************************************************************
    /*
    Procedimiento INSERT_USUARIO: insertar usuario nuevo
    */
    PROCEDURE INSERT_USUARIO(
        P_NOMBRE USUARIOS.NOMBRE%TYPE,
        P_FECHA_NACIMIENTO USUARIOS.FECHA_NACIMIENTO%TYPE,
        P_PASSWORD USUARIOS.PASSWORD_%TYPE,
        P_EMAIL USUARIOS.EMAIL%TYPE
        );
        
    PROCEDURE INSERT_ADMINISTRADOR(
        P_NOMBRE USUARIOS.NOMBRE%TYPE,
        P_FECHA_NACIMIENTO USUARIOS.FECHA_NACIMIENTO%TYPE,
        P_PASSWORD USUARIOS.PASSWORD_%TYPE,
        P_EMAIL USUARIOS.EMAIL%TYPE
        );
        
END GEST_USUARIOS;