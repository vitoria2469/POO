package edu.curso;

public class TrabalhadorAutodedata extends Trabalhador implements Investidor, Motorista, Estudante {
	
	@Override		
	public void investir() {
		System.out.println("investirndo na poupanca");
	}
	
	@Override		
	public void dirigir() {
		System.out.println("digirindo bem devagar");
	}
	
	@Override		
	public void abrirPorta() {
		System.out.println("abrindo porta com presa");
	}
	
	@Override		
	public void estudar() {
		System.out.println("estudando");
	}
	

}
