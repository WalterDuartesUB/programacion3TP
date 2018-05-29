package ar.edu.ub.p3.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.ub.p3.util.factory.Fabrica;

public class CargadorData {
	public static <T,F extends Fabrica<T>> Map<String, T> cargarMapaDesdeArchivo( String pathData, F fabrica ){
		Map<String, T> aeropuerto = new HashMap<String, T>();
		
		try {
			List<String> lineas = Files.readAllLines(Paths.get(pathData));			
			
			for( String linea : lineas ) {
				T objeto = fabrica.crear( linea.split(",") );
				aeropuerto.put( fabrica.obtenerIdentificador( objeto ), objeto );
			}
			
		} catch (IOException e) {
			// TODO Ver que hacer cuando de una excepcion cargar los datos
			e.printStackTrace();
		}
		
		return aeropuerto;
	}
}
