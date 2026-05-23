package util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Utilidad para configurar y obtener instancias de Logger.
 * 
 * @author ISC Israel de Jesús Mar Parada (MPFx++)
 * @version 2.0.0
 */
public class LoggerUtil {
    
    private static FileHandler fileHandler;
    
    static {
        try {
            // Configurar logger para archivo
            fileHandler = new FileHandler("nomina.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            System.err.println("No se pudo configurar el archivo de log: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene un logger configurado para la clase especificada.
     * 
     * @param clase La clase que usará el logger
     * @return Logger configurado
     */
    public static Logger getLogger(Class<?> clase) {
        Logger logger = Logger.getLogger(clase.getName());
        logger.setUseParentHandlers(false); // No mostrar en consola
        logger.addHandler(fileHandler);
        logger.setLevel(Level.INFO);
        return logger;
    }
    
    /**
     * Obtiene un logger que también muestra en consola.
     * 
     * @param clase La clase que usará el logger
     * @return Logger con salida en consola
     */
    public static Logger getLoggerConConsola(Class<?> clase) {
        Logger logger = Logger.getLogger(clase.getName());
        logger.setLevel(Level.INFO);
        return logger;
    }
}
// fin de la clase LoggerUtil