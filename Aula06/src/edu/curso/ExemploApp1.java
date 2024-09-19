package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExemploApp1 extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane panel = new Pane();
		Scene scn = new Scene(panel, 800, 600);
		stage.setScene(scn);
		Label hello = new Label("Hello");
		Button btnOk = new Button("ok");
		TextField txtNome = new TextField();
		btnOk.relocate(200.0, 400.0);
		txtNome.setPrefSize(400.0, 30.0);
		panel.getChildren().addAll(hello, txtNome, btnOk);
		stage.setTitle("Titulo de Janela");
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}