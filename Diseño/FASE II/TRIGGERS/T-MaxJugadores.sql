

 CREATE OR REPLACE TRIGGER MaxJugadores
 
    BEFORE  INSERT ON JUGADORES
    
     FOR EACH ROW 
     
     DECLARE
     
     V_CANTIDADJUGADORES NUMBER;
     V_CODEQUIPO NUMBER;
     V_ERROR EXCEPTION;
     
     BEGIN
     
       V_CODEQUIPO:=NEW.COD_EQUIPO;
       SELECT COUNT(*) INTO V_CANTIDADJUGADORES
       FROM JUGADORES
       WHERE COD_EQUIPO=V_CODEQUIPO
       AND COD_EQUIPO!=1;
       
       IF(V_CANTIDADJUGADORES>6) THEN
       RAISE  V_ERROR;
       END IF;
       
     EXCEPTION
     
     WHEN V_ERROR THEN 
     
     RAISE_APLICCATION_ERROR(-20100,'Error, solo puede haber 6 jugadores por 
                                    equipo'||SQLERRM);
     END;                               
    
     
     
 
 
 
 
 


