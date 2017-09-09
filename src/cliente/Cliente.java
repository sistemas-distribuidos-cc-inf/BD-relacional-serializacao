package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//Criando o socket do cliente para que o cliente faça a conexão com o servidor
		Socket socket_cliente = new Socket("127.0.0.1", 12345);
		
		
		socket_cliente.close();
	}
}
