CREATE OR REPLACE TRIGGER T_SueldoMax
  BEFORE INSERT OR UPDATE on jugar_para
    FOR EACH ROW
      DECLARE
        v_codEquipo NUMBER;
        v_sueldosTotales NUMBER;
        v_codJugadores jugar_para.cod_jugador%type;
        v_SueldoMaxTotal NUMBER:=200000;
        v_error EXCEPTION;
        CURSOR c_jugadores IS(
            SELECT cod_jugador
            FROM jugar_para
            WHERE cod_equipo = :NEW.cod_equipo
            );
    BEGIN
        OPEN c_jugadores;
        LOOP
            FETCH c_jugadores INTO v_codJugadores;
            EXIT WHEN c_jugadores%NOTFOUND;
        END LOOP;
        CLOSE c_jugadores;
        
        LOOP
            SELECT SUM(p.sueldo)INTO v_sueldosTotales
            FROM personas p
            WHERE p.cod_persona = v_codJugadores;
            
            v_sueldosTotales := v_sueldosTotales + v_sueldosTotales;
        END LOOP;
        IF(v_sueldosTotales> v_SueldoMaxTotal) THEN
          RAISE_APPLICATION_ERROR(-20250,'Estas introduciendo un salario inferior al salario minimo');         
      END IF;
END;