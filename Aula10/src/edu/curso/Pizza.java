package edu.curso;

public abstract class Pizza {
	int tamanho = 1;
	String sabor;
	
	public void cortar() {
		if (tamanho == 1) {
			System.out.println("cortada em 2 pedacos");
		} else if (tamanho == 2) {
			System.out.println("cortada em 4 pedacos");
		} else {
			System.out.println("cortada em 8 pedacos");
		}
			
	}
	
	public abstract void preparar();
	
	public abstract void assar();
	
}