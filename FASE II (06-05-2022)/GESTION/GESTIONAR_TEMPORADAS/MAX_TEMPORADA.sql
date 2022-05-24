CREATE OR REPLACE FUNCION MAX_TEMPORADA
RETURN NUMBER;
AS
DECLARE 
    max_temp NUMBER(2);
BEGIN
    SELECT MAX(cod_temporada) INTO max_temp
    FROM temporadas;
    RETURN max_temp;
EXCEPTION
   WHEN NO_DATA_FOUND THEN
        max_temp:=NULL;
        RETURN max_temp;
    WHEN TOO_MANY_ROWS THEN
        max_temp:=-1;
        RETURN max_temp;
END MAX_TEMPORADA;