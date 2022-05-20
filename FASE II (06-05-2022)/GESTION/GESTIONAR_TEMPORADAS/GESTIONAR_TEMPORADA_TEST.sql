-- GESTIONAR_TEMPORADA_TEST
/* 
 Fecha: 03/05/2022
 Descripcion:  Testeo paquete gestion de temporadas

 */
 
SET SERVEROUTPUT ON;

-- **************************************************************
/*
    Procedimiento INSERT_EQUIPO: 
*/
BEGIN
    INSERT_TEMPORADA(); 
END;

SELECT * FROM TEMPORADAS;

--ROLLBACK;