package parsers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.Direccion;
import model.Laberinto;

public class main {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		int inicial = 1;
		String archivoPacman = "pacmanTick";
		String extension = ".xml";
		Laberinto laberinto = LaberintoParser.build("laberinto.xml");
		while (!laberinto.esFinDelJuego()){
			
			try {
				final String nombreArchivo = archivoPacman + String.valueOf(inicial) + extension;
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
				inicial ++;
				
				//aca hay que sacar los archivos
			} catch (Exception e) {
				
			}
			Thread.sleep(1000);	
		}
	}

}
