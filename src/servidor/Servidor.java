package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		
		//Criando socket do servidor, abrindo aplicação na porta 12345
		ServerSocket socket_servidor = new ServerSocket(12345);	
		
		//Aguardando a conexão com o cliente
		Socket socket_cliente = socket_servidor.accept();
		

		socket_servidor.close();
		socket_cliente.close();
	}
}
