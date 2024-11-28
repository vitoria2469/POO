package medicos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicoControl {

    private ObservableList<Medico> lista = FXCollections.observableArrayList();
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty sexo = new SimpleStringProperty("");
    private StringProperty endereco = new SimpleStringProperty("");
    private StringProperty telefone = new SimpleStringProperty("");
    private StringProperty email = new SimpleStringProperty("");
    private StringProperty cpf = new SimpleStringProperty("");
    private StringProperty especialidade = new SimpleStringProperty("");
    private StringProperty setor = new SimpleStringProperty("");
    private StringProperty crm = new SimpleStringProperty("");

    private IntegerProperty id = new SimpleIntegerProperty(0);

    private int contador = 0;

    private MedicoDAO medicoDAO;

    public MedicoControl() throws MedicoException {
        medicoDAO = new MedicoDAOImpl();
    }

    public void entidadeParaTela(Medico m) {
        this.id.set(m.getId());
        this.nome.set(m.getNome());
        this.cpf.set(m.getCpf());
        this.sexo.set(m.getSexo());
        this.endereco.set(m.getEndereco());
        this.telefone.set(m.getTelefone());
        this.email.set(m.getEmail());
        this.especialidade.set(m.getEspecialidade());
        this.setor.set(m.getSetor());
        this.crm.set(m.getCrm());
    }

    public void excluir(Medico m) throws MedicoException {
        System.out.println("Excluido paciente com nome: " + m.getNome());
        lista.remove(m);
        medicoDAO.remover(m);
        pesquisarTodos();
    }

    public void gravar() throws MedicoException {
        if (id.get() == 0) {
            Medico m = new Medico();
            contador += 1;
            m.setId(contador);
            m.setNome(this.nome.get());
            m.setCpf(this.cpf.get());
            m.setSexo(this.sexo.get());
            m.setEndereco(this.endereco.get());
            m.setTelefone(this.telefone.get());
            m.setEmail(this.email.get());
            m.setEspecialidade(this.especialidade.get());
            m.setSetor(this.setor.get());
            m.setCrm(this.crm.get());
            lista.add(m);
            medicoDAO.inserir(m);
        } else {
            for (Medico m : lista) {
                if (m.getId() == this.id.get()) {
                    m.setNome(this.nome.get());
                    m.setCpf(this.cpf.get());
                    m.setSexo(this.sexo.get());
                    m.setEndereco(this.endereco.get());
                    m.setTelefone(this.telefone.get());
                    m.setEmail(this.email.get());
                    m.setEspecialidade(this.especialidade.get());
                    m.setSetor(this.setor.get());
                    m.setCrm(this.crm.get());
                    medicoDAO.atualizar(m);
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
        especialidade.set("");
        setor.set("");
        crm.set("");
    }

    public void pesquisarPorNome() throws MedicoException {
        for (Medico m : lista) {
            if (m.getNome().contains(nome.get())) {
                nome.set(m.getNome());
                cpf.set(m.getCpf());
                sexo.set(m.getSexo());
                endereco.set(m.getEndereco());
                telefone.set(m.getTelefone());
                email.set(m.getEmail());
                especialidade.set(m.getEspecialidade());
                setor.set(m.getSetor());
                crm.set(m.getCrm());
                break;
            }
        }
    }

    public void pesquisarTodos() throws MedicoException {
        lista.clear();
        lista.addAll(medicoDAO.pesquisarTodos());
    }

    public ObservableList<Medico> getLista() {
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

    public StringProperty especialidadeProperty() {
        return this.especialidade;
    }

    public StringProperty setorProperty() {
        return this.setor;
    }

    public StringProperty crmProperty() {
        return this.crm;
    }

}