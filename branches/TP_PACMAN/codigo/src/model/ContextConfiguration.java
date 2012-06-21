package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ContextConfiguration {
	public static int MAXIMO_NIVEL_AGRESIVIDAD;
	public static int PERIODO_DE_PRESA;
	public static int PERIODO_DE_MUERTO;
	public static int VISION_N1;
	public static int VISION_N2;
	public static int VISION_N3;
	public static int VISION_N4;
	
	private Properties properties;

	public ContextConfiguration(){	
		try {
			properties = new Properties();
			properties.load(new FileInputStream("pacman.properties"));
            
			ContextConfiguration.MAXIMO_NIVEL_AGRESIVIDAD = Integer.parseInt(properties.getProperty("maximoNivelAgresividad"));
			ContextConfiguration.PERIODO_DE_PRESA = Integer.parseInt(properties.getProperty("periodoPresa"));
			ContextConfiguration.PERIODO_DE_MUERTO = Integer.parseInt(properties.getProperty("periodoMuerte"));
			ContextConfiguration.VISION_N1 = Integer.parseInt(properties.getProperty("visionZonzo"));
			ContextConfiguration.VISION_N2 = Integer.parseInt(properties.getProperty("visionPerezoso"));
			ContextConfiguration.VISION_N3 = Integer.parseInt(properties.getProperty("visionBuscador"));
			ContextConfiguration.VISION_N4 = Integer.parseInt(properties.getProperty("visionTemperamental"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}