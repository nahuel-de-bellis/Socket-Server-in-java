package socket;
import java.net.*;
import java.io.*;

public class server {
	int puerto = 5000;
	ServerSocket sc;
	Socket so;
	DataOutputStream salida;
	String mensaje;

	
	public void initServer()
	{
		
		BufferedReader entrada;
		
		try
		{
			sc = new ServerSocket(puerto);
			so = new Socket();
			System.out.println("Esperando....");
			so = sc.accept();
			System.out.println("Nuevo cliente");
			entrada = new BufferedReader(
						new InputStreamReader(
							so.getInputStream()
							)
					);
			salida = new DataOutputStream(
						so.getOutputStream()
					);
			System.out.println("Conexion establecida");
			salida.writeUTF("Hola");
			mensaje = entrada.readLine();
			System.out.println(mensaje);
			salida.writeUTF(" Recibido");
			sc.close();
			
		}
		catch(Exception e){
			
			System.out.println("Error"+e.getMessage());
		}
	}
	
	

}
