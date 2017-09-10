package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


import dados.Pessoa;


public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//Criando o socket do cliente para que o cliente faça a conexão com o servidor
		Socket socket_cliente = new Socket("127.0.0.1", 12345);
		
		//Assim que o cliente se conectar começar a serialização do objeto
		Pessoa novoempregado = new Pessoa("Fulano323", 34);
		Serializador serializador = new Serializador();
		
		ObjectInputStream entrada = new ObjectInputStream(socket_cliente.getInputStream());
		
		serializador.serializar(novoempregado, socket_cliente);
		
		/*
		try {
			serializa.serializar(novoempregado);
			
		} catch (Exception ex) {
			System.err.println("Erro na serialização do objeto: " + ex.toString());
		}*/
		
		
		
		//saida.close();
		socket_cliente.close();
	}
}
