package servidor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import dados.Pessoa;

public class Deserializador {
	
	public Pessoa deserializar(Socket remetente) throws IOException {
		
		ObjectInputStream entrada = new ObjectInputStream(remetente.getInputStream());
		Pessoa novoempregado = new Pessoa();
		try {
			novoempregado = (Pessoa) entrada.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entrada.close();
		return novoempregado;
	}
	
	//Função que irá deserializador o objeto enviado pelo cliente
	public Object deserializarDeArquivo() throws ClassNotFoundException, IOException {
		
		FileInputStream objetoRecebido = new FileInputStream("dados.ser");
		ObjectInputStream entrada = new ObjectInputStream(objetoRecebido);
		
		Object objeto_deserializado = entrada.readObject();
		entrada.close();
		
		return objeto_deserializado;
	}
}
