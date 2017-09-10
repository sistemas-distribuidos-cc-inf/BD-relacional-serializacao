package cliente.dados;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializador {
	
	//Função que irá deserializador o objeto enviado pelo cliente
	public Object deserializar() throws ClassNotFoundException, IOException {
		
		FileInputStream objetoRecebido = new FileInputStream("testa.ser");
		ObjectInputStream entrada = new ObjectInputStream(objetoRecebido);
		
		Object objeto_deserializado = entrada.readObject();
		entrada.close();
		
		return objeto_deserializado;
	}
}
