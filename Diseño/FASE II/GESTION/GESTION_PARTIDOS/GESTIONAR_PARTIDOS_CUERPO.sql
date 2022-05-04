-- GESTIONAR_PARTIDOS_CUERPO
/* 
 Autor: Alba Alonso Marmany
 Fecha: 04/05/2022
  Descripcion:  Paquete gestion de partidos
 */
 
CREATE OR REPLACE PACKAGE BODY GEST_PARTIDOS AS

FUNCTION  BUSCAR_PARTIDO_POR_NOMBRE
    (P_NOMBRE VARCHAR2)
    RETURN NUMBER;
      
-- **************************************************************
-- Programacion de la funcion
FUNCTION  BUSCAR_PARTIDO_POR_NOMBRE
    (P_NOMBRE VARCHAR2)
    RETURN NUMBER
    AS
        P_COD_PARTIDO EQUIPOS.COD_EQUIPO%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_EQUIPO INTO P_COD_PARTIDO
        FROM EQUIPOS
        WHERE UPPER(NOMBRE) = UPPER(P_NOMBRE);
        -- devolver el codigo de la persona
        RETURN P_COD_PARTIDO;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    -- lleno P_NUM_PERSONA con null para que mi funcion indique que no existe el
    -- nickname en la base de datos
        P_COD_PARTIDO:=NULL;
        RETURN P_COD_PARTIDO;
        
    WHEN TOO_MANY_ROWS THEN
    -- lleno P_NUM_PERSONA con -1 para que mi funcion indique que existe mas de 
    -- una pesrona con el mismo nickname
        P_COD_PARTIDO:=-1;
        RETURN P_COD_PARTIDO;
END BUSCAR_PARTIDO_POR_NOMBRE;

-- **************************************************************
/*
Procedimiento INSERT_JORNADA: insertar una jornada
*/
PROCEDURE INSERT_PARTIDO(
        P_HORA_PARTIDO PARTIDOS.HORA_PARTIDO%TYPE,
        P_COD_JORNADA PARTIDOS.COD_JORNADA%TYPE,
        P_EQUIPO1 EQUIPOS.NOMBRE%TYPE,
        P_EQUIPO2 EQUIPOS.NOMBRE%TYPE
        )
AS
    V_COD_TEMPORADA NUMBER;
    V_COD_EQUIPO1 NUMBER;
    V_COD_EQUIPO2 NUMBER;
BEGIN
	-- comprobando que no existe otra equipo con ese nombre
    V_COD_EQUIPO1 := BUSCAR_PARTIDO_POR_NOMBRE(P_EQUIPO1);
    V_COD_EQUIPO2 := BUSCAR_PARTIDO_POR_NOMBRE(P_EQUIPO2);
    /*
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
    */
    NULL;
EXCEPTION
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20998','Error desconocido');
END INSERT_PARTIDO;

-- **************************************************************
/*
Procedimiento INSERT_RESULTADO: insertar resultado de un partido
*/
PROCEDURE INSERT_RESULTADO(
    P_COD_PARTIDO PARTIDOS.COD_PARTIDO%TYPE,
    P_RESULTADO PARTIDOS.RESULTADO%TYPE
    )
AS
    PARTIDO_NO_EXISTE EXCEPTION;
BEGIN
    UPDATE PARTIDOS 
    SET RESULTADO = P_RESULTADO
    WHERE COD_PARTIDO = P_COD_PARTIDO;
    
    IF SQL%NOTFOUND
    THEN
        RAISE PARTIDO_NO_EXISTE; 
    END IF;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR('-20003' ,'Err. partida no existe');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido');
END INSERT_RESULTADO;

END GEST_PARTIDOS;