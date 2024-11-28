package funcionarios;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionarioControl {

    private ObservableList<Funcionario> lista = FXCollections.observableArrayList();
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty sexo = new SimpleStringProperty("");
    private StringProperty endereco = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty cpf = new SimpleStringProperty("");
    private StringProperty cargo = new SimpleStringProperty("");
    private StringProperty setor = new SimpleStringProperty("");
    private IntegerProperty id = new SimpleIntegerProperty(0);

    private int contador = 0;

    private FuncionarioDAO funcionarioDAO;

    public FuncionarioControl() throws FuncionarioException {
        funcionarioDAO = new FuncionarioDAOImpl();
    }

    public void entidadeParaTela(Funcionario f) {
        this.id.set(f.getId());
        this.nome.set(f.getNome());
        this.cpf.set(f.getCpf());
        this.sexo.set(f.getSexo());
        this.endereco.set(f.getEndereco());
        this.telefone.set(f.getTelefone());
        this.email.set(f.getEmail());
        this.cargo.set(f.getCargo());
        this.setor.set(f.getSetor());
    }

    public void excluir(Funcionario f) throws FuncionarioException {
        System.out.println("Excluido paciente com nome: " + f.getNome());
        lista.remove(f);
        funcionarioDAO.remover(f);
        pesquisarTodos();
    }

    public void gravar() throws FuncionarioException {
        if (id.get() == 0) {
            Funcionario f = new Funcionario();
            contador += 1;
            f.setId(contador);
            f.setNome(this.nome.get());
            f.setCpf(this.cpf.get());
            f.setSexo(this.sexo.get());
            f.setEndereco(this.endereco.get());
            f.setTelefone(this.telefone.get());
            f.setEmail(this.email.get());
            f.setCargo(this.cargo.get());
            f.setSetor(this.setor.get());
            lista.add(f);
            funcionarioDAO.inserir(f);
        } else {
            for (Funcionario f : lista) {
                if (f.getId() == this.id.get()) {
                    f.setNome(this.nome.get());
                    f.setCpf(this.cpf.get());
                    f.setSexo(this.sexo.get());
                    f.setEndereco(this.endereco.get());
                    f.setTelefone(this.telefone.get());
                    f.setEmail(this.email.get());
                    f.setCargo(this.cargo.get());
                    f.setSetor(this.setor.get());
                    funcionarioDAO.atualizar(f);
                }
            }
        }
        pesquisarTodos();
        limparTudo();
        System.out.println("Lista tamanho: " + lista.size());
    }

    public void limparTudo() {
        id.set(0);
        nome.set("");
        cpf.set("");
        sexo.set("");
        endereco.set("");
        telefone.set("");
        email.set("");
        cargo.set("");
        setor.set("");
    }

    // A fazer: pesquisar no banco
    public void pesquisarPorNome() throws FuncionarioException {
        for (Funcionario f : lista) {
            if (f.getNome().contains(nome.get())) {
                nome.set(f.getNome());
                cpf.set(f.getCpf());
                sexo.set(f.getSexo());
                endereco.set(f.getEndereco());
                telefone.set(f.getTelefone());
                email.set(f.getEmail());
                cargo.set(f.getCargo());
                setor.set(f.getSetor());
                break;
            }
        }
    }

    public void pesquisarTodos() throws FuncionarioException {
        lista.clear();
        lista.addAll(funcionarioDAO.pesquisarTodos());
    }

    public ObservableList<Funcionario> getLista() {
        return this.lista;
    }

    public IntegerProperty idProperty() {
        return this.id;
    }

    public StringProperty nomeProperty() {
        return this.nome;
    }

    public StringProperty cpfProperty() {
        return this.cpf;
    }

    public StringProperty sexoProperty() {
        return this.sexo;
    }

    public StringProperty enderecoProperty() {
        return this.endereco;
    }

    public StringProperty telefoneProperty() {
        return this.telefone;
    }

    public StringProperty emailProperty() {
        return this.email;
    }

    public StringProperty cargoProperty() {
        return this.cargo;
    }

    public StringProperty setorProperty() {
        return this.setor;
    }

}