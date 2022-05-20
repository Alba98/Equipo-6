-- GESTIONAR_TEMPORADA_CUERPO
/* 
 Fecha: 04/05/2022
  Descripcion:  Paquete gestion de temprodas
 */
 
  
-- **************************************************************
/*
    Procedimiento INSERT_TEMPORADA: insertar un jugador insertando los datos en 
    persona
*/
CREATE OR REPLACE PROCEDURE INSERT_TEMPORADA
AS
BEGIN    
    --insertar equipo
    INSERT INTO TEMPORADAS (ABIERTA) VALUES ('S');
EXCEPTION
	WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR('-20999','Error desconocido INSERT_TEMPORADA');
END INSERT_TEMPORADA;

END GEST_TEMPORADA;