CREATE OR REPLACE TRIGGER T_SueldoMax
  BEFORE INSERT on personas
    FOR EACH ROW
      DECLARE
        v_codEquipo NUMBER;
        v_sueldosTotales NUMBER;
        v_SueldoMaxTotal NUMBER:=200000;
        v_error EXCEPTION;
    BEGIN
        SELECT SUM(p.sueldo)
          INTO v_sueldosTotales
        FROM personas p, jugadores j, jugar_para jp
        WHERE p.cod_persona = j.cod_jugador
        AND j.cod_jugador = jp.cod_jugador
        AND jp.cod_equipo = v_codEquipo;
        
        v_sueldosTotales := v_sueldosTotales + v_sueldosTotales;
        
        IF(v_sueldosTotales> v_SueldoMaxTotal) THEN
          RAISE_APPLICATION_ERROR(-20250,'Estás introduciendo un salario inferior al salario mínimo');         
      END IF;
END;