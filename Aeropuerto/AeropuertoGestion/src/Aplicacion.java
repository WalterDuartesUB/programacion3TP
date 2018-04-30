import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) {
		
		System.out.println("Presione enter para apagar el servidor de aeropuertos.");
		
		try( Scanner in = new Scanner( System.in ) )
		{
			//Espero el enter para matar
			in.nextLine();
			
			//Envio el pedido al server de apagarse
			try(Socket s = new Socket( "127.0.0.1", 8889 ) ) {
				
				try( ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() ) )
				{
					oos.writeObject( null );	
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}

	}

}
