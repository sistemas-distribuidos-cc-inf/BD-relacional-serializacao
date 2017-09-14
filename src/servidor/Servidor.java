package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import bancodedados.*;
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
		
		empregadonovo = deserializa.deserializar(socket_cliente);
		
		System.out.println("Nome do novo empregado: " + empregadonovo.getNome());
		
		PessoaDAO dao = new PessoaDAO();
		
		dao.adiciona(empregadonovo);
		
		System.out.println("Foi gravado no banco de dados!");
		
		socket_servidor.close();
		socket_cliente.close();
	}
}
