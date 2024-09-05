package edu.curso;

public class Passageiro extends Pessoa {
	
	public Passageiro(String nome) {
		super( nome );
	}
	
	public void andar() {
		super.andar();
		System.out.println(" com pressa e atenção");
	}
	
	public void embarcar() {
		System.out.printf(" embarcando %s", this.nome);
	}

}