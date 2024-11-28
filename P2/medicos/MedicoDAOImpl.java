package medicos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import medicos.Medico;

public class MedicoDAOImpl implements MedicoDAO {

    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/hospitaldb?allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";
    private Connection con = null;

    public MedicoDAOImpl() throws MedicoException {
        try {
            Class.forName(DB_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new MedicoException(e);
        }
    }

    @Override
    public void inserir(Medico m) throws MedicoException {
        try {
            inserirPessoa(m);
            String SQL = """
                    INSERT INTO medico (pessoaCpf, email)
                    VALUES (?, ?)
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, 0);
            stm.setString(2, m.getEmail());
            int i = stm.executeUpdate();
            System.out.println(i);
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
    }

    private void inserirPessoa(Medico m) throws MedicoException {
        try {
            String SQL = """
                    INSERT INTO pessoa (cpf, nome, especialidade, sexo, endereco, telefone, email, setor, crm)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, 0);
            stm.setString(2, m.getNome());
            stm.setString(3, m.getCpf());
            stm.setString(4, m.getSexo());
            stm.setString(5, m.getEndereco());
            stm.setString(6, m.getTelefone());
            stm.setString(7, m.getEmail());
            stm.setString(8, m.getEspecialidade());
            stm.setString(9, m.getSetor());
            stm.setString(10, m.getCrm());
            int i = stm.executeUpdate();
            System.out.println(i);
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
    }

    @Override
    public void atualizar(Medico m) throws MedicoException {
        try {
            atualizarPessoa(m);
            String SQL = """
                    UPDATE medico SET email=?
                    WHERE pessoaCpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, m.getEmail());
            stm.setInt(2, m.getId());
            int i = stm.executeUpdate();
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
    }

    private void atualizarPessoa(Medico m) throws MedicoException {
        try {
            atualizarPessoa(m);
            String SQL = """
                    UPDATE pessoa SET nome=?, sexo=?, endereco=?, telefone=?, email=?, especialidade=?, setor=?, crm=?
                    WHERE cpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, m.getNome());
            stm.setString(2, m.getSexo());
            stm.setString(3, m.getEndereco());
            stm.setString(4, m.getTelefone());
            stm.setString(5, m.getEmail());
            stm.setString(6, m.getEspecialidade());
            stm.setString(7, m.getSetor());
            stm.setString(8, m.getCrm());
            stm.setInt(9, m.getId());
            int i = stm.executeUpdate();
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
    }

    @Override
    public void remover(Medico m) throws MedicoException {
        try {
            String SQL = """
                        DELETE FROM medico WHERE pessoaCpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, m.getId());
            int i = stm.executeUpdate();
            removerPessoa(m);
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
    }

    private void removerPessoa(Medico m) throws MedicoException {
        try {
            String SQL = """
                        DELETE FROM pessoa WHERE cpf=?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setInt(1, m.getId());
            int i = stm.executeUpdate();
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
    }

    @Override
    public List<Medico> pesquisarPorNome(String nome) throws MedicoException {
        List<Medico> lista = new ArrayList<>();
        try {

            String SQL = """
                      SELECT pessoa.cpf, pessoa.nome, pessoa.sexo, pessoa.endereco, pessoa.telefone, pessoa.email, medico.setor, medico.especialidade, medico.crm FROM pessoa
                      INNER JOIN medico ON medico.pessoaCpf = pessoa.cpf
                      WHERE nome LIKE ?
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            stm.setString(1, "%" + nome + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Medico m = new Medico();
                m.setId(rs.getInt("cpf"));
                m.setNome(rs.getString("nome"));
                m.setSexo(rs.getString("sexo"));
                m.setEndereco(rs.getString("endereco"));
                m.setTelefone(rs.getString("telefone"));
                m.setEmail(rs.getString("email"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setSetor(rs.getString("setor"));
                m.setCrm(rs.getString("crm"));
                lista.add(m);
            }
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
        return lista;
    }

    @Override
    public List<Medico> pesquisarTodos() throws MedicoException {
        List<Medico> lista = new ArrayList<>();
        try {
            String SQL = """
                        SELECT pessoa.cpm., pessoa.nome, pessoa.sexo, pessoa.endereco, pessoa.telefone, pessoa.email, medico.setor, medico.especialidade, medico.crm FROM pessoa
                        INNER JOIN medico ON medico.pessoaCpf = pessoa.cpf
                    """;
            PreparedStatement stm = con.prepareStatement(SQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Medico m = new Medico();
                m.setId(rs.getInt("cpf"));
                m.setNome(rs.getString("nome"));
                m.setSexo(rs.getString("sexo"));
                m.setEndereco(rs.getString("endereco"));
                m.setTelefone(rs.getString("telefone"));
                m.setEmail(rs.getString("email"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setSetor(rs.getString("setor"));
                m.setCrm(rs.getString("crm"));
                lista.add(m);
            }
        } catch (SQLException er) {
            er.printStackTrace();
            throw new MedicoException(er);
        }
        return lista;
    }

}