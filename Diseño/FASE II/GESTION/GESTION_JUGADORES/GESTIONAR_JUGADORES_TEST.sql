-- GESTIONAR_JUGADORES_TEST
/* 
 Autor: Alba Alonso Marmany
 Fecha: 03/05/2022
 Descripcion:  Testeo paquete gestion de jugadores

 */
 
SET SERVEROUTPUT ON;
BEGIN
    
    GEST_DEPART.INSERT_PERSONA_JUGADOR('The_Core','TOP', 'DARCY', 'Wuenz', TO_DATE('14/5/2001'), 'Taiwanesa', 2000);
        
    GEST_DEPART.INSERT_PERSONA_JUGADOR('LINN','TOP', 'DARCY', 'Wuenz', TO_DATE('14/5/2001'), 'Taiwanesa', 2000);
    
    SELECT * FROM PERSONA;
    SELECT * FROM JUGADORES;
END;


   ROLLBACK;