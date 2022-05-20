-- GESTIONAR_ASISTENTES_CUERPO
/* 
 Fecha: 03/05/2022
 Descripcion:  Paquete gestion de asistentes
*/

CREATE OR REPLACE PACKAGE BODY GEST_ASISTENTES AS

FUNCTION BUSCAR_PERSONA_POR_NICKNAME
    (P_NICKNAME VARCHAR2)
	  RETURN NUMBER;
      
-- **************************************************************
-- Programacion de la funcion
FUNCTION  BUSCAR_PERSONA_POR_NICKNAME
    (P_NICKNAME VARCHAR2)
    RETURN NUMBER
    AS
        P_COD_PERSONA PERSONAS.COD_PERSONA%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_PERSONA INTO P_COD_PERSONA
        FROM PERSONAS
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
Procedimiento INSERT_ASISTENTE: insertar un asistente tras haber sido 
insertados sus datos en personas
*/
PROCEDURE INSERT_ASISTENTE(
	P_NICKNAME PERSONAS.NICKNAME%TYPE,
    P_NICKNAME_ENTRENADOR PERSONAS.NICKNAME%TYPE)
AS
    V_COD_ASISTENTE NUMBER;
    ASISTENTE_NO_ENCONTRADA EXCEPTION;
    
    V_COD_ENTRENADOR NUMBER;
    ENTRENADOR_NO_ENCONTRADA EXCEPTION;   
BEGIN
	-- comprobando que existe una persona con ese nickname
    V_COD_ASISTENTE := BUSCAR_PERSONA_POR_NICKNAME(P_NICKNAME);
    
    IF (V_COD_ASISTENTE IS NULL)
    THEN      
        RAISE ASISTENTE_NO_ENCONTRADA;
    ELSE 
        V_COD_ENTRENADOR := BUSCAR_PERSONA_POR_NICKNAME(P_NICKNAME_ENTRENADOR);
    
        IF (V_COD_ENTRENADOR IS NULL)
        THEN      
            RAISE ENTRENADOR_NO_ENCONTRADA;
        ELSE 
             --insertar el asistente
            INSERT INTO ASISTENTES (COD_ASISTENTE, COD_ENTRE_ASOCIADO) 
            VALUES (V_COD_ASISTENTE, V_COD_ENTRENADOR);
        END IF; 
    END IF;   

EXCEPTION
    WHEN ASISTENTE_NO_ENCONTRADA THEN
        RAISE_APPLICATION_ERROR (-20011 ,'Err. la persona q intenta insertar 
            como asistente no existe');
    WHEN ENTRENADOR_NO_ENCONTRADA THEN
        RAISE_APPLICATION_ERROR (-20010 ,'Err. la persona q intenta insertar 
            como entrenador no existe');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido');
END INSERT_ASISTENTE;

-- **************************************************************
/*
Procedimiento INSERT_PERSONA: insertar un asistente insertando los datos en 
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
        )
AS
    V_COD_ASISTENTE NUMBER;
    DUP_VAL_ON_INDEX EXCEPTION;
BEGIN
	-- comprobando que no existe otra persona con ese nickname
    V_COD_ASISTENTE := BUSCAR_PERSONA_POR_NICKNAME(P_NICKNAME);
    
    IF (V_COD_ASISTENTE IS NULL)
    THEN      
        --insertar persona
        INSERT INTO PERSONAS (NICKNAME, NOMBRE, APELLIDO, FECHA_NACIMIENTO, 
            NACIONALIDAD, SUELDO)
        VALUES (UPPER(P_NICKNAME), UPPER(P_NOMBRE), UPPER(P_APELLIDO), 
            P_FECHA_NACIMIENTO, UPPER(P_NACIONALIDAD), P_SUELDO);
        -- insertar entrenador
        INSERT_ASISTENTE(P_NICKNAME, P_NICKNAME_ENTRENADOR);
    ELSE
        RAISE DUP_VAL_ON_INDEX;
    END IF;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR (-20007 ,'Err. nickname duplicado');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido');
END INSERT_PERSONA;

END GEST_ASISTENTES;