package edu.curso;

public class PizzaCalabresa extends Pizza{
	public PizzaCalabresa () {
		this.sabor = "Calabresa";
		
	}
	@Override
	public void preparar() {
		System.out.println("ddddddddd");

	}
	@Override
	public void assar() {
		System.out.println("fffffffff");
		System.out.println("ggggggggg");

	}

}