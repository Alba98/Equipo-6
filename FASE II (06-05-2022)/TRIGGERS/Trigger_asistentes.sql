Create or replace trigger asistentes_insert
 before
 insert on asistentes
 for each row
 declare
 v_codentre entrenadores.cod_entrenador%type;
 v_codjugad jugadores.cod_jugador%type;

 Begin

 Select cod_entrenador into v_codentre from entrenadores 
 where cod_entrenador =:new.cod_asistente;
 if SQL%FOUND then
 
 raise_application_error( -20066, 'Ya existe un entrenador con el mismo código');
 
 end if;
 
  Select cod_jugador into v_codjugad from jugadores 
  where cod_jugador = :new.cod_asistente;
 if SQL%FOUND then
 
 raise_application_error( -20068, 'Ya existe un jugador con el mismo código');
 
 end if;
 
 end;