package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;


import java.util.List;

import javax.swing.table.DefaultTableModel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.*;
import ar.edu.ub.p3.modelo.Vuelo;
 
public final class TableModelVuelo extends DefaultTableModel {
				
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private IRepositorioModelo<Vuelo> repositorio;
		
		public TableModelVuelo( IRepositorioModelo<Vuelo> repositorio ) {
			this.setRepositorio(repositorio);
		}
				
		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "idAerolinea";
			case 1:
				return "IdAvion";
			case 2:
				return "Origen";
			case 3:
				return "Destino";
			case 4:
				return "Estado";
			case 5:
				return "Programacion";
			default:
				break;
			}
			return "";
		}
		
		@Override
		public int getColumnCount() {
			//TODO valor clavado con la cantidad de columnas a mostrar
			return 6;
		}
		
		@Override
		public int getRowCount() {			
			return this.getRepositorio() == null ? 0 : this.getVuelos().size();
		}
		
		@Override
		public Object getValueAt(int row, int column) {	
			
			Vuelo vuelo = this.getVuelos().get(row);
			
			switch (column) {
			//TODO Agregar aca las columnas nuevas con el switch
			case 0:
				return vuelo.getIdVuelo();
			case 1:
				return vuelo.getAvion().getIdAvion();
			case 2:
				return vuelo.getAeropuertoOrigen().getNombre();	
			case 3:
				return vuelo.getAeropuertoDestino().getNombre();	
			case 4:
				return vuelo.getEstadoVuelo();
			case 5:
				return fechaVuelo(vuelo);	
				
			default:
				break;
			}
						
			return null;
		}


		@SuppressWarnings("deprecation")
		private String fechaVuelo(Vuelo vuelo) {
		
			return (    vuelo.getHorarioProgramado().getDay()+"/"+
						vuelo.getHorarioProgramado().getMonth()+"/"+
					   (vuelo.getHorarioProgramado().getYear()-100)+" | "+
						vuelo.getHorarioProgramado().getHours()+":"+
						vuelo.getHorarioProgramado().getMinutes());
			
		}

		private List<Vuelo> getVuelos() {
			return this.getRepositorio().getList();
		}

		public IRepositorioModelo<Vuelo> getRepositorio() {
			return repositorio;
		}

		public void setRepositorio(IRepositorioModelo<Vuelo> repositorio) {
			this.repositorio = repositorio;
		}




	}