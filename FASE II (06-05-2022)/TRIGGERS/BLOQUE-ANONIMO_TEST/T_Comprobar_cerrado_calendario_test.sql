INSERT INTO temporadas (abierta) VALUES ('N');

INSERT INTO equipos (cod_partido, nombre, fecha_nacimiento, ciudad, esponsor, nombre_duenio)
VALUES(0001, 'Gasteiz-Goya',    TO_DATE('23/01/2021','DD/MM/YYYY'), 'Vitoria', 'Goya', 'Eneko Ruiz de Villareal');
UPDATE jugadores
SET upper(nombre)='FNATICTQ';

INSERT INTO jugadores VALUES (08,'ADC');
UPDATE jugadores
SET upper(rol)='SUPP';