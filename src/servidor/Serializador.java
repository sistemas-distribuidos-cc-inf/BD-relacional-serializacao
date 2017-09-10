package servidor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Serializador {
	
		public void serializar(Object obj, Socket envio) throws IOException {
		
			ObjectOutputStream saida = new ObjectOutputStream(envio.getOutputStream());
			saida.writeObject(obj);
			saida.close();
		}
	
	//Função que irá serializar o objeto e salavá-lo no disco para posteriormente enviá-lo para o Cliente
		public void serializar(Object obj) throws IOException {
			//O arquivo serializado terá o mesmo nome que o arquivo serializado pelo cliente
			FileOutputStream objetoParaEnvio = new FileOutputStream("dados.ser");
			ObjectOutputStream saida = new ObjectOutputStream(objetoParaEnvio);
			saida.writeObject(obj);
			saida.close();
		}
}
