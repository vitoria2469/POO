package edu.curso;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AlunoControl {
    
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty ra = new SimpleStringProperty("");
    private IntegerProperty idade = new SimpleIntegerProperty(0);
    
    private List<Aluno> lista = new ArrayList();

    public StringProperty nomeProperty() { 
        return nome;
    }
    
    public StringProperty raProperty() { 
        return ra;
    }
    
    public IntegerProperty idadeProperty() { 
        return idade;
    }
    
    public Aluno paraEntidade() {
    	Aluno a = new Aluno();
    	a.setNome(nome.get());
    	a.setRa(ra.get());
    	a.setIdade(idade.get());
    	return a;
    }
    
    public void paaraTela(Aluno a) {
    	nome.set(a.getNome());
    	ra.set(a.getRa());
    	idade.set(a.getIdade());
    }

    public void salvar() { 
        Aluno a = paraEntidade();
        lista.add(a);
        
    }
    
    public void pesquisar() { 
        for(Aluno a : lista) {
        	if(a.getNome().contains(nome.get())) {
        		break;
        	}
        }
    }
        
}