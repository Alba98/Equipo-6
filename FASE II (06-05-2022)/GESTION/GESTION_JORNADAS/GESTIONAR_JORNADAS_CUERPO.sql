-- GESTIONAR_JORNADAS_CUERPO
/* 
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
        V_COD_TEMPORADA TEMPORADAS.COD_TEMPORADA%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_TEMPORADA INTO V_COD_TEMPORADA
        FROM TEMPORADAS
        WHERE COD_TEMPORADA = P_COD_TEMPORADA;
        -- devolver el codigo de la persona
        RETURN V_COD_TEMPORADA;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    -- lleno P_NUM_PERSONA con null para que mi funcion indique que no existe el
    -- nickname en la base de datos
        V_COD_TEMPORADA:=NULL;
        RETURN V_COD_TEMPORADA;
        
    WHEN TOO_MANY_ROWS THEN
    -- lleno P_NUM_PERSONA con -1 para que mi funcion indique que existe mas de 
    -- una pesrona con el mismo nickname
        V_COD_TEMPORADA:=-1;
        RETURN V_COD_TEMPORADA;
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
    NO_EQUIPOS EXCEPTION;
    v_count number;
    p_fecha_resultado date:= p_fecha_jornada;
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
       
            Select count(*) into v_count from equipos;
            
            if(v_count = 0)
            THEN 
                 RAISE NO_EQUIPOS;
            END IF;
            
            v_count:= v_count -1;

            for cod_jornada in 0 .. v_count loop

                p_fecha_resultado := p_fecha_resultado + 7;
    
                Insert INTO jornadas(fecha_jornada, cod_temporada) values (p_fecha_resultado, p_cod_temporada);

            end loop;
    END IF;
    
    NULL;
EXCEPTION
    WHEN NO_EQUIPOS THEN
        RAISE_APPLICATION_ERROR ('-20044' ,'Err. equipos insuficintes para generar jornadas');
    WHEN TEMPORADA_NO_EXISTE THEN
        RAISE_APPLICATION_ERROR ('-20045' ,'Err. temporada inexistente');
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR ('-20046' ,'Err. jornada duplicada');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20998','Error desconocido');
END INSERT_JORNADA;

END GEST_JORNADAS;