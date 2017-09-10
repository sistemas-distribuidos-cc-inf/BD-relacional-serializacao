package servidor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import dados.Pessoa;

public class Deserializador {
	
	//Função que irá deserializador o objeto enviado pelo cliente
	public Object deserializar() throws ClassNotFoundException, IOException {
		
		FileInputStream objetoRecebido = new FileInputStream("dados.ser");
		ObjectInputStream entrada = new ObjectInputStream(objetoRecebido);
		
		Object objeto_deserializado = entrada.readObject();
		entrada.close();
		
		return objeto_deserializado;
	}
}
