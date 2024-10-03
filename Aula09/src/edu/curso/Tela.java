package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tela extends Application {

	private TextField txtNome = new TextField();
	private TextField txtTel = new TextField();
	private TextField txtEmail = new TextField();
	private Control control = new Control();

	@Override
	public void start(Stage stage) {
		GridPane panel = new GridPane();
		Scene scn = new Scene(panel, 600, 300);
		stage.setScene(scn);
		panel.setHgap(5);
		panel.setVgap(5);
		
		Label l1 = new Label("Nome");
		Label l2 = new Label("Telefone");
		Label l3 = new Label("Email");
		panel.add(l1, 1, 2);
		panel.add(l2, 1, 3);
		panel.add(l3, 1, 4);
		
		
		panel.add(txtNome, 3, 2);
		panel.add(txtTel, 3, 3);
		panel.add(txtEmail, 3, 4);
		
		Button btnGravar = new Button("Gravar");
		btnGravar.setOnAction(e -> {
			control.gravar(telaToEntity() );
			});
		Button btnPesquisar = new Button("Pesquisar");
		btnPesquisar.setOnAction(e -> {
			entityToTela(control.pesquisar(txtNome.getText()) );
			});
		panel.add(btnGravar, 1, 5);
		panel.add(btnPesquisar, 2, 5);
		
		txtNome.setPrefSize(400.0, 30.0);
		txtTel.setPrefSize(400.0, 30.0);
		txtEmail.setPrefSize(400.0, 30.0);

		stage.setTitle("Agenda de Contatos");
		stage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

	public Contato telaToEntity() {
		Contato c = new Contato();
		c.setNome(txtNome.getText());
		c.setTel(txtTel.getText());
		c.setEmail(txtEmail.getText());
		return c;
	}

	public void entityToTela(Contato c) {
		if (c != null) {
			txtNome.setText(c.getNome());
			txtTel.setText(c.getTel());
			txtEmail.setText(c.getEmail());
		}

	}

}
