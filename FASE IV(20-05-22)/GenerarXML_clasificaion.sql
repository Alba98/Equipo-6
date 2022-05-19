CREATE TABLE ARCHIVO (
 RESULTADO CLOB 
);
drop table archivo;
--------------------------------------------------------------------------------
drop type JUGADOR force;
drop type JUGADORES_LISTA force;
drop type EQUIPO force;
drop type EQUIPO_LISTA force;
drop type TEMPORADA force;
--------------------------------------------------------------------------------
CREATE OR REPLACE TYPE JUGADOR AS OBJECT ( NICKNAME VARCHAR2(10),
                                            ROL VARCHAR2(4));  

CREATE OR REPLACE TYPE  JUGADORES_LISTA  AS TABLE OF  JUGADOR;

CREATE OR REPLACE TYPE EQUIPO AS OBJECT ("@COD_EQUIPO" NUMBER(2),--COD_EQUIPO DEFINED AS ATTRIBUTE
                                           NOMBRE VARCHAR2(15),
                                           LISTA_JUGADORES JUGADORES_LISTA);

CREATE OR REPLACE TYPE  EQUIPO_LISTA  AS TABLE OF  EQUIPO; 

CREATE OR REPLACE TYPE TEMPORADA AS OBJECT ("@COD_TEMPORADA" NUMBER(2),--COD_TEMPORADA DEFINED AS ATTRIBUTE
                                            LISTA_EQUIPOS  EQUIPO_LISTA);
--------------------------------------------------------------------------------
DECLARE
    contexto DBMS_XMLGEN.ctxHandle;
    RESULTADO CLOB;    
BEGIN
--get query context
contexto := DBMS_XMLGEN.newContext('SELECT TEMPORADA(C.COD TEMPORADA,
                                    CAST (MULTISET
                                         (SELECT EQUIPO(C.COD_EQUIPO,
                                    CAST (MULTISET
                                         (SELECT C.NOMBRE,
                                          FROM VISTA_CLASIFICACION C
                                    CAST (MULTISET
                                          (SELECT JUGADOR(C.NICKNAME, C.ROL
                                          FROM VISTA_CLASIFICACION C
                                          AS DATOS_JUGADORES_LISTA))
                                    FROM VISTA_CLASIFICACION C
                                    AS JUGADOR_LISTA))
                                    FROM VISTA_CLASIFICACION C
                                    AS EQUIPO_LISTA))
AS TEMPORADA
FROM VISTA_CLASIFICACION C');
                                    
RESULTADO:= dbms_xmlgen.getxml(CONTEXTO);
INSERT INTO ARCHIVO VALUES(RESULTADO);
dbms_xmlgen.closeContext(CONTEXTO);

END;

--------------------------------------------------------------------------------

SELECT TO_CHAR(SYSDATE+2,'YYYY-MM-DD"T"HH24:MM:SS')EXPIRATION_DATE FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAP - INTERVAL '-7' DAY) FROM DUAL;




                                    
                                             
                                     
        





   
   

   
                                           















