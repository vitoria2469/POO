package edu.curso;

public class EntregadorLiberal extends Entregador implements Motorista {
	
	@Override		
	public void dirigir() {
		System.out.println("digirindo bem rapido");
	}
	
	@Override
	public void abrirPorta() {
		System.out.println("abrindo porta do carro");
	}

}
