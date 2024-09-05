package edu.curso;

public class PagamentoMelhor extends Pagamentos{
	
	@override
	public fazPagamento(Trabalhador t) {
		double total = t.horas * 30.0 + 100.0;
		t.receberSalario(total);
	}
	
}
