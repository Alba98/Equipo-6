
CREATE OR REPLACE PACKAGE BODY GESTION_INFORMES AS

 FUNCTION BUSCAR_EQUIPO_POR_NOMBRE 
 
 (p_nom_equipo varchar2)
  
  RETURN NUMBER;
  
--------------------------------------------------------------------------------

  FUNCTION BUSCAR_EQUIPO_POR_NOMBRE 
  
  (p_nom_equipo varchar2)
  
  RETURN NUMBER
  AS
  p_cod_equipo equipos.cod_equipo%type;
  
  BEGIN
  
  SELECT COD_EQUIPO INTO  p_cod_equipo
  FROM EQUIPOS
  WHERE UPPER(NOMBRE)=UPPER(p_nom_equipo);
  
  RETURN P_COD_EQUIPO;
  
  EXCEPTION
  
  WHEN NO_DATA_FOUND THEN 
  
  P_COD_EQUIPO:=NULL;
 
  RETURN P_COD_EQUIPO;
  
  WHEN TOO_MANY_ROWS THEN 
  
  P_COD_EQUIPO:=-1;
  
  RETURN P_COD_EQUIPO;
  
  END BUSCAR_EQUIPO_POR_NOMBRE;

--------------------------------------------------------------------------------
  PROCEDURE p_resultados(p_num_jornada IN OUT NUMBER,
                         p_cod_partido OUT NUMBER,
                         p_resultado OUT VARCHAR2,
                         p_horapartido OUT VARCHAR2)
                         
  AS 
  
  
  BEGIN
  
  SELECT J.COD_JORNADA  ,P.COD_PARTIDO  ,P.RESULTADO, P.HORA_PARTIDO
  INTO P_NUM_JORNADA, P_COD_PARTIDO, P_RESULTADO, P_HORAPARTIDO
  FROM JORNADAS J , PARTIDOS P
  WHERE J.COD_JORNADA=P.COD_JORNADA;
  
  EXCEPTION
  
  WHEN NO_DATA_FOUND THEN 
  
  RAISE_APPLICATION_ERROR (-20122,'Error.No se ha encontrado la jornada');
  
  WHEN OTHERS THEN 
  
   RAISE_APPLICATION_ERROR (-20050,'Error desconocido');
   
 end   p_resultados;
-------------------------------------------------------------------------------- 
 
   PROCEDURE obtener_datos_jugadores(p_nick_jugador varchar2,
                                      p_cod_equipo number,
                                      p_apellido_jugador varchar2,
                                      p_nom_jugador varchar2,
                                      p_rol_jugador varchar2)
                                         
   AS 

   BEGIN    
   SELECT P.NICKNAME,P.NOMBRE,P.APELLIDO,J.ROL, JP.COD_EQUIPO
   INTO   p_nick_jugador, p_nom_jugador,p_apellido_jugador, p_rol_jugador,
          p_cod_equipo
   
   FROM  JUGAR_PARA JP,PERSONA P, JUGADORES J 
   
   WHERE  UPPER(P.NICKNAME)=UPPER(P_NICK_JUGADOR) AND P.COD_PERSONA=J.COD_JUGADOR
   AND J.COD_JUGADOR=JP.COD_JUGADOR;
   
   EXCEPTION
   
   WHEN NO_DATA_FOUND THEN
   
   RAISE_APPLICATION_ERROR(-20078,'Error.no se ha encontrado al jugador');
   
   WHEN OTHERS THEN
   
   RAISE_APPLICATION_ERROR (-20050,'Error desconocido');
   
   
   END  obtener_datos_jugadores;
   
-------------------------------------------------------------------------------- 
   
   
  PROCEDURE obtener_datos_entrenador (p_nom_equipo OUT varchar2,
                                        p_nombre OUT varchar2,
                                        p_apellido  OUT varchar2,
                                        p_nick IN OUT varchar2,
                                        p_nacionalidad   OUT varchar2)
            
   AS 
   
   BEGIN
   
   SELECT     E.NOMBRE, P.NOMBRE , P.APELLIDO , P.NICKNAME,P.NACIONALIDAD
   INTO       P_NOM_EQUIPO,P_NOMBRE,P_APELLIDO,P_NICK_P_NACIONALIDAD
   FROM       EQUIPOS E, PERSONA P, ENTRENADORES EN , ENTRENA ET
   WHERE      P.COD_PERSONA=EN.COD_ENTRENADOR 
              AND EN.COD_ENTRENADOR=ET.COD_ENTRENADOR 
              AND ET.COD_EQUIPO=E.COD_EQUIPO;
              
              
   
   
    EXCEPTION
   
   WHEN NO_DATA_FOUND THEN
   
   RAISE_APPLICATION_ERROR(-20097,'Error.no se ha encontrado al entrenador');
   
   WHEN OTHERS THEN
   
   RAISE_APPLICATION_ERROR (-20050,'Error desconocido');
   
   
   END  obtener_datos_entrenador;
   
--------------------------------------------------------------------------------   
   
 PROCEDURE obtener_datos_equipos(c_nombre varchar2,
                                 c_equipo OUT tcursor)
 AS 
 
 
  
  v_cod_equipo number;
  e_equipo_no_encontrado exception;
  
  
 BEGIN 
 
  v_cod_equipo:=BUSCAR_EQUIPO_POR_NOMBRE(c_nombre);
 
 IF v_cod_equipo is null then
 raise  e_equipo_no_encontrado;
 ELSE 
 OPEN C_EQUIPO FOR 
 SELECT *
 FROM VISTA_EQUIPO
 WHERE cod_equipo=v_cod_equipo;
 
 end if;
 --NULL;
 
EXCEPTION

	WHEN e_equipo_no_encontrado THEN
    
    RAISE_APPLICATION_ERROR(-20096,'Err.nombre del equipo no encontrado');
    
   WHEN OTHERS THEN
   
   RAISE_APPLICATION_ERROR (-20050,'Error desconocido');
   
   
   END  obtener_datos_equipos;
   
 end GESTION_INFORMES;
 
 
 
 
 
 

 
 
 
 
  

     

  
 
 
 
 
 
 
