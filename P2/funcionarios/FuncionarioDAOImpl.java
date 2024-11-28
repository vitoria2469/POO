package funcionarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import funcionarios.Funcionario;

public class FuncionarioDAOImpl implements FuncionarioDAO {

    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/hospitaldb?allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";
    private Connection con = null;

    public FuncionarioDAOImpl() throws FuncionarioException {
        try {
            Class.forName(DB_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new FuncionarioException(e);
        }
    }

    @Override
    public void inserir(Funcionario f) throws FuncionarioException {
        try {
            inserirPessoa(f);
            String SQL = """
                    INSERT INTO funcionario (pessoaCpf, email)
                    VALUES (?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, 0);
            stm.setString(2, f.getEmail());
            int i = stm.executeUpdate();
            System.out.println(i);
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
    }

    private void inserirPessoa(Funcionario f) throws FuncionarioException {
        try {
            String SQL = """
                    INSERT INTO pessoa (cpf, nome, cargo, sexo, endereco, telefone, email, setor)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? )
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, 0);
            stm.setString(2, f.getNome());
            stm.setString(3, f.getCpf());
            stm.setString(4, f.getSexo());
            stm.setString(5, f.getEndereco());
            stm.setString(6, f.getTelefone());
            stm.setString(7, f.getEmail());
            stm.setString(8, f.getCargo());
            stm.setString(9, f.getSetor());
            int i = stm.executeUpdate();
            System.out.println(i);
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
    }

    @Override
    public void atualizar(Funcionario f) throws FuncionarioException {
        try {
            atualizarPessoa(f);
            String SQL = """
                    UPDATE funcionario SET email=?
                    WHERE pessoaCpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, f.getEmail());
            stm.setInt(2, f.getId());
            int i = stm.executeUpdate();
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
    }

    private void atualizarPessoa(Funcionario f) throws FuncionarioException {
        try {
            atualizarPessoa(f);
            String SQL = """
                    UPDATE pessoa SET nome=?, sexo=?, endereco=?, telefone=?, email=?, cargo=?, setor=?
                    WHERE cpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, f.getNome());
            stm.setString(2, f.getSexo());
            stm.setString(3, f.getEndereco());
            stm.setString(4, f.getTelefone());
            stm.setString(5, f.getEmail());
            stm.setString(6, f.getCargo());
            stm.setString(7, f.getSetor());
            stm.setInt(8, f.getId());
            int i = stm.executeUpdate();
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
    }

    @Override
    public void remover(Funcionario f) throws FuncionarioException {
        try {
            String SQL = """
                        DELETE FROM funcionario WHERE pessoaCpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, f.getId());
            int i = stm.executeUpdate();
            removerPessoa(f);
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
    }

    private void removerPessoa(Funcionario f) throws FuncionarioException {
        try {
            String SQL = """
                        DELETE FROM pessoa WHERE cpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, f.getId());
            int i = stm.executeUpdate();
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
    }

    @Override
    public List<Funcionario> pesquisarPorNome(String nome) throws FuncionarioException {
        List<Funcionario> lista = new ArrayList<>();
        try {

            String SQL = """
                      SELECT pessoa.cpf, pessoa.nome, pessoa.sexo, pessoa.endereco, pessoa.telefone, pessoa.email, funcionario.setor, funcionario.cargo FROM pessoa
                      INNER JOIN funcionario ON funcionario.pessoaCpf = pessoa.cpf
                      WHERE nome LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("cpf"));
                f.setNome(rs.getString("nome"));
                f.setSexo(rs.getString("sexo"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setCargo(rs.getString("cagor"));
                f.setSetor(rs.getString("setor"));
                lista.add(f);
            }
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
        return lista;
    }

    @Override
    public List<Funcionario> pesquisarTodos() throws FuncionarioException {
        List<Funcionario> lista = new ArrayList<>();
        try {
            String SQL = """
                        SELECT pessoa.cpf, pessoa.nome, pessoa.sexo, pessoa.endereco, pessoa.telefone, pessoa.email, funcionario.setor, funcionario.cargo FROM pessoa
                        INNER JOIN funcionario ON funcionario.pessoaCpf = pessoa.cpf
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("cpf"));
                f.setNome(rs.getString("nome"));
                f.setSexo(rs.getString("sexo"));
                f.setEndereco(rs.getString("endereco"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setCargo(rs.getString("cagor"));
                f.setSetor(rs.getString("setor"));
                lista.add(f);
            }
        } catch (SQLException er) {
            er.printStackTrace();
            throw new FuncionarioException(er);
        }
        return lista;
    }

}