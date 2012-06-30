package commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Fantasma;
import model.Pacman;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class StoreObjectToXml {
	private String fileName;
	private Document rootJuego;
	private Element listaFantasmas;

	public StoreObjectToXml(String fileName, Pacman pacman) {
		this.fileName = fileName;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			this.rootJuego = builder.newDocument();
			this.listaFantasmas = this.rootJuego.createElement("juego");
			
			this.listaFantasmas.setAttribute("posicionPacman", String.valueOf(pacman.getEslabon().getId()));
			this.listaFantasmas.setAttribute("fila", String.valueOf(pacman.getEslabon().getFila()));
			this.listaFantasmas.setAttribute("columna", String.valueOf(pacman.getEslabon().getColumna()));
			this.listaFantasmas.setAttribute("sentido", "");
			this.listaFantasmas.setAttribute("puntaje", "");
			this.listaFantasmas.setAttribute("finJuego", String.valueOf(pacman.estaMuerto()));
			
			this.rootJuego.appendChild(listaFantasmas);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToXml(Fantasma fantasma) {
		Element elemFantasma = fantasma.writeToXmlFormat(this.rootJuego);
		listaFantasmas.appendChild(elemFantasma);
	}

	public void persistFile() {
		OutputFormat format = new OutputFormat(this.rootJuego);
		format.setLineSeparator(LineSeparator.Unix);
		format.setIndenting(true);
		format.setLineWidth(0);
		format.setPreserveSpace(false);
		format.setOmitXMLDeclaration(true);

		FileOutputStream salidaXML;
		try {
			salidaXML = new FileOutputStream(new File(this.fileName));
			XMLSerializer serializer = new XMLSerializer(salidaXML, format);
			serializer.asDOMSerializer();
			serializer.serialize(this.rootJuego);
			salidaXML.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

