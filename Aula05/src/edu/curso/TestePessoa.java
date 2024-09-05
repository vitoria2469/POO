package edu.curso;

public class TestePessoa {

	public static void main(String[] args) {
		Passageiro p1 = new Passageiro("João");
		Pessoa p2 = new Pessoa("Maria");
		
		p1.andar();
		p2.andar();
		
		Pessoa p3 = new Passageiro("vic");
		p3.andar();
		
		
		Cobrador <Passageiro> cobradorPassageiro = new Cobrador<>();
		cobradorPassageiro.cobrarDinheiro(p1);
		
		Cobrador <Pessoa> cobradorPessoa = new Cobrador<>();
		cobradorPessoa.cobrarDinheiro(p2);
		cobradorPessoa.cobrarDinheiro(p3);
		
//		Passageiro p4 = new Pessoa("lucas");
//		p4.andar();

	}

}
