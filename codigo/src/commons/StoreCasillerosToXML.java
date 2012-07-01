package commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Eslabon;
import model.Laberinto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

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
			 Map<Integer, Eslabon> eslabones = laberinto.getEslabones();
		        for (Entry<Integer, Eslabon> entry : eslabones.entrySet()) {
		        	entry.getKey(); 
		        	writeToXml(entry.getValue());
		        }
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeToXml(Eslabon eslabon) {
		Element elemFantasma = eslabon.writeToXmlFormat(this.rootJuego);
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
