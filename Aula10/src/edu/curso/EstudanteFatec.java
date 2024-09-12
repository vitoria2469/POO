package edu.curso;

public class EstudanteFatec extends Estudante implements Autodedata, Motorista {
	
	@Override
	public void estudar() {
		System.out.println("estudando muito");
	}
	@Override
	public void dirigir() {
		System.out.println("dirigindo loucamente");
	}
	@Override
	public void abrirPorta() {
		System.out.println("abrindo porta do carro");
	}

}
