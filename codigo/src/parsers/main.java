package parsers;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import commons.StoreObjectToXml;

import model.Direccion;
import model.Eslabon;
import model.Fantasma;
import model.Laberinto;

public class main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		int iteracion = 1;
		String archivoPacman = "pacmanTick";
		String extension = ".xml";
		Laberinto laberinto = LaberintoParser.build("laberinto.xml");
		while (!laberinto.esFinDelJuego()){
			
			try {
				final String nombreArchivo = archivoPacman + String.valueOf(iteracion) + extension;
				File fXmlFile = new File(nombreArchivo);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();

				doc.getDocumentElement();
				Element pacmanNode = (Element) doc.getElementsByTagName("pacman").item(0);
				String direccion = pacmanNode.getAttribute("direccion");
				System.out.println(direccion);
				
				if (direccion.equals("derecha")){
					laberinto.getPacman().mover(Direccion.DERECHA);
				}
				if (direccion.equals("arriba")){
					laberinto.getPacman().mover(Direccion.ARRIBA);
				}
				if (direccion.equals("izquierda")){
					laberinto.getPacman().mover(Direccion.IZQUIERDA);
				}
				if (direccion.equals("abajo")){
					laberinto.getPacman().mover(Direccion.ABAJO);
				}
				
				laberinto.moverFantasmas();	
				
				
				escribirArchivosSalida(laberinto, iteracion);
				
				
				iteracion ++;
				
				
				
				//aca hay que sacar los archivos
			} catch (Exception e) {
				
			}
			Thread.sleep(1000);	
		}
	}

	private static void escribirArchivosSalida(Laberinto laberinto,
			int iteracion) {
		
		String extension = ".xml";
		String archivoLaberintoSalida = "LaberintoTick";
		String archivoPersonajesSalida= "PersonajesTick";
		
		
		StoreObjectToXml storeObjectToXml = new StoreObjectToXml(archivoPersonajesSalida + String.valueOf(iteracion) + extension, laberinto.getPacman());
		for (Fantasma fantasma : laberinto.getFanstamas()) {
			storeObjectToXml.writeToXml(fantasma);
		}
		storeObjectToXml.persistFile();
		
		 Map<Integer, Eslabon> eslabones = laberinto.getEslabones();
		 
		 
        
        for (Entry<Integer, Eslabon> entry : eslabones.entrySet()) {
        	System.out.println("Key : " + entry.getKey() 
       			+ " Value : " + entry.getValue());
        }
		
		
	}

}
