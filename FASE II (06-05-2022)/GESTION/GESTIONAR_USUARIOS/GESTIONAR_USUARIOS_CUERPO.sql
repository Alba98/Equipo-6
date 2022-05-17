-- GESTIONAR_USUARIOS_CUERPO
/* 
 Fecha: 17/05/2022
 Descripcion:  Paquete gestion de usuarios
*/

CREATE OR REPLACE PACKAGE BODY GEST_USUARIOS AS

FUNCTION BUSCAR_USUARIO_POR_EMAIL
    (P_EMAIL VARCHAR2)
	  RETURN NUMBER;
      
-- **************************************************************
-- Programacion de la funcion
FUNCTION  BUSCAR_USUARIO_POR_EMAIL
    (P_EMAIL VARCHAR2)
    RETURN NUMBER
    AS
        P_COD_USUARIO USUARIOS.COD_USUARIO%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_USUARIO INTO P_COD_USUARIO
        FROM USUARIOS
        WHERE UPPER(EMAIL) = UPPER(P_EMAIL);
        -- devolver el codigo de la persona
        RETURN P_COD_USUARIO;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    -- lleno P_COD_USUARIO con null para que mi funcion indique que no existe el
    -- email en la base de datos
        P_COD_USUARIO:=NULL;
        RETURN P_COD_USUARIO;
        
    WHEN TOO_MANY_ROWS THEN
    -- lleno P_COD_USUARIO con -1 para que mi funcion indique que existe mas de 
    -- una pesrona con el mismo email
        P_COD_USUARIO:=-1;
        RETURN P_COD_USUARIO;
END BUSCAR_USUARIO_POR_EMAIL;

-- **************************************************************
    /*
    Procedimiento INSERT_USUARIO: insertar usuario nuevo
    */
PROCEDURE INSERT_USUARIO(
        P_NOMBRE USUARIOS.NOMBRE%TYPE,
        P_FECHA_NACIMIENTO USUARIOS.FECHA_NACIMIENTO%TYPE,
        P_PASSWORD USUARIOS.PASSWORD_%TYPE,
        P_EMAIL USUARIOS.EMAIL%TYPE
        )
AS
    V_COD_USUARIO NUMBER;
    DUP_VAL_ON_INDEX EXCEPTION;
BEGIN
	-- comprobando que no existe otra usuario con ese correo
    V_COD_USUARIO := BUSCAR_USUARIO_POR_EMAIL(P_EMAIL);
    
    IF (V_COD_USUARIO IS NULL)
    THEN      
        --insertar persona
        INSERT INTO USUARIOS (NOMBRE, FECHA_NACIMIENTO, PASSWORD_, EMAIL, COD_ROL)
        VALUES (UPPER(P_NOMBRE), P_FECHA_NACIMIENTO, P_PASSWORD, P_EMAIL, '02');
    ELSE
        RAISE DUP_VAL_ON_INDEX;
    END IF;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR (-20054 ,'Err. email duplicado');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20999,'Error desconocido');
END INSERT_USUARIO;

-- **************************************************************
    /*
    Procedimiento INSERT_ADMINISTRADOR: insertar administrador nuevo
    */
PROCEDURE INSERT_ADMINISTRADOR(
        P_NOMBRE USUARIOS.NOMBRE%TYPE,
        P_FECHA_NACIMIENTO USUARIOS.FECHA_NACIMIENTO%TYPE,
        P_PASSWORD USUARIOS.PASSWORD_%TYPE,
        P_EMAIL USUARIOS.EMAIL%TYPE
        )
AS
    V_COD_USUARIO NUMBER;
    DUP_VAL_ON_INDEX EXCEPTION;
BEGIN
	-- comprobando que no existe otra usuario con ese correo
    V_COD_USUARIO := BUSCAR_USUARIO_POR_EMAIL(P_EMAIL);
    
    IF (V_COD_USUARIO IS NULL)
    THEN      
        --insertar persona
        INSERT INTO USUARIOS (NOMBRE, FECHA_NACIMIENTO, PASSWORD_, EMAIL, COD_ROL)
        VALUES (UPPER(P_NOMBRE), P_FECHA_NACIMIENTO, P_PASSWORD, P_EMAIL, '01');
    ELSE
        RAISE DUP_VAL_ON_INDEX;
    END IF;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR (-20054 ,'Err. email duplicado');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20999,'Error desconocido');
END INSERT_ADMINISTRADOR;

END GEST_USUARIOS;
