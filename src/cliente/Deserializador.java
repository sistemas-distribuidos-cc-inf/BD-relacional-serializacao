package cliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*	Classe usada para deserializar os objetos que
 * 	o cliente receberá do servidor
 * */

public class Deserializador {
	
	public Object deserializar() throws ClassNotFoundException, IOException {
		FileInputStream objetoRecebido = new FileInputStream("testa.ser");
		ObjectInputStream entrada = new ObjectInputStream(objetoRecebido);
		
		Object objeto_deserializado = entrada.readObject();
		entrada.close();
		
		return objeto_deserializado;
	}
}
