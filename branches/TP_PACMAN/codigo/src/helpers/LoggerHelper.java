package helpers;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerHelper {
	private FileHandler handler;
	private Logger logger;
	
	public LoggerHelper(String logName){
		try {
		    // Create an appending file handler
		    boolean append = true;
		    handler = new FileHandler(logName+".log", append);

		    // Add to the desired logger
		    logger = Logger.getLogger(logName);
		    logger.setUseParentHandlers(false);
		    logger.addHandler(handler);
		} catch (IOException e) {
		}
	}
	
	public void log(String message){
		this.logger.log(Level.INFO, message);
	}
}
