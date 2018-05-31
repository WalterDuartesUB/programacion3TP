



//ESTA CLASE ESTA EN FASE DE PRUEBA
//NO DEBE SER TOMADA EN SERIO
//NO SE ESTA USANDO





package ar.edu.ub.p3.aeropuerto.gestor.vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.ConexionAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;


import javax.swing.JTextPane;
import java.awt.Font;

public class VentanaWB {

	public JFrame frame;

	/**
	 * Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public VentanaWB(ConexionAeropuerto conexion) {
		initialize(conexion);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ConexionAeropuerto conexion) {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Consolas", Font.PLAIN, 11));
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(162, 11, 244, 213);
		frame.getContentPane().add(textPane);
 
		JButton btnModificarAvion = new JButton("Modificar Avion");
		btnModificarAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				System.out.println(">se modifico un avion");
				//textPane.setText(textPane.getText() + "\n"+ conexion.getAviones().get(0).toString());
				
				Avion avion = new Avion( "AVI-04",new Aerolinea("AER-04","MODIFY"),new Posicion(2,2));
				conexion.deleteAvion( conexion.getAviones().get(3) );
				conexion.modifyAvion( avion );
				
				for(IAvion iAvion : conexion.getAviones())
					textPane.setText(textPane.getText() + "\n" + iAvion.toString());
			}
		});
		
		
		btnModificarAvion.setBackground(Color.WHITE);
		btnModificarAvion.setBounds(10, 40, 145, 23);
		frame.getContentPane().add(btnModificarAvion);
		
		JButton btnCrearAvion = new JButton("Crear Avion");
		btnCrearAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
				System.out.println(">se creo un avion");
				conexion.addAvion( new Avion( "AVI-23",new Aerolinea("AER-24","ADD"),new Posicion(2,2)));
				for(IAvion iAvion : conexion.getAviones())
					textPane.setText(textPane.getText() + "\n" + iAvion.toString());
			}
		});
		btnCrearAvion.setBackground(Color.WHITE);
		btnCrearAvion.setBounds(10, 11, 145, 23);
		frame.getContentPane().add(btnCrearAvion);
		
		JButton btnEliminarAvion = new JButton("Eliminar Avion");
		btnEliminarAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textPane.setText("");
			System.out.println(">se elimino un avion");
			conexion.deleteAvion(conexion.getAviones().get(4));
			
			for(IAvion iAvion : conexion.getAviones())
				textPane.setText(textPane.getText() + "\n" + iAvion.toString());
			}
		});
		btnEliminarAvion.setBackground(Color.WHITE);
		btnEliminarAvion.setBounds(10, 69, 145, 23);
		frame.getContentPane().add(btnEliminarAvion);
		
				
		
		
		
	}
}
