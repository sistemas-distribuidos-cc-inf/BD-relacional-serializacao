package cliente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import dados.Pessoa;

/*Classe usada para serializar os objetos
 * que serão enviados pelo cliente para o servidor
 * */
public class Serializador {
	
	public void serializar(Object obj, Socket envio) throws IOException {
		
		ObjectOutputStream saida = new ObjectOutputStream(envio.getOutputStream());
		saida.writeObject(obj);
		saida.close();
	}
	
	//Função que irá serializar o objeto e salavá-lo no disco para posteriormente enviá-lo para o Servidor
	public void serializarEmArquivo(Object obj) throws Exception {
		FileOutputStream objetoParaEnvio = new FileOutputStream("dados.ser");
		ObjectOutputStream saida = new ObjectOutputStream(objetoParaEnvio);
		saida.writeObject(obj);
		saida.close();
	}
}
