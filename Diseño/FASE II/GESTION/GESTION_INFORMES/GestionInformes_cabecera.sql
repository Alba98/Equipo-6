/*********Cabecera**************/


CREATE OR REPLACE PACKAGE GESTION_INFORMES AS 
TYPE TCURSOR IS REF CURSOR;

   PROCEDURE p_resultados(p_num_jornada IN OUT NUMBER,
                           p_cod_equipo OUT NUMBER,
                           p_resultado OUT VARCHAR2,
                           p_horapartido OUT varchar2);
    
   PROCEDURE obtener_datos_jugadores(p_nick_jugador IN OUT  varchar2,
                                      p_nom_equipo OUT varchar2,
                                      p_apellido_jugador OUT varchar2,
                                      p_nom_jugador OUT varchar2,
                                      p_rol_jugador OUT varchar2,
                                      p_cod_equipo OUT number);
                                           
    PROCEDURE obtener_datos_equipos(c_nombre IN VARCHAR2,
                                    c_equipo OUT tcursor);
                                    
                                           
    
   PROCEDURE obtener_datos_entrenador (p_nom_equipo OUT varchar2,
                                        p_nombre OUT varchar2,
                                        p_apellido  OUT varchar2,
                                        p_nick IN OUT varchar2,
                                        p_nacionalidad   OUT varchar2);
            
     END  GESTION_INFORMES;                           
                                        
    

   








