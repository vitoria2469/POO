package edu.curso;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class TestePropriedades {
	
	public static void notificar(String antigo, String novo) {
		System.out.println("Nome foi alterado");
	}

	public static void main(String[] args) {
		TextField txtNome = new TextField();
		txtNome.textProperty().addListener((obj, antigo, novo) -> {
		StringProperty nome = new SimplesStringProperty("Mario");
		
		nome.addListener((obs, antigo, novo) -> {
			notificar(antigo, novo);
		});
		
		System.out.println("Inicio do Programa");
		nome.set("Luigi");
		nome.set("Toad");
		nome.set("Bowser");
		System.out.println("Fim do Programa");

	}

}