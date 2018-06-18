package ar.edu.ub.p3.aeropuerto.tablero.salidas;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.Vuelo;
import ar.edu.ub.p3.util.Configuracion;

public class TableModelVuelosSalida extends DefaultTableModel {
	
/**
* 
*/
	private static final long serialVersionUID = 1L;

	private IRepositorioModelo<Vuelo> repositorio;
	private Configuracion configuracion;
	
	public TableModelVuelosSalida( Configuracion configuracion, IRepositorioModelo<Vuelo> repositorio ) {
		this.setRepositorio(repositorio);
		this.setConfiguracion(configuracion);
		
	}
		
	@Override
	public String getColumnName(int column) {
		switch (column) {
			case 0:
				return "Hora Programada";
			case 1:
				return "NroVuelo";	
			case 2:
				return "Aerolinea";
			case 3:
				return "Destino";
			case 4:
				return "Estima";
			case 5:
				return "Estado";
			default:
				break;
	}
		return "";
	}
	
	@Override
		public Class<?> getColumnClass(int columnIndex) {
			// TODO Auto-generated method stub
			
			return this.getValueAt(0, columnIndex).getClass();
		}
	
	@Override
	public int getColumnCount() {
		return 6;
	}
	
	@Override
	public int getRowCount() {			
		return this.getRepositorio() == null ? 0 : this.getAeropuertos().size();
	}
	
	@Override
	public Object getValueAt(int row, int column) {	
	
		Vuelo aeropuerto = this.getAeropuertos().get(row);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
	switch (column) {
		case 0:
			String fechaComoCadena2 = sdf.format(aeropuerto.getHorarioProgramado());
			return fechaComoCadena2;
		case 1:
			return aeropuerto.getIdVuelo();
		case 2:
			return new ImageIcon( this.getConfiguracion().getConfiguracion(aeropuerto.getAvion().getAerolinea().getIdAerolinea()));
		case 3:
			return aeropuerto.getAeropuertoDestino().getNombre();
		case 4:
			String fechaComoCadena = sdf.format(aeropuerto.getHorarioAterrizajeEstimado());
			return fechaComoCadena;
		case 5:
			return aeropuerto.getEstadoVuelo();
		default:
			break;
	}
		
		return null;
	}
	
	
	private List<Vuelo> getAeropuertos() {
	return this.getRepositorio().getList();
	}
	
	private IRepositorioModelo<Vuelo> getRepositorio() {
	return repositorio;
	}
	
	private void setRepositorio(IRepositorioModelo<Vuelo> aeropuertos) {
	this.repositorio = aeropuertos;
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}
}
