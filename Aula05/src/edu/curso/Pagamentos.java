package edu.curso;

public class Pagamentos {
	
	public fazPagamento(Trabalhador t) {
		double total = t.horas * 15.0 + 100.0;
		t.receberSalario(total);
	}

}
