package cliente.dados;

public class Pessoa {
	private String nome;
	private int idade;
	
	Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	String getNome() {
		return nome;
	}
	
	int getIdade() {
		return idade;
	}
		
}
