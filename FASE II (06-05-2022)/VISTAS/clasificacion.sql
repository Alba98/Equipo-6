SELECT
    t.cod_temporada,
    j.cod_jornada,
    p.cod_partido,
    j.fecha_jornada,
    p.hora_partido,
    p.resultado,
    e.nombre,
    pe.nickname,
    ju.rol
FROM
    temporadas t,
    jornadas   j,
    partidos   p,
    participa  pa,
    equipos    e,
    jugar_para jp,
    jugadores  ju,
    personas   pe
WHERE
        t.cod_temporada = j.cod_temporada
    AND j.cod_jornada = p.cod_jornada
    AND p.cod_partido = pa.cod_partido
    AND e.cod_equipo = jp.cod_equipo
    AND jp.cod_jugador = ju.cod_jugador
    AND ju.cod_jugador = pe.cod_persona
    AND e.cod_equipo IN ( pa.cod_equipo1, pa.cod_equipo2 )
ORDER BY
    j.cod_jornada,
    pa.cod_partido