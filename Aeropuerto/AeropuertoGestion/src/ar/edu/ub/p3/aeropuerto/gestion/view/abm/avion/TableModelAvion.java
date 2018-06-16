package ar.edu.ub.p3.aeropuerto.gestion.view.abm.avion;


import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.modelo.Avion;
 
public final class TableModelAvion extends DefaultTableModel {
				
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private IRepositorioModelo<Avion> repositorio;
		
		public TableModelAvion( IRepositorioModelo<Avion> repositorio ) {
			this.setRepositorio(repositorio);
		}
				
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "idAvion";
			case 1:
				return "Aerolinea";
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
			return this.getRepositorio() == null ? 0 : this.getAviones().size();
		}
		
		@Override
		public Object getValueAt(int row, int column) {	
			
			Avion avion = this.getAviones().get(row);
			
			switch (column) {
			//TODO Agregar aca las columnas nuevas con el switch
			case 0:
				return avion.getIdAvion();
			case 1:
				return avion.getAerolinea().getNombre();	
			case 2:
				return avion.getPosicion().toString();
			default:
				break;
			}
						
			return null;
		}


		private List<Avion> getAviones() {
			return this.getRepositorio().getList();
		}

		public IRepositorioModelo<Avion> getRepositorio() {
			return repositorio;
		}

		public void setRepositorio(IRepositorioModelo<Avion> repositorio) {
			this.repositorio = repositorio;
		}


	}