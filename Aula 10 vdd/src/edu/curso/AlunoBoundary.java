package edu.curso;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class AlunoBoundary extends Application {

	private TextField txtNome = new TextField("");
	private TextField txtRa = new TextField("");
	private TextField txtIdade = new TextField("");

	private Button btnSalvar = new Button("Salvar");
	private Button btnPesq = new Button("Pesquisar");

	private AlunoControl control = new AlunoControl();

	@Override
	public void start(Stage stage) {
		BorderPane panePrincipal = new BorderPane();
		Scene scn = new Scene(panePrincipal, 800, 600);

		GridPane paneGrid = new GridPane();
		paneGrid.add(new Label("Nome: "), 0, 0);
		paneGrid.add(txtNome, 1, 0);
		paneGrid.add(new Label("RA: "), 0, 1);
		paneGrid.add(txtRa, 1, 1);
		paneGrid.add(new Label("Idade: "), 0, 2);
		paneGrid.add(txtIdade, 1, 2);
		paneGrid.add(btnSalvar, 0, 3);
		paneGrid.add(btnPesq, 1, 3);
		panePrincipal.setCenter(paneGrid);

		NumberStringConverter conversor = new NumberStringConverter();
		
		Bindings.bindBidirectional(txtRa.textProperty(), control.raProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(txtIdade.textProperty(), control.idadeProperty(), conversor);

		btnSalvar.setOnAction(e -> {
			control.salvar();
		});

		btnPesq.setOnAction(e -> {
			control.pesquisar();
		});

		stage.setScene(scn);
		stage.setTitle("Gestao de Contatos");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(AlunoBoundary.class, args);
	}

}