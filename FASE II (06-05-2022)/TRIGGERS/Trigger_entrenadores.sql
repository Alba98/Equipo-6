Create or replace trigger entrenadores_insertar
 before
 insert on entrenadores
 for each row
 declare
 v_codjugad jugadores.cod_jugador%type;
 v_codasist asistentes.cod_asistente%type;

 Begin

 Select cod_jugador into v_codjugad from jugadores 
 where cod_jugador =:new.cod_entrenador;
 if SQL%FOUND then
 
 raise_application_error( -20068, 'Ya existe un jugador con el mismo código');
 
 end if;
 
  Select cod_asistente into v_codasist from asistentes 
  where cod_asistente = :new.cod_entrenador;
 if SQL%FOUND then
 
 raise_application_error( -20067, 'Ya existe un asistente con el mismo código');
 
 end if;
 
 end;