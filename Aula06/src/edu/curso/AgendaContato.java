package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgendaContato extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		GridPane panel = new GridPane();
		Scene scn = new Scene(panel, 650, 200);
		stage.setScene(scn);
		panel.setHgap(5);
		panel.setVgap(5);
		
		Label l1 = new Label("Id");
		Label l2 = new Label("Nome");
		Label l3 = new Label("Telefone");
		panel.add(l1, 1, 2);
		panel.add(l2, 1, 3);
		panel.add(l3, 1, 4);
		
		TextField txtId = new TextField();
		TextField txtNome = new TextField();
		TextField txtTel = new TextField();
		panel.add(txtId, 3, 2);
		panel.add(txtNome, 3, 3);
		panel.add(txtTel, 3, 4);
		
		Button btn1 = new Button("Salvar");
		Button btn2 = new Button("Pesquisar");
		panel.add(btn1, 1, 5);
		panel.add(btn2, 2, 5);
		
		txtNome.setPrefSize(400.0, 30.0);
		txtId.setPrefSize(400.0, 30.0);
		txtTel.setPrefSize(400.0, 30.0);

		stage.setTitle("Agenda de Contatos");
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}