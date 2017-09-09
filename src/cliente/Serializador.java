package cliente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*Classe usada para serializar os objetos
 * que serão enviados pelo cliente para o servidor
 * */
public class Serializador {
	
	
	//Função que irá serializar o objeto e salavá-lo no disco para posteriormente enviá-lo para o Servidor
	public void serializar(Object obj) throws IOException {
		FileOutputStream objetoParaEnvio = new FileOutputStream("dado.ser");
		ObjectOutputStream saida = new ObjectOutputStream(objetoParaEnvio);
		saida.writeObject(objetoParaEnvio);
		saida.close();
	}
}
