-- GESTIONAR_JUGADORES_CUERPO
/* 
 Fecha: 03/05/2022
 Descripcion:  Paquete gestion de jugadores
*/
 
CREATE OR REPLACE PACKAGE BODY GEST_JUGADOR AS

FUNCTION BUSCAR_PERSONA_POR_NICKNAME
    (P_NICKNAME VARCHAR2)
	  RETURN NUMBER;
      
-- **************************************************************
-- Programacion de la funcion
FUNCTION  BUSCAR_PERSONA_POR_NICKNAME
    (P_NICKNAME VARCHAR2)
    RETURN NUMBER
    AS
        P_COD_PERSONA PERSONA.COD_PERSONA%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_PERSONA INTO P_COD_PERSONA
        FROM PERSONA
        WHERE UPPER(NICKNAME) = UPPER(P_NICKNAME);
        -- devolver el codigo de la persona
        RETURN P_COD_PERSONA;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    -- lleno P_NUM_PERSONA con null para que mi funcion indique que no existe el
    -- nickname en la base de datos
        P_COD_PERSONA:=NULL;
        RETURN P_COD_PERSONA;
        
    WHEN TOO_MANY_ROWS THEN
    -- lleno P_NUM_PERSONA con -1 para que mi funcion indique que existe mas de 
    -- una pesrona con el mismo nickname
        P_COD_PERSONA:=-1;
        RETURN P_COD_PERSONA;
END BUSCAR_PERSONA_POR_NICKNAME;

-- **************************************************************
/*
Procedimiento INSERT_JUGADOR: insertar un jugador tras haber sido insertados 
sus datos en personas
*/
PROCEDURE INSERT_JUGADOR(
	P_NICKNAME PERSONA.NICKNAME%TYPE,
	P_ROL JUGADORES.ROL%TYPE)
AS
    V_COD_JUGADOR NUMBER;
    PERSONA_NO_ENCONTRADA EXCEPTION;
BEGIN
	-- comprobando que existe una persona con ese nickname
    V_COD_JUGADOR := BUSCAR_PERSONA_POR_NICKNAME(P_NICKNAME);

    IF (V_COD_JUGADOR IS NULL)
    THEN      
        RAISE PERSONA_NO_ENCONTRADA;
    ELSE 
         --insertar el jugador
        INSERT INTO JUGADORES (COD_JUGADOR, ROL) 
        VALUES (V_COD_JUGADOR, UPPER(P_ROL));
    END IF;   

EXCEPTION
    WHEN PERSONA_NO_ENCONTRADA THEN
        RAISE_APPLICATION_ERROR (-20001 ,'Err. la persona q intenta insertar 
            como jugador no existe');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido');
END INSERT_JUGADOR;

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
        )
AS
    V_COD_JUGADOR NUMBER;
    DUP_VAL_ON_INDEX EXCEPTION;
BEGIN
	-- comprobando que no existe otra persona con ese nickname
    V_COD_JUGADOR := BUSCAR_PERSONA_POR_NICKNAME(P_NICKNAME);
    
    IF (V_COD_JUGADOR IS NULL)
    THEN      
        --insertar persona
        INSERT INTO PERSONA (NICKNAME, NOMBRE, APELLIDO, FECHA_NACIMIENTO, 
            NACIONALIDAD, SUELDO)
        VALUES (UPPER(P_NICKNAME), UPPER(P_NOMBRE), UPPER(P_APELLIDO), 
            P_FECHA_NACIMIENTO, UPPER(P_NACIONALIDAD), P_SUELDO);
        -- insertar jugador
       INSERT_JUGADOR(P_NICKNAME, P_ROL);
    ELSE
        RAISE DUP_VAL_ON_INDEX;
    END IF;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR (-20033 ,'Err. nickname jugador duplicado');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20998','Error desconocido');
END INSERT_PERSONA;

END GEST_JUGADOR;