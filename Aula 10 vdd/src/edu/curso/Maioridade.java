package edu.curso;

import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class Maioridade {
	
	public static void notificar(String antigo, String novo) {
		System.out.println("Nome foi alterado");
	}

	public static void main(String[] args) {

		IntegerProperty idade = new SimplesStringProperty("Mario");
		
		idade.addListener((obs, antigo, novo) -> {
			notificar(antigo, novo);
		});
		
		

	}

}