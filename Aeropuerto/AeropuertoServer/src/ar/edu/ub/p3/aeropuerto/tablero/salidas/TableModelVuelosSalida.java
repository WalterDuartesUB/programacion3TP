package ar.edu.ub.p3.aeropuerto.tablero.salidas;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Vuelo;

public class TableModelVuelosSalida extends DefaultTableModel {
	
/**
* 
*/
private static final long serialVersionUID = 1L;

private IRepositorioModelo<Vuelo> repositorio;
public TableModelVuelosSalida( IRepositorioModelo<Vuelo> repositorio ) {
this.setRepositorio(repositorio);
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
//TODO valor clavado con la cantidad de columnas a mostrar
return 6;
}

@Override
public int getRowCount() {			
return this.getRepositorio() == null ? 0 : this.getAeropuertos().size();
}

@Override
public Object getValueAt(int row, int column) {	

Vuelo aeropuerto = this.getAeropuertos().get(row);


switch (column) {
//TODO Agregar aca las columnas nuevas con el switch
case 0:
	return aeropuerto.getHorarioProgramado();
case 1:
	return aeropuerto.getIdVuelo();
case 2:
	return new ImageIcon(".\\logosaerolineas\\arg2.png");
	//return aeropuerto.getAvion().getAerolinea().getNombre();	
case 3:
	return aeropuerto.getAeropuertoDestino().getNombre();
case 4:
	return aeropuerto.getHorarioAterrizajeEstimado();
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
}
