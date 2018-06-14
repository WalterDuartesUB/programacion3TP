package ar.edu.ub.p3.aeropuerto.gestion.view.abm.aerolinea;


import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.modelo.*;
public final class TableModelAerolinea extends DefaultTableModel {
				
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private IRepositorioModelo<Aerolinea> repositorio;
		
		public TableModelAerolinea( IRepositorioModelo<Aerolinea> repositorio ) {
			this.setRepositorio(repositorio);
		}
				
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "idAerolinea";
			case 1:
				return "Nombre";				
			default:
				break;
			}
			return "";
		}
		
		@Override
		public int getColumnCount() {
			//TODO valor clavado con la cantidad de columnas a mostrar
			return 2;
		}
		
		@Override
		public int getRowCount() {			
			return this.getRepositorio() == null ? 0 : this.getAeropuertos().size();
		}
		
		@Override
		public Object getValueAt(int row, int column) {	
			
			Aerolinea aerolinea = this.getAeropuertos().get(row);
			
			switch (column) {
			//TODO Agregar aca las columnas nuevas con el switch
			case 0:
				return aerolinea.getIdAerolinea();
			case 1:
				return aerolinea.getNombre();				
			default:
				break;
			}
						
			return null;
		}


		private List<Aerolinea> getAeropuertos() {
			return this.getRepositorio().getList();
		}

		public IRepositorioModelo<Aerolinea> getRepositorio() {
			return repositorio;
		}

		public void setRepositorio(IRepositorioModelo<Aerolinea> repositorio) {
			this.repositorio = repositorio;
		}


	}