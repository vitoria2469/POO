package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class janelaContatos extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane panel = new Pane();
		Scene scn = new Scene(panel, 650, 200);
		stage.setScene(scn);
		
		Label l1 = new Label("Id");
		Label l2 = new Label("Nome");
		Label l3 = new Label("Telefone");
		
		TextField txtId = new TextField();
		TextField txtNome = new TextField();
		TextField txtTel = new TextField();
		
		Button btn1 = new Button("Salvar");
		Button btn2 = new Button("Pesquisar");
		
		btn1.relocate(50, 165);
		btn2.relocate(100, 165);
		
		txtId.relocate(100, 50);
		txtNome.relocate(100, 90);
		txtTel.relocate(100, 130);
		
		l1.relocate(50, 50);
		l2.relocate(50, 90);
		l3.relocate(50, 130);
		
		txtNome.setPrefSize(400.0, 30.0);
		txtId.setPrefSize(400.0, 30.0);
		txtTel.setPrefSize(400.0, 30.0);
		
		panel.getChildren().addAll(l1, l2, l3, txtNome, txtId, txtTel, btn1, btn2);
		stage.setTitle("Exercicio");
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
