-- GESTIONAR_JORNADAS_CUERPO
/* 
 Autor: Alba Alonso Marmany
 Fecha: 04/05/2022
  Descripcion:  Paquete gestion de jornadas
 */
 
CREATE OR REPLACE PACKAGE BODY GEST_JORNADAS AS

FUNCTION EXISTE_TEMPORADA
    (P_COD_TEMPORADA VARCHAR2)
	  RETURN NUMBER;
      
-- **************************************************************
-- Programacion de la funcion
FUNCTION  EXISTE_TEMPORADA
    (P_COD_TEMPORADA VARCHAR2)
    RETURN NUMBER
    AS
        V_COD_PERSONA PERSONA.COD_PERSONA%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_TEMPORADA INTO V_COD_PERSONA
        FROM JORNADAS
        WHERE COD_TEMPORADA = P_COD_TEMPORADA;
        -- devolver el codigo de la persona
        RETURN V_COD_PERSONA;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    -- lleno P_NUM_PERSONA con null para que mi funcion indique que no existe el
    -- nickname en la base de datos
        V_COD_PERSONA:=NULL;
        RETURN V_COD_PERSONA;
        
    WHEN TOO_MANY_ROWS THEN
    -- lleno P_NUM_PERSONA con -1 para que mi funcion indique que existe mas de 
    -- una pesrona con el mismo nickname
        V_COD_PERSONA:=-1;
        RETURN V_COD_PERSONA;
END EXISTE_TEMPORADA;

-- **************************************************************
/*
Procedimiento INSERT_JORNADA: insertar una jornada
*/
PROCEDURE INSERT_JORNADA(
        P_COD_TEMPORADA JORNADAS.COD_TEMPORADA%TYPE,
        P_FECHA_JORNADA JORNADAS.FECHA_JORNADA%TYPE
        )
AS
    V_COD_TEMPORADA NUMBER;
    TEMPORADA_NO_EXISTE EXCEPTION;
    DUP_VAL_ON_INDEX EXCEPTION;
BEGIN
	-- comprobando que no existe otra equipo con ese nombre
    V_COD_TEMPORADA := EXISTE_TEMPORADA(P_COD_TEMPORADA);
    
    IF (V_COD_TEMPORADA IS NULL)
    THEN 
        RAISE TEMPORADA_NO_EXISTE;
    ELSIF (V_COD_TEMPORADA = -1)
    THEN
        RAISE DUP_VAL_ON_INDEX;
    ELSE
       --insertar jornada
        INSERT INTO JORNADAS(COD_TEMPORADA, FECHA_JORNADA)
        VALUES (P_COD_TEMPORADA, P_FECHA_JORNADA);
    END IF;
    
    NULL;
EXCEPTION
    WHEN TEMPORADA_NO_EXISTE THEN
        RAISE_APPLICATION_ERROR ('-20004' ,'Err. temporada inexistent');
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR ('-20003' ,'Err. nombre de equipo duplicado');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20998','Error desconocido');
END INSERT_JORNADA;

END GEST_JORNADAS;