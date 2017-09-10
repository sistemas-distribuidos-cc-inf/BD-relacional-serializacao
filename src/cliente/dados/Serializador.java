package cliente.dados;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializador {
	
	//Função que irá serializar o objeto e salavá-lo no disco para posteriormente enviá-lo para o Cliente
		public void serializar(Object obj) throws IOException {
			//O arquivo serializado terá o mesmo nome que o arquivo serializado pelo cliente
			FileOutputStream objetoParaEnvio = new FileOutputStream("dado.ser");
			ObjectOutputStream saida = new ObjectOutputStream(objetoParaEnvio);
			saida.writeObject(objetoParaEnvio);
			saida.close();
		}
}
