set serveroutput on;
declare
    textoxml xmltype;
    resultado clob;
    fecha date;
begin

select xmlelement("clasificacion",
    xmlattributes('http://www.w3.org/2001/XMLSchema-instance' "xmlsns:xsi"),
    xmlelement("fecha_expiracion", to_char(fecha, 'yyyy-mm-dd')),
    (select 
        xmlelement("temporada",
            xmlattributes(t.cod_temporada "cod_temporada"),
            (select
                xmlagg(xmlelement("equipo", 
                    xmlattributes(pa.cod_equipo1 "cod_equipo",
                        GEST_PARTIDOS.PARTIDOS_GANADOS(pa.cod_equipo1) "partidos_ganados"),
                    (select xmlagg(
                            xmlelement("nombre", e.nombre),
                            xmlelement("lista_jugadores",
                                (select xmlagg(
                                        xmlelement("jugador",
                                            (select xmlelement("nickname", p.nickname) from personas p where jg.cod_jugador = p.cod_persona),
                                            xmlelement("rol", jg.rol)
                                        )
                                    )
                                from jugadores jg,jugar_para jp, equipos e
                                where jg.cod_jugador=jp.cod_jugador and jp.cod_equipo=e.cod_equipo )
                            )
                        )
                    from equipos e
                    where e.cod_equipo = pa.cod_equipo1)
                ),
                xmlelement("equipo", 
                    xmlattributes(pa.cod_equipo2 "cod_equipo",
                        gest_partidos.partidos_ganados(pa.cod_equipo2) "partidos_ganados"),
                    (select xmlagg(
                            xmlelement("nombre", e.nombre),
                            xmlelement("lista_jugadores",
                                (select xmlagg(
                                        xmlelement("jugador",
                                            (select xmlelement("nickname", p.nickname) from personas p where jg.cod_jugador = p.cod_persona),
                                            xmlelement("rol", jg.rol)
                                        )
                                    )
                                from jugadores jg,jugar_para jp, equipos e
                                where jg.cod_jugador=jp.cod_jugador and jp.cod_equipo=e.cod_equipo )
                            )
                        )
                    from equipos e
                    where e.cod_equipo = pa.cod_equipo2)
                ))
            from participa pa, partidos p, jornadas j
            where pa.cod_partido = p.cod_partido and
                p.cod_jornada = j.cod_jornada and
                j.cod_temporada = t.cod_temporada))
            
        
    from temporadas t))
from dual;
end;
        



