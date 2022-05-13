--Realiza el trigger
Begin

Update personas
set sueldo = 200001;

end;


--Permite actualizar
Begin

Update personas
set sueldo = 2500;

end;


rollback;