set SERVEROUTPUT on;

--
declare
                          p_nick_jugador varchar2(15) := 'The_Core';
                          p_cod_equipo number (2) := 01;
                          p_apellido_jugador varchar2 (15) := 'Wuenz';
                          p_nom_jugador varchar2 (15):= 'Darcy';
                          p_rol_jugador varchar2 (15):= 'TOP';
begin
    Gestion_Informes.obtener_datos_jugadores(p_nick_jugador, p_cod_equipo, p_apellido_jugador, p_nom_jugador, p_rol_jugador);
    
end;

------------------------------------------------

DECLARE
                                    
                                        p_nombre varchar2 (15) := 'Juan';
                                        p_apellido varchar2 (15) := 'Desestepo';
                                        p_nick varchar2 (15) := 'Detepo';
                                        p_nacionalidad  varchar2 (20) := 'Espaniola';


begin
    Gestion_Informes.obtener_datos_entrenador('Gasteiz-Goya', p_nombre, p_apellido, p_nick, p_nacionalidad);
end;

----------------------------------------------------

DECLARE
                                        c_nombre varchar2 (30) := 'Gasteiz-Goya';
                                        c_equipo number (2) := 01;


begin
    Gestion_Informes.obtener_datos_equipo(c_nombre, c_equipo);
end;
                        