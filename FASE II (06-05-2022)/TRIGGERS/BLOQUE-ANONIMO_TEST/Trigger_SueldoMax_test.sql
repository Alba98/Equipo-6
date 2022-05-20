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

INSERT INTO personas (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) 
VALUES ('Darcy','Wuenz',200001,TO_DATE('14/05/2001','DD/MM/YYYY'),'Taiwanesa','The_Core');


rollback;