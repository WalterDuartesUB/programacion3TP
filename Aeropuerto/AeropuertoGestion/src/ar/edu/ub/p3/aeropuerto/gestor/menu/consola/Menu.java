package ar.edu.ub.p3.aeropuerto.gestor.menu.consola;

import java.util.Scanner;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;

public class Menu {

	public void menuPrincipal(ConexionAeropuerto conexion) {
		
		Scanner in = new Scanner( System.in );
		
		System.out.println( "\n\n"+
							"c > create Avion\n"+
							"m > modify Avion\n"+
							"d > delete avion");
		String opcion = in.nextLine();
		
		
		//NO USAR SWITCH SOLO PARA LA PRIMER PRUEBA SUPER FANTASMAL :V 
		//NO USAR STRINGS :D 
		
		//DE ACA PARA ABAJO ES HORRIBLE POR FAVOR IGNORAR DE FORMA DIRECTA
		switch (opcion.charAt(0)) {
			 
		case 'c':
			System.out.println("\nagregando...\n");
			conexion.addAvion( new Avion( "AVI-23",new Aerolinea("AER-24","ADD"),new Posicion(2,2)));
			break;
		case 'm':
			System.out.println("\nmodificando...\n");
			Avion avion = new Avion( "AVI-04",new Aerolinea("AER-04","MODIFY"),new Posicion(2,2));
			
			conexion.deleteAvion( conexion.getAviones().get(3) );
			conexion.modifyAvion( avion );
			
			break;
		case 'd':
			System.out.println("\neliminando...\n");
			conexion.deleteAvion(conexion.getAviones().get(4));
			break;
		}
					
		in.close();
		
	}
	
	
}
