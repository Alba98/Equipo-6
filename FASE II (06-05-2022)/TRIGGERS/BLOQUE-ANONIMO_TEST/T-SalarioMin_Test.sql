--Realiza el Trigger
Begin

Update personas
set sueldo = 5;

end;

--Permite actualizar
Begin

Update personas
set sueldo = 950;

end;


rollback;