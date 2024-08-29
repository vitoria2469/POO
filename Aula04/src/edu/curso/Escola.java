package edu.curso;

public class Escola {
    public void main (String args[]){

        Aluno a1 = new Aluno("001", "Maria Silva");
//       Aluno a2 = new Aluno("002", "Thiago Santos");


        Carteirinha c1 = new Carteirinha();
        a1.carteirinha = c1;
    }
}