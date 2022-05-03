INSERT INTO jornadas (fecha_jornada) VALUES (TO_DATE('04/11/2022','DD/MM/YYYY'));
INSERT INTO jornadas (fecha_jornada) VALUES (TO_DATE('11/11/2022','DD/MM/YYYY'));
INSERT INTO jornadas (fecha_jornada) VALUES (TO_DATE('18/11/2022','DD/MM/YYYY'));
INSERT INTO jornadas (fecha_jornada) VALUES (TO_DATE('25/11/2022','DD/MM/YYYY'));

INSERT INTO partidos (hora_partido, resultado, cod_jornada) VALUES ('19:00','3-2',1);
INSERT INTO partidos (hora_partido, resultado, cod_jornada) VALUES ('21:00','1-3',2);
INSERT INTO partidos (hora_partido, resultado, cod_jornada) VALUES ('20:00','3-0',3);
INSERT INTO partidos (hora_partido, resultado, cod_jornada) VALUES ('19:00','3-1',4);

INSERT INTO equipos (cod_partido, nombre, fecha_fundacion, ciudad, esponsor, nombre_duenio) VALUES(0001, 'Gasteiz-Goya',    TO_DATE('23/01/2021','DD/MM/YYYY'), 'Vitoria', 'Goya', 'Eneko Ruiz de Villareal');
INSERT INTO equipos (cod_partido, nombre, fecha_fundacion, ciudad, esponsor, nombre_duenio) VALUES(0002, 'Real Horses',     TO_DATE('02/05/2016','DD/MM/YYYY'), 'Madrid', 'SGAE', 'Pablo Luchs');
INSERT INTO equipos (cod_partido, nombre, fecha_fundacion, ciudad, esponsor, nombre_duenio) VALUES(0002, 'UCUENCA E-Sports',TO_DATE('26/11/2018','DD/MM/YYYY'), 'Cuenca', 'Universidad de Cuenca', 'Manuela Peñal');
INSERT INTO equipos (cod_partido, nombre, fecha_fundacion, ciudad, esponsor, nombre_duenio) VALUES(0001, 'Duero-Pascual',   TO_DATE('30/04/2022','DD/MM/YYYY'), 'Burgos', 'Pascual', 'Rodrigo Infante');

INSERT INTO participa VALUES (01,01);
INSERT INTO participa VALUES (02,02);
INSERT INTO participa VALUES (03,02);
INSERT INTO participa VALUES (04,01);

INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Darcy','Wuenz',2000,TO_DATE('14/05/2001','DD/MM/YYYY'),'Taiwanesa','The_Core');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Iñaki','Birel',1500,TO_DATE('09/07/1997','DD/MM/YYYY'),'Española','Slayo_15');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Juan','Desestepo',2500,TO_DATE('23/12/1979','DD/MM/YYYY'),'Española','Destepo');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Sara','Barracas',2000,TO_DATE('15/03/1999','DD/MM/YYYY'),'Española','Sabacas');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Arnau','Ivancic',1500,TO_DATE('20/10/1995','DD/MM/YYYY'),'Croata','Nautic');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Miku','Hara',2500,TO_DATE('10/12/2002','DD/MM/YYYY'),'Japonesa','Hara_0_0');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Jordi','Juanpues',2000,TO_DATE('01/04/1990','DD/MM/YYYY'),'Española','Jojus');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Silk','Songson',1500,TO_DATE('07/07/1997','DD/MM/YYYY'),'Islandesa','Hollow97');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Alfonso','Torres',2000,TO_DATE('18/05/2001','DD/MM/YYYY'),'Peruana','Alf_Tor6');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Natalia','Campillo',1500,TO_DATE('31/08/1994','DD/MM/YYYY'),'Española','PanTortug');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Rafael','Ávila',3000,TO_DATE('24/11/1997','DD/MM/YYYY'),'Española','Sir_Ravila79');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Amalia','Luciernagas',2000,TO_DATE('15/01/1980','DD/MM/YYYY'),'Canadiense','Buharte');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Marcos','Fausto',2000,TO_DATE('11/06/2000','DD/MM/YYYY'),'Andorrana','ElFaustero');
INSERT INTO persona (nombre, apellido, sueldo, fecha_nacimiento, nacionalidad, nickname) VALUES ('Leilani','Aikau',1500,TO_DATE('13/02/2002','DD/MM/YYYY'),'Estadounidense','Hawainu');

INSERT INTO jugadores VALUES (01,'TOP');
INSERT INTO jugadores VALUES (04,'JGL');
INSERT INTO jugadores VALUES (06,'MID');
INSERT INTO jugadores VALUES (08,'ADC');
INSERT INTO jugadores VALUES (09,'SUPP');
INSERT INTO jugadores VALUES (11,'TOP');
INSERT INTO jugadores VALUES (13,'JGL');
INSERT INTO jugadores VALUES (14,'MID');

INSERT INTO entrenadores VALUES (3);
INSERT INTO entrenadores VALUES (12);
INSERT INTO entrenadores VALUES (7);
INSERT INTO entrenadores VALUES (5);

INSERT INTO asistentes VALUES (10,12);
INSERT INTO asistentes VALUES (2,3);

INSERT INTO temporadas (abierta) VALUES ('N');
INSERT INTO temporadas (abierta) VALUES ('N');
INSERT INTO temporadas (abierta) VALUES ('S');
INSERT INTO temporadas (abierta) VALUES ('N');

INSERT INTO jugar_para VALUES (01,06,01,TO_DATE('30/06/2023','DD/MM/YYYY'),TO_DATE('04/07/2021','DD/MM/YYYY'));
INSERT INTO jugar_para VALUES (02,09,02,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('20/08/2020','DD/MM/YYYY'));
INSERT INTO jugar_para VALUES (03,13,04,TO_DATE('30/06/2023','DD/MM/YYYY'),TO_DATE('02/05/2022','DD/MM/YYYY'));
INSERT INTO jugar_para VALUES (04,11,03,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('20/12/2019','DD/MM/YYYY'));
INSERT INTO jugar_para VALUES (05,04,01,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('13/08/2021','DD/MM/YYYY'));
INSERT INTO jugar_para VALUES (06,01,04,TO_DATE('30/06/2024','DD/MM/YYYY'),TO_DATE('30/04/2022','DD/MM/YYYY'));
INSERT INTO jugar_para VALUES (07,08,02,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('01/07/2021','DD/MM/YYYY'));
INSERT INTO jugar_para VALUES (08,14,03,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('28/08/2020','DD/MM/YYYY'));

INSERT INTO entrena VALUES (01,12,03,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('07/05/2020','DD/MM/YYYY'));
INSERT INTO entrena VALUES (02,07,02,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('20/07/2019','DD/MM/YYYY'));
INSERT INTO entrena VALUES (03,05,04,TO_DATE('30/06/2023','DD/MM/YYYY'),TO_DATE('01/05/2022','DD/MM/YYYY'));
INSERT INTO entrena VALUES (04,03,01,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('30/01/2021','DD/MM/YYYY'));

INSERT INTO asiste VALUES (01,10,03,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('07/05/2020','DD/MM/YYYY'));
INSERT INTO asiste VALUES (02,02,01,TO_DATE('30/06/2022','DD/MM/YYYY'),TO_DATE('05/01/2021','DD/MM/YYYY'));

INSERT INTO rol VALUES (01,'Administrador');
INSERT INTO rol VALUES (02,'Usuario');

INSERT INTO usuarios (nombre, fecha_nacimiento, password_, email, cod_rol) VALUES ('Iñaki',     TO_DATE('21/07/2000','DD/MM/YYYY'),'Egibide','Iñaki@egibide.org',01);
INSERT INTO usuarios (nombre, fecha_nacimiento, password_, email, cod_rol) VALUES ('Idelfonso', TO_DATE('04/05/1998','DD/MM/YYYY'),'Egibide','Idelfonso@egibide.org',02);
INSERT INTO usuarios (nombre, fecha_nacimiento, password_, email, cod_rol) VALUES ('Natalia',   TO_DATE('01/02/2001','DD/MM/YYYY'),'Egibide','Natalia@egibide.org',01);
INSERT INTO usuarios (nombre, fecha_nacimiento, password_, email, cod_rol) VALUES ('Victoria',  TO_DATE('16/11/1999','DD/MM/YYYY'),'Egibide','Victoria@egibide.org',02);


