-- GEST_ASISTENTES
CREATE OR REPLACE PUBLIC SYNONYM INSERT_ASISTENTE FOR GEST_ASISTENTES.INSERT_PERSONA;

--GEST_ENTRENADORES
CREATE OR REPLACE PUBLIC SYNONYM INSERT_ENTRENADOR FOR GEST_ENTRENADORES.INSERT_PERSONA;

--GEST_ENTRENADORES
CREATE OR REPLACE PUBLIC SYNONYM INSERT_EQUIPO FOR GEST_EQUIPO.INSERT_EQUIPO;
CREATE OR REPLACE PUBLIC SYNONYM CONTRATO_JUGADOR FOR GEST_EQUIPO.CONTRATO_JUGADOR;
CREATE OR REPLACE PUBLIC SYNONYM CONTRATO_ENTRENADOR FOR GEST_EQUIPO.CONTRATO_ENTRENADOR;
CREATE OR REPLACE PUBLIC SYNONYM CONTRATO_ASISTENTE FOR GEST_EQUIPO.CONTRATO_ASISTENTE;

-- GESTION_INFORMES
CREATE OR REPLACE PUBLIC SYNONYM RESULTADOS_PARTIDO FOR GESTION_INFORMES.p_resultados;
CREATE OR REPLACE SYNONYM DATOS_JUGADORES FOR GESTION_INFORMES.obtener_datos_jugadores;
CREATE OR REPLACE PUBLIC SYNONYM DATOS_EQUIPOS FOR GESTION_INFORMES.obtener_datos_equipos;
CREATE OR REPLACE PUBLIC SYNONYM DATOS_ENTRENADORES FOR GESTION_INFORMES.obtener_datos_entrenador;

-- GEST_JORNADAS
CREATE OR REPLACE PUBLIC SYNONYM INSERT_JORNADA FOR GEST_JORNADAS.INSERT_JORNADA;

-- GEST_JUGADOR
CREATE OR REPLACE PUBLIC SYNONYM INSERT_JUGADOR FOR GEST_JUGADOR.INSERT_PERSONA;

-- GEST_PARTIDOS
CREATE OR REPLACE PUBLIC SYNONYM INSERT_PARTIDO FOR GEST_PARTIDOS.INSERT_PARTIDO;
CREATE OR REPLACE PUBLIC SYNONYM RESULTADO_PARTIDO FOR GEST_PARTIDOS.INSERT_RESULTADO;

-- GEST_JUGADOR
CREATE OR REPLACE PUBLIC SYNONYM INSERT_TEMPORADA FOR GEST_TEMPORADA.INSERT_TEMPORADA;
