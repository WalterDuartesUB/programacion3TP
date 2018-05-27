package ar.edu.ub.p3.aeropuerto.gestor.configuracion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
	
	private static final String CONFIGURACION_SIN_VALOR = "-12453-";
	private String pathConfig;
 
	public Configuracion(String pathConfig) {
		this.setPathConfig(pathConfig);
	}

	public String obtenerValor( String key, String defaultValue) {
		
		Properties config = new Properties();
		String     valor = "";
		
		try( FileInputStream fis = new FileInputStream( new File( this.getPathConfig() ) ) )
		{
			config.load( fis );
			
			//Pido una entrada
			valor = config.getProperty( key, CONFIGURACION_SIN_VALOR);
			
			// Si el valor de configuracion no existe, lo creo con un default y grabo en disco.
			if( valor.equals( CONFIGURACION_SIN_VALOR ) )
			{
				valor = defaultValue;
				//Pongo el default en el grupo
				config.setProperty( key, defaultValue );
				
				try( FileOutputStream fout = new FileOutputStream( new File( this.getPathConfig() ) ) )
				{
					config.store(fout, "");
				}
			}
			
		} catch ( IOException e) {
			e.printStackTrace();
		}
				
		return valor;
	}

	public String getPathConfig() {
		return pathConfig;
	}

	private void setPathConfig(String pathConfig) {
		this.pathConfig = pathConfig;
	}
}
