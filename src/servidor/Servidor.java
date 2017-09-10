package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dados.Pessoa;

public class Servidor {
	public static void main(String[] args) throws IOException {
		
		//Criando socket do servidor, abrindo aplicação na porta 12345
		ServerSocket socket_servidor = new ServerSocket(12345);	
		
		//Aguardando a conexão com o cliente
		Socket socket_cliente = socket_servidor.accept();
		System.out.println("Nova conexão foi estabelecida " + socket_cliente.getInetAddress().getHostAddress());
		
		Pessoa empregadonovo = new Pessoa();
		Deserializador deserializa = new Deserializador();
		
		ObjectOutputStream saida = new ObjectOutputStream(socket_cliente.getOutputStream());
		//ObjectInputStream entrada = new ObjectInputStream(socket_cliente.getInputStream());
		
		empregadonovo = (Pessoa) deserializa.deserializar(socket_cliente);
		
		System.out.println("Nome do novo empregado: " + empregadonovo.getNome());
		
		socket_servidor.close();
		saida.close();
		//entrada.close();
		socket_cliente.close();
	}
}
