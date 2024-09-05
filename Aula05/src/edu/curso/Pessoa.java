package edu.curso;

public class Pessoa {
	String cpf;
	String nome;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	public void andar() {
		System.out.printf("%nAndando %s", this.nome);
	}

}
