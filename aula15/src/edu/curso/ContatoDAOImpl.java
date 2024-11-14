package edu.curso;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ContatoDAOImpl implements ContatoDAO {
    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3307/agendadb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "alunofatec";
    private Connection con = null;
    public ContatoDAOImpl(){
        try{
            Class.forName(DB_CLASS);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void inserir(Contato c){
        try {
            
        } catch (Exception e) {
            
        }
    }



}
