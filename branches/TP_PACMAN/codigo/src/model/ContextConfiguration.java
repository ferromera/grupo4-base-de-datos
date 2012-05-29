package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ContextConfiguration {
	public static int MAXIMO_NIVEL_AGRESIVIDAD;
	public static int PERIODO_DE_PRESA;
	public static int PERIODO_DE_MUERTO;
	private Properties properties;

	public ContextConfiguration(){	
		try {
			properties = new Properties();
			properties.load(new FileInputStream("pacman.properties"));
            
			ContextConfiguration.MAXIMO_NIVEL_AGRESIVIDAD = Integer.parseInt(properties.getProperty("maximoNivelAgresividad"));
			ContextConfiguration.PERIODO_DE_PRESA = Integer.parseInt(properties.getProperty("periodoPresa"));
			ContextConfiguration.PERIODO_DE_MUERTO = Integer.parseInt(properties.getProperty("periodoMuerte"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
