CREATE TABLE ARCHIVO2 (
 RESULTADO CLOB 
);
drop table archivo;
--------------------------------------------------------------------------------
drop type TYPE_PARTIDO force;
drop type TYPE_PARTIDOLIST force;
drop type  TYPE_JORNADA force;
--------------------------------------------------------------------------------

CREATE OR REPLACE TYPE TYPE_PARTIDO AS  OBJECT("@COD_PARTIDO" NUMBER(3),
 										   	 	"@HORA_PARTIDO" DATE,
												 NOMBRE_EQUIPO VARCHAR2(5),
												 RESULTADO VARCHAR2(3));
												 
CREATE OR REPLACE TYPE TYPE_PARTIDOLIST AS TABLE OF TYPE_PARTIDO;	

CREATE OR REPLACE TYPE TYPE_JORNADA AS OBJECT("@NUM_JORNADA" NUMBER(3),
											  "@FECHA_JORNADA" DATE,
										       JORNADAS TYPE_PARTIDOLIST);
--------------------------------------------------------------------------------
DECLARE
    contexto DBMS_XMLGEN.ctxHandle;
    RESULTADO CLOB;    
BEGIN
--get query context
contexto := DBMS_XMLGEN.newContext('SELECT TYPE_JORNADA(C.NUM_JORNADA,C.FECHA_JORNADA
                                    CAST (MULTISET 
                                         (SELECT C.COD_PARTIDO
                                    CAST (MULTISET
                                         (SELECT C.NOMBRE_EQUIPO,
                                          FROM VISTA_CLASIFICACION C
                                         FROM VISTA_CLASIFICACION C
                                    AS LISTA_JORNADAS))
                                    FROM VISTA_CLASIFICACION C
                                    AS EQUIPO_LISTA))
AS JORNADA   
FROM VISTA_CLASIFICACION C');
                                    
RESULTADO:= dbms_xmlgen.getxml(CONTEXTO);
INSERT INTO ARCHIVO2 VALUES(RESULTADO);
dbms_xmlgen.closeContext(CONTEXTO);

END;
--------------------------------------------------------------------------------
SELECT TO_CHAR(SYSDATE+2,'YYYY-MM-DD"T"HH24:MM:SS')EXPIRATION_DATE FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAP - INTERVAL '-7' DAY) FROM DUAL;