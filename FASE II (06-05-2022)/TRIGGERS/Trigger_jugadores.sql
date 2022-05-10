Create or replace trigger jugadores_insert
 before
 insert on jugadores
 for each row
 declare
 v_codentre entrenadores.cod_entrenador%type;
 v_codasist asistentes.cod_asistente%type;

 Begin

 Select cod_entrenador into v_codentre from entrenadores 
 where cod_entrenador =:new.cod_jugador;
 if SQL%FOUND then
 
 raise_application_error( -20066, 'Ya existe un entrenador con el mismo código');
 
 end if;
 
  Select cod_asistente into v_codasist from asistentes 
  where cod_asistente = :new.cod_jugador;
 if SQL%FOUND then
 
 raise_application_error( -20067, 'Ya existe un asistente con el mismo código');
 
 end if;
 
 end;