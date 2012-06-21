package parsers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.Bolita;
import model.Bolon;
import model.Eslabon;
import model.Laberinto;
import model.Punto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LaberintoParser {
	public static Laberinto build(final String file) {
		Map<Integer, Eslabon> eslabones = new HashMap<Integer, Eslabon>();

		try {
			File fXmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Element laberintoRoot = doc.getDocumentElement();
			int ancho = Integer.parseInt(laberintoRoot.getAttribute("ancho"));
			int alto = Integer.parseInt(laberintoRoot.getAttribute("alto"));
			NodeList eslabonesList = doc.getElementsByTagName("eslabon");
			
			eslabones = LaberintoParser.primeraPasadaCreaNodos(eslabonesList);
			eslabones = LaberintoParser.segundaPasadaVinculaEslabones(eslabonesList, eslabones);

			Eslabon posicionInicialPacman = eslabones.get(Integer.parseInt(laberintoRoot.getAttribute("posicionInicialPacman")));
			Eslabon posicionSalidaFantasmas = eslabones.get(Integer.parseInt(laberintoRoot.getAttribute("posicionSalidaFantasmas")));
			
			return Laberinto.valueOf(ancho, alto, posicionInicialPacman, posicionSalidaFantasmas, eslabones);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Map<Integer, Eslabon> primeraPasadaCreaNodos(NodeList eslabonesList) {
		Map<Integer, Eslabon> eslabones = new HashMap<Integer, Eslabon>();
		int fila;
		int columna;
		int id;
		Punto comida = null;
		Eslabon eslabon;

		for (int temp = 0; temp < eslabonesList.getLength(); temp++) {
			Node e = eslabonesList.item(temp);
			if (e.getNodeType() == Node.ELEMENT_NODE) {
				Element eslabonXml = (Element) e;

				id = Integer.parseInt(eslabonXml.getAttribute("id"));
				fila = Integer.parseInt(eslabonXml.getAttribute("fila"));
				columna = Integer.parseInt(eslabonXml.getAttribute("columna"));
				String comidaString = eslabonXml.getAttribute("comida");
				eslabon = new Eslabon(fila, columna);
				
				if (comidaString.equals("bolita")) {
					comida = new Bolita(eslabon, null);
				} else if (comidaString.equals("bolon")) {
					comida = new Bolon(eslabon, null);
				}
				eslabones.put(id, eslabon);
			}
		}

		return eslabones;
	}

	public static Map<Integer, Eslabon> segundaPasadaVinculaEslabones(NodeList eslabonesList, 
						Map<Integer, Eslabon> eslabones) {
		int id;
		int arriba, abajo, izquierda, derecha;

		for (int temp = 0; temp < eslabonesList.getLength(); temp++) {
			Node e = eslabonesList.item(temp);
			if (e.getNodeType() == Node.ELEMENT_NODE) {
				Element eslabonXml = (Element) e;
				id = LaberintoParser.parseAttribute(eslabonXml, "id");
				arriba = LaberintoParser.parseAttribute(eslabonXml, "arriba");
				abajo = LaberintoParser.parseAttribute(eslabonXml, "abajo");
				izquierda = LaberintoParser.parseAttribute(eslabonXml, "izquierda");
				derecha = LaberintoParser.parseAttribute(eslabonXml, "derecha");

				Eslabon eslabon = eslabones.get(id);
				eslabon.setEslabonArriba(eslabones.get(arriba));
				eslabon.setEslabonAbajo(eslabones.get(abajo));
				eslabon.setEslabonIzquierdo(eslabones.get(izquierda));
				eslabon.setEslabonDerecho(eslabones.get(derecha));
			}
		}

		return eslabones;
	}
	
	public static int parseAttribute(Element element, String attr){
		if(element.getAttribute(attr).isEmpty()){
			return 0;
		}else{
			return Integer.parseInt(element.getAttribute("id"));
		}
	}

}
