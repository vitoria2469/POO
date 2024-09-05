package edu.curso;

public class Empresa {

	public static void main(String[] args) {
		Trabalhador t1 = new Trabalhador("Denis", 110);
		t1.receberSalario();
		Trabalhador t2 = new Trabalhador("Marcos", 120);
		t2.receberSalario();
		Trabalhador t3 = new Trabalhador("Camila", 130);
		t3.receberSalario();
		
		Pagamentos rh = new PagementoMelhor();
		rh.fazPagamento(t1);
		rh.fazPagamento(t2);
		rh.fazPagamento(t3);
		

	}

}
