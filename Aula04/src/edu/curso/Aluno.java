package edu.curso;

public class Aluno extends Pessoa{
    String ra;
//    String nome;
    Carteirinha carteirinha = new Carteirinha();

    public Aluno(String ra, String nome) {
        super();
        System.out.println("Instanciano Aluno ....");
        this.ra = ra;
        this.nome = nome;
    }
}