package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {

	private ObservableList<Contato> lista = FXCollections.observableArrayList();

	private StringProperty nome = new SimpleStringProperty();
	private StringProperty telefone = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();

	public StringProperty nomeProperty() {
		return this.nome;
	}

	public StringProperty telefoneProperty() {
		return this.telefone;
	}

	public StringProperty emailProperty() {
		return this.email;
	}

	public void gravar() {
		System.out.println("Valor atual do nome: " + nome.get());
		nome.set("");
	}

	public ContatoControl() {
		Contato c1 = new Contato();
		c1.setNome("João Silva");
		c1.setEmail("joao@teste.com");
		c1.setTelefone("(11) 1111-1111");

		Contato c2 = new Contato();
		c2.setNome("Maria Silva");
		c2.setEmail("Maria@teste.com");
		c2.setTelefone("(11) 2222-2222");

		lista.addAll(c1, c2);
	}

	public ObservableList<Contato> getLista() {
		return this.lista;
	}

}