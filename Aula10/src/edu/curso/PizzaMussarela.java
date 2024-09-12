package edu.curso;

public class PizzaMussarela extends Pizza{
	public PizzaMussarela () {
		this.sabor = "Mussarela";
		
	}
	@Override
	public void preparar() {
		System.out.println("aaaaaaaa");

	}
	@Override
	public void assar() {
		System.out.println("bbbbbbbbb");
		System.out.println("ccccccccc");

	}

}