-- GESTIONAR_EQUIPOS_CUERPO
/* 
 Fecha: 04/05/2022
  Descripcion:  Paquete gestion de equipo
 */
 
CREATE OR REPLACE PACKAGE BODY GEST_EQUIPO AS


FUNCTION BUSCAR_EQUIPO_POR_NOMBRE
    (P_NOMBRE VARCHAR2)
	  RETURN NUMBER;
      
-- **************************************************************
-- Programacion de la funcion
FUNCTION  BUSCAR_EQUIPO_POR_NOMBRE
    (P_NOMBRE VARCHAR2)
    RETURN NUMBER
    AS
        P_COD_EQUIPO EQUIPOS.COD_EQUIPO%TYPE;
    BEGIN
        -- Comprobar que existe la persona
        SELECT COD_EQUIPO INTO P_COD_EQUIPO
        FROM EQUIPOS
        WHERE UPPER(NOMBRE) = UPPER(P_NOMBRE);
        -- devolver el codigo de la persona
        RETURN P_COD_EQUIPO;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    -- lleno P_NUM_PERSONA con null para que mi funcion indique que no existe el
    -- nickname en la base de datos
        P_COD_EQUIPO:=NULL;
        RETURN P_COD_EQUIPO;
        
    WHEN TOO_MANY_ROWS THEN
    -- lleno P_NUM_PERSONA con -1 para que mi funcion indique que existe mas de 
    -- una pesrona con el mismo nickname
        P_COD_EQUIPO:=-1;
        RETURN P_COD_EQUIPO;
END BUSCAR_EQUIPO_POR_NOMBRE;


-- **************************************************************
/*
Procedimiento INSERT_JUGADOR: insertar un equipo
*/
PROCEDURE INSERT_EQUIPO(
        P_NOMBRE EQUIPOS.NOMBRE%TYPE,
        P_FECHA_FUNDACION EQUIPOS.FECHA_NACIMIENTO%TYPE,
        P_CIUDAD EQUIPOS.CIUDAD%TYPE,
        P_ESPONSOR EQUIPOS.ESPONSOR%TYPE,
        P_NOMBRE_DUENIO EQUIPOS.NOMBRE_DUENIO%TYPE
        )
AS
    V_COD_EQUIPO NUMBER;
    DUP_VAL_ON_INDEX EXCEPTION;
BEGIN
	-- comprobando que no existe otra equipo con ese nombre
    V_COD_EQUIPO := BUSCAR_EQUIPO_POR_NOMBRE(P_NOMBRE);
    
    IF (V_COD_EQUIPO IS NULL)
    THEN      
        --insertar equipo
        INSERT INTO EQUIPOS (NOMBRE, FECHA_NACIMIENTO, CIUDAD, ESPONSOR,
            NOMBRE_DUENIO)
        VALUES (UPPER(P_NOMBRE), P_FECHA_FUNDACION, UPPER(P_CIUDAD), 
            UPPER(P_ESPONSOR), UPPER(P_NOMBRE_DUENIO));
    ELSE
        RAISE DUP_VAL_ON_INDEX;
    END IF;
    
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        RAISE_APPLICATION_ERROR (-20003 ,'Err. nombre de equipo duplicado');
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido INSERT_EQUIPO');
END INSERT_EQUIPO;

-- **************************************************************
    /*
Procedimiento CONTRATO_JUGADOR: suponemos q sabemos cada codigo asociado al nombre
xq en java le ofrecemos los nombres directamente
    */    
PROCEDURE CONTRATO_JUGADOR(
        P_COD_JUGADOR JUGAR_PARA.COD_JUGADOR%TYPE,
        P_COD_EQUIPO JUGAR_PARA.COD_EQUIPO%TYPE,
        P_FECHA_FIN JUGAR_PARA.FECHA_FIN%TYPE,
        P_FECHA_INICIO JUGAR_PARA.FECHA_INICIO%TYPE 
        )
AS
BEGIN    
    --insertar equipo
    INSERT INTO JUGAR_PARA (COD_JUGADOR,COD_EQUIPO,FECHA_FIN,FECHA_INICIO)
    VALUES (P_COD_JUGADOR, P_COD_EQUIPO, P_FECHA_FIN, P_FECHA_INICIO);   
EXCEPTION
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido CONTRATO_JUGADOR');
END CONTRATO_JUGADOR;

-- **************************************************************
    /*
Procedimiento CONTRATO_ENTRENADOR: suponemos q sabemos cada codigo asociado al nombre
xq en java le ofrecemos los nombres directamente
    */        
PROCEDURE CONTRATO_ENTRENADOR(
        P_COD_ENTRENADOR ENTRENA.COD_ENTRENADOR%TYPE,
        P_COD_EQUIPO ENTRENA.COD_EQUIPO%TYPE,
        P_FECHA_FIN ENTRENA.FECHA_FIN%TYPE,
        P_FECHA_INICIO ENTRENA.FECHA_INICIO%TYPE 
        )
AS
BEGIN    
    --insertar equipo
    INSERT INTO ENTRENA (COD_ENTRENADOR,COD_EQUIPO,FECHA_FIN,FECHA_INICIO)
    VALUES (P_COD_ENTRENADOR, P_COD_EQUIPO, P_FECHA_FIN, P_FECHA_INICIO);   
EXCEPTION
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido CONTRATO_ENTRENADOR');
END CONTRATO_ENTRENADOR;

END GEST_EQUIPO;