--Realiza el Trigger
Begin

Update jugar_para
set cod_equipo= 1;

end;


--Permite actualizar
Begin 

Update jugar_para
set cod_equipo= 2
where cod_jugador between 1 and 6;

end;


rollback;