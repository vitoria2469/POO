package edu.curso;

import java.util.List;

public class Funcionario implements Publicador {
	private double salarioBase = 0.0;
	private String nome = "";
	private int hTrabalhadas = 0;
	private String matricula = "";
	private List<Pagador> pagador = new ArrayList<>();
	
	@Override
	public void adicionarPagador(Pagador a) {
		pagador.add(a);
	}
	
	public double getSalarioBase() {
		return salarioBase;
	}
	
	public void setSalarioBase(double valor) {
		this.salarioBase = valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int gethTrabalhadas() {
		return hTrabalhadas;
	}
	
	public void sethTrabalhadas(int valor) {
		this.hTrabalhadas = valor;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}