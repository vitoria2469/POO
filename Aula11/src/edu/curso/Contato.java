package edu.curso;

import java.time.LocalDate;

public class Contato {
	private int id = 0;
	private String nome = "";
	private String telefone = "";
	private String email = "";
	private LocalDate dtNasc = LocalDate.now();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String valor) {
		this.nome = valor;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate valor) {
		this.dtNasc = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int valor) {
		this.id = valor;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String valor) {
		this.telefone = valor;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String valor) {
		this.email = valor;
	}
}