package commons;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Eslabon;
import model.Laberinto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StoreCasillerosToXML {
	private String fileName;
	private Document rootJuego;
	private Element listaFantasmas;
	
	public StoreCasillerosToXML(String fileName, Laberinto laberinto) {
		this.fileName = fileName;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			this.rootJuego = builder.newDocument();
			this.listaFantasmas = this.rootJuego.createElement("laberinto");
			
			this.listaFantasmas.setAttribute("ancho", String.valueOf(laberinto.getAncho()));
			this.listaFantasmas.setAttribute("alto", String.valueOf(laberinto.getAlto()));
			this.listaFantasmas.setAttribute("nodoAncho", "");
			this.listaFantasmas.setAttribute("nodoAlto", "");
			this.listaFantasmas.setAttribute("inicioPacman", "");
			this.listaFantasmas.setAttribute("inicioFantasmas", "");
			this.rootJuego.appendChild(listaFantasmas);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeToXml(Eslabon fantasma) {
		Element elemFantasma = fantasma.writeToXmlFormat(this.rootJuego);
		listaFantasmas.appendChild(elemFantasma);
	}
	
}
