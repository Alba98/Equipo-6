set serveroutput on;
declare
    textoxml xmltype;
    resultado clob;
    
    fecha date;
begin
    select xmlelement("resultados_jornadas",
        xmlattributes('http://www.w3.org/2001/XMLSchema-instance' "xmlsns:xsi"),
        xmlelement("fecha_expiracion", to_char(fecha, 'yyyy-mm-dd')),
        (select xmlagg(xmlelement("jornada",
            xmlattributes(j.cod_jornada "num_jornada", j.fecha_jornada "fecha_jornada"),
            (select 
                xmlagg(xmlelement("partido",
                    xmlattributes(p.cod_partido "cod_partido", p.hora_partido "hora_partido"),
                    xmlelement("resultado", p.resultado),
                    xmlelement("nombre_equipo",
                        (select e2.nombre from equipos e2 where e2.cod_equipo = pa.cod_equipo1)
                    ),
                    xmlelement("nombre_equipo",
                        (select e2.nombre from equipos e2 where e2.cod_equipo = pa.cod_equipo2)
                    )
                ))
            from partidos p, equipos e, participa pa
            where p.cod_jornada = j.cod_jornada and
                pa.cod_partido = p.cod_partido)
    ))
    from jornadas j)) into textoxml
    from dual;
    
    resultado := textoxml.getClobVal();
    
    dbms_output.put_line(resultado);
end;