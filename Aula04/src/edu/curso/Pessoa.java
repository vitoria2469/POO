package edu.curso;
import java.time.LocalDate;

public class Pessoa extends Animal{
    String CPF = "";
    String nome = "";
    LocalDate dNasci = LocalDate.now();

    public Pessoa(){
        super();
        System.out.println("Instanciano Pessoa ...");
    }

}
