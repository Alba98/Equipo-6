

    CREATE TABLE temp_clob_tab(
    result CLOB
    );


DECLARE
    qryCTX DBMS_XMLGEN.ctxHandle;
    result CLOB;
BEGIN
qryCTX := DBMS_XMLGEN.newContext('SELECT *
                                  FROM VISTA_CLASIFICACION');
                           
    
    
DBMS_XMLGEN.setRowSetTag(qryCtx,'clasificacion');

DBMS_XMLGEN.setRowTag(qryCtx,'equipo');

result:= DBMS_XMLGEN.getXML(qryCtx);
INSERT INTO temp_clob_tab VALUES(result);

DBMS_XMLGEN.closeContext(qryCtx);

end;

SELECT * FROM temp_clob_tab;

DELETE FROM temp_clob_tab;


