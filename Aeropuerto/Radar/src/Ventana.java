import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	Radar radar = new Radar();
	
	public Ventana(){
		super();
		this.setTitle("Radar");
		this.setSize(397, 399);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(radar,BorderLayout.CENTER);
		this.setVisible(true);
	}

	


}
