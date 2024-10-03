package edu.curso;

public class Contato {
	private String nome;
	private String tel;
	private String email;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String valor) {
		this.nome = valor;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String valor) {
		this.tel = valor;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String valor) {
		this.email = valor;
	}

	@Override
	public String toString() {
		return String.format("Contato(nome='%s', tel='%s', email='%s')", this.nome, this.tel, this.email);
	}

}