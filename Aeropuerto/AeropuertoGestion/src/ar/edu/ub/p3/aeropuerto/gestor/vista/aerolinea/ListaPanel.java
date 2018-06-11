package ar.edu.ub.p3.aeropuerto.gestor.vista.aerolinea;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ar.edu.ub.p3.interfaz.IAerolinea;

public class ListaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5372809389141833814L;

	public ListaPanel( FichaConListaView ficha ) {
		super();
		
		this.setLayout( new BorderLayout() );
		//Deberia ser la lista
		
		String[] 	nombreColumna = { "ID_Aerolinea","Nombre_Aerolinea"};
		Object [][] aux = new Object [20][nombreColumna.length];
		
		
		int i =0;
    	for( i = 0; i< ficha.getConexion().getAerolineas().size();i++) {
    		
    		aux[i][0] = new Object();
    		aux[i][1] = new Object();
    		i++;
    		
    	}
    		
   
    		
    	i=0;
		for(IAerolinea aerolinea : ficha.getConexion().getAerolineas()) {
			aux[i][0] = ( aerolinea.getIdAerolinea() );
			aux[i][1] = ( aerolinea.getNombre() );
			i++;
		}
    	
		//DefaultTableModel modelo = new DefaultTableModel();
    	JTable tabla = new JTable(aux, nombreColumna);
    	JScrollPane scroll =  new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setLocation(200, 0);
    	scroll.setBackground(Color.DARK_GRAY);
    	tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	
    	tabla.setAutoscrolls(true);
    	tabla.setForeground(Color.WHITE);
    	tabla.setBackground(Color.DARK_GRAY);
    	
    	tabla.setSize(100,100);
    
    	setLayout(new BorderLayout());
    	add(tabla.getTableHeader(), BorderLayout.PAGE_START);
    	add(scroll,BorderLayout.CENTER);
    	
    	JPanel botones = new JPanel();
    	scroll.setRowHeaderView(botones);
    	botones.setLayout(null);
    	
    	//getContentPane().add(tabla, BorderLayout.CENTER);
    	
    	tabla.addMouseListener(new java.awt.event.MouseAdapter() {
    	    @Override
    	    public void mouseClicked(java.awt.event.MouseEvent evt) {
    	        int fila = tabla.rowAtPoint(evt.getPoint());
    	        int columna = tabla.columnAtPoint(evt.getPoint());
    	        if (fila >= 0 && columna >= 0) {
    	        	
    	            System.out.println(tabla.getValueAt(fila, 0) +" "+
    	            		tabla.getValueAt(fila, 1)  );

    	            ficha.getFichaPanel().getFichaCampospanel().getTxtidAerolinea().setText( (String) tabla.getValueAt(fila, 0));;
    	            ficha.getFichaPanel().getFichaCampospanel().selectComboAerolineabyString( (String)tabla.getValueAt(fila, 1) );
    	            //aca deberia poner las cosas en los campos debidos
    	        }
    	    }
    	});
	
	}

}
