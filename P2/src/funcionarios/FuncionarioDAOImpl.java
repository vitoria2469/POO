package funcionarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAOImpl implements FuncionarioDAO {

    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/cadastrodb?allowPublicKeyRetrieval=true";
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

            String SQL = """
                    INSERT INTO funcionario (nome, email, telefone, senha, setor)
                    VALUES (?, ?, ?, ?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, f.getNome());
            stm.setString(2, f.getEmail());
            stm.setString(3, f.getTelefone());
            stm.setString(4, f.getSenha());
            stm.setString(5, f.getSetor());
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
            String SQL = """
                    UPDATE funcionario SET nome=?, email=?, telefone=?, senha=?, setor=?
                    WHERE registro=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, f.getNome());
            stm.setString(2, f.getEmail());
            stm.setString(3, f.getTelefone());
            stm.setString(4, f.getSenha());
            stm.setString(5, f.getSetor());
            stm.setInt(6, f.getId());
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
                        DELETE FROM funcionario WHERE registro=?
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
                      SELECT * from funcionario
                      WHERE nome LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("registro"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
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
                        SELECT * from funcionario
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("registro"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
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