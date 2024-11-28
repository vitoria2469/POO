package funcionarios;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class FuncionarioBoundary extends Application {

    private Label lblId = new Label("");
    private TextField txtNome = new TextField("");
    private TextField txtEmail = new TextField("");
    private TextField txtSenha = new TextField("");
    private TextField txtTelefone = new TextField("");
    private TextField txtSetor = new TextField("");

    private TableView<Funcionario> tableView = new TableView<>();

    private FuncionarioControl control;

    @Override
    public void start(Stage stage) {

        try {
            control = new FuncionarioControl();
        } catch (FuncionarioException er) {
            alert(AlertType.ERROR, "Erro ao incializar sistema");
        }

        BorderPane panePrincipal = new BorderPane();

        GridPane paneForm = new GridPane();
        paneForm.add(new Label("Id: "), 0, 0);
        paneForm.add(lblId, 1, 0);
        paneForm.add(new Label("Nome: "), 0, 1);
        paneForm.add(txtNome, 1, 1);
        paneForm.add(new Label("Telefone: "), 0, 2);
        paneForm.add(txtTelefone, 1, 2);
        paneForm.add(new Label("Email: "), 0, 3);
        paneForm.add(txtEmail, 1, 3);
        paneForm.add(new Label("Senha: "), 0, 4);
        paneForm.add(txtSenha, 1, 4);
        paneForm.add(new Label("Setor: "), 0, 5);
        paneForm.add(txtSetor, 1, 5);

        Button btnGravar = new Button("Gravar");
        btnGravar.setOnAction(
                e -> {
                    try {
                        control.gravar();
                        tableView.refresh();
                    } catch (FuncionarioException er) {
                        alert(AlertType.ERROR, "Erro ao gravar");
                    }
                });
        Button btnPesquisar = new Button("Pesquisar");
        btnPesquisar.setOnAction(e -> {
            try {
                control.pesquisarPorNome();
            } catch (FuncionarioException er) {
                alert(AlertType.ERROR, "Errro ao pesquisar");
            }
        });

        Button btnLimpar = new Button("*");
        btnLimpar.setOnAction(e -> control.limparTudo());

        paneForm.add(btnGravar, 0, 8);
        paneForm.add(btnPesquisar, 1, 8);
        paneForm.add(btnLimpar, 2, 0);

        generateColumns();
        vincularPropriedes();

        panePrincipal.setTop(paneForm);
        panePrincipal.setCenter(tableView);

        Scene scn = new Scene(panePrincipal, 600, 400);
        stage.setScene(scn);
        stage.setTitle("Funcionarios");
        stage.show();
    }

    public void generateColumns() {
        TableColumn<Funcionario, Integer> col1 = new TableColumn<>("Id");
        col1.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("id"));

        TableColumn<Funcionario, String> col2 = new TableColumn<>("Nome");
        col2.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));

        TableColumn<Funcionario, String> col3 = new TableColumn<>("Telefone");
        col3.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("telefone"));

        TableColumn<Funcionario, String> col4 = new TableColumn<>("Email");
        col4.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("email"));

        TableColumn<Funcionario, String> col5 = new TableColumn<>("Senha");
        col5.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("senha"));

        TableColumn<Funcionario, String> col6 = new TableColumn<>("Setor");
        col6.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("setor"));

        Callback<TableColumn<Funcionario, Void>, TableCell<Funcionario, Void>> callback = new Callback<>() {
            @Override
            public TableCell<Funcionario, Void> call(TableColumn<Funcionario, Void> param) {
                TableCell<Funcionario, Void> tc = new TableCell<>() {
                    final Button btnExcluir = new Button("Apagar");
                    {
                        btnExcluir.setOnAction(
                                e -> {
                                    try {
                                        Funcionario f = tableView.getItems().get(getIndex());
                                        control.excluir(f);
                                    } catch (FuncionarioException er) {
                                        alert(AlertType.ERROR, "Erro ao excluir");
                                    }
                                });
                    }

                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnExcluir);
                        }
                    }
                };
                return tc;
            }
        };

        TableColumn<Funcionario, Void> col7 = new TableColumn<>("Ações");
        col7.setCellFactory(callback);

        tableView.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
        tableView.setItems(control.getLista());

        tableView.getSelectionModel().selectedItemProperty()
                .addListener((obs, antigo, novo) -> {
                    System.out.println("Selecionado o funcionario ==> " + novo);
                    control.entidadeParaTela(novo);
                });
    }

    public void vincularPropriedes() {
        Bindings.bindBidirectional(lblId.textProperty(), control.idProperty(),
                (StringConverter) new IntegerStringConverter());
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtTelefone.textProperty(), control.telefoneProperty());
        Bindings.bindBidirectional(txtEmail.textProperty(), control.emailProperty());
        Bindings.bindBidirectional(txtSenha.textProperty(), control.senhaProperty());
        Bindings.bindBidirectional(txtSetor.textProperty(), control.setorProperty());
    }

    public void alert(AlertType tipo, String msg) {
        Alert alertWindow = new Alert(tipo);
        alertWindow.setHeaderText("Alerta");
        alertWindow.setContentText(msg);
        alertWindow.showAndWait();
    }

    public static void main(String[] args) {
        Application.launch(FuncionarioBoundary.class, args);
    }

}