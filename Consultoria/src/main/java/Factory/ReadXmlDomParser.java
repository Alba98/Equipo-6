package Factory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class ReadXmlDomParser {

    private static final String FILENAME = "C:\\Users\\Usuario\\Desktop\\Equipo-6\\Consultoria\\resources\\test.xml";

    private static final String JORNADAS = "C:\\Users\\Usuario\\Desktop\\Equipo-6\\Consultoria\\resources\\resultados_jornadas_test.xml";


    protected DocumentBuilderFactory dbf;


    public ReadXmlDomParser() {
        // Instantiate the Factory
        dbf = DocumentBuilderFactory.newInstance();
    }

    public void checkXML() {
        //ver si los xml existen en el systema
        File jornadas_xml = new File(JORNADAS);
        if (!jornadas_xml.exists()) {
            System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
        }

        //comprobar las fechas de los archivos xml
        ultimaJornadaXML();
    }

    public void testXML() throws ParserConfigurationException, SAXException, IOException {

        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <staff>
            NodeList list = doc.getElementsByTagName("staff");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get staff's attribute
                    String id = element.getAttribute("id");

                    // get text
                    String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
                    String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();

                    NodeList salaryNodeList = element.getElementsByTagName("salary");
                    String salary = salaryNodeList.item(0).getTextContent();

                    // get salary's attribute
                    String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();

                    System.out.println("Current Element :" + node.getNodeName());
                    System.out.println("Staff Id : " + id);
                    System.out.println("First Name : " + firstname);
                    System.out.println("Last Name : " + lastname);
                    System.out.println("Nick Name : " + nickname);
                    System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);

                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    public void ultimaJornadaXML() {

        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(JORNADAS));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <fecha_expiracion>
            String expirationDate = doc.getElementsByTagName("fecha_expiracion").item(0).getTextContent();

            LocalDate hoy = LocalDate.now();

            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fecha = LocalDate.parse(expirationDate, formatoFecha);

            if(fecha.isAfter(hoy)) {

                // get <jornada>
                NodeList jornadas = doc.getElementsByTagName("jornada");

                for (int j = 0; j < jornadas.getLength(); j++) {

                    Node jornada = jornadas.item(j);

                    if (jornada.getNodeType() == Node.ELEMENT_NODE) {

                        Element j_element = (Element)jornada;

                        // get staff's attribute
                        String num_jornada = j_element.getAttribute("num_jornada");
                        String fecha_jornada = j_element.getAttribute("fecha_jornada");

                        System.out.println("Element :" + jornada.getNodeName());
                        System.out.println("num_jornada : " + num_jornada);
                        System.out.println("fecha_jornada : " + fecha_jornada);

                        // get <partido>
                        NodeList partidos = j_element.getElementsByTagName("partido");

                        for (int p = 0; p < partidos.getLength(); p++) {

                            Node partido = partidos.item(p);

                            if (partido.getNodeType() == Node.ELEMENT_NODE) {

                                Element p_element = (Element) partido;

                                // get staff's attribute
                                String cod_partido = p_element.getAttribute("cod_partido");
                                String hora_partido = p_element.getAttribute("hora_partido");

                                // get text
                                String resultado = p_element.getElementsByTagName("resultado").item(0).getTextContent();

                                    System.out.println("Current Element :" + partido.getNodeName());
                                    System.out.println("cod_partido : " + cod_partido);
                                    System.out.println("hora_partido : " + hora_partido);
                                    System.out.println("resultado : " + resultado);

                                // get <nombre_equipo>
                                NodeList equipos = p_element.getElementsByTagName("nombre_equipo");

                                for (int e = 0; e < equipos.getLength(); e++) {

                                    Node equipo = equipos.item(p);

                                    if (partido.getNodeType() == Node.ELEMENT_NODE) {

                                        Element e_element = (Element) equipo;

                                        String nombre_equipo = equipo.getTextContent();

                                        System.out.println("nombre_equipo : " + nombre_equipo);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
