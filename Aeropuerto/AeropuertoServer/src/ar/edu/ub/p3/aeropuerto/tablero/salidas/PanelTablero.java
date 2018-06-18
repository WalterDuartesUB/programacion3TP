package ar.edu.ub.p3.aeropuerto.tablero.salidas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.IFichaModelo;
import ar.edu.ub.p3.aeropuerto.gestion.view.ITablaModelo;

public class PanelTablero<T> extends JPanel implements ITablaModelo{

	private IFichaModelo<T> panelFicha;
	private IRepositorioModelo<T> repositorio;
	private JTable tabla;
	
	private static final long serialVersionUID = 1L;

	public PanelTablero(IRepositorioModelo<T> repositorio) {
		
		setRepositorio(repositorio);
		setLayout( new BorderLayout());
		setTabla(new JTable ());		
		
		
		getTabla().getTableHeader().setBackground(Color.WHITE);
		getTabla().getTableHeader().setForeground(Color.BLACK);
		
		this.add( this.getTabla().getTableHeader(),BorderLayout.PAGE_START);
		this.add( this.getTabla(),BorderLayout.CENTER);
		getTabla().setBackground(Color.WHITE);
		getTabla().setForeground(Color.BLACK);
		
		this.getTabla().getSelectionModel().addListSelectionListener( this::onSelchangeTabla);
	}

	public void onSelchangeTabla(ListSelectionEvent e) {
		this.getPanelFicha().mostrar( this.getRepositorio().getList().get(this.getTabla().getSelectedRow()));		
	}
	
	@Override
	public void refrescar() {
		this.revalidate();
		this.repaint();
		
	}
	
	public IFichaModelo<T> getPanelFicha() {
		return panelFicha;
	}

	public void setPanelFicha(IFichaModelo<T> panelFicha) {
		this.panelFicha = panelFicha;
	}



	public IRepositorioModelo<T> getRepositorio() {
		return repositorio;
	}



	public void setRepositorio(IRepositorioModelo<T> repositorio) {
		this.repositorio = repositorio;
	}



	public JTable getTabla() {
		return tabla;
	}



	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public void setTableModel(TableModel tableModel) {
		this.getTabla().setModel(tableModel);		
	}

}
