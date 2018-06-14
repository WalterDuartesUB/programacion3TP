package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aeropuerto;


import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.modelo.*;
public final class TableModelAeropuerto extends DefaultTableModel {
				
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private IRepositorioModelo<Aeropuerto> repositorio;
		public TableModelAeropuerto( IRepositorioModelo<Aeropuerto> repositorio ) {
			this.setRepositorio(repositorio);
		}
				
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "idAeropuerto";
			case 1:
				return "Nombre";	
			case 2:
				return "Posicion";
			default:
				break;
			}
			return "";
		}
		
		@Override
		public int getColumnCount() {
			//TODO valor clavado con la cantidad de columnas a mostrar
			return 3;
		}
		
		@Override
		public int getRowCount() {			
			return this.getRepositorio() == null ? 0 : this.getAeropuertos().size();
		}
		
		@Override
		public Object getValueAt(int row, int column) {	
			
			Aeropuerto aeropuerto = this.getAeropuertos().get(row);
			
			switch (column) {
			//TODO Agregar aca las columnas nuevas con el switch
			case 0:
				return aeropuerto.getIdAeropuerto();
			case 1:
				return aeropuerto.getNombre();
			case 2:
				return aeropuerto.getPosicion().toString();	
			default:
				break;
			}
						
			return null;
		}


		private List<Aeropuerto> getAeropuertos() {
			return this.getRepositorio().getList();
		}

		private IRepositorioModelo<Aeropuerto> getRepositorio() {
			return repositorio;
		}

		private void setRepositorio(IRepositorioModelo<Aeropuerto> aeropuertos) {
			this.repositorio = aeropuertos;
		}
	}