package edu.curso;

public class Mecanica {
    public static void main(String[] args){
        Carro c1 = new Carro("Hyundai", "HB20", 2019);
        Carro c2 = new Carro("Fiat", "HB18", 2014);
        Carro c3 = new Carro("Mercedes", "HB30", 2017);

        Pneu pextra = new Pneu(18, "Goodyear");
        c1 = null;
        c2.p1 = pextra;
    }
 
// Crie uma classe chamada Pneu
// contendo os seguintes atributos
// aro : int
// marca : String
// Faça um construtor para que ao ser criado
// o Pneu seja obrigatorio informar o aro e a marca

// Crie uma classe chamada Carro
// contendo os seguintes atributos
// marca : String
// modelo : String
// ano : int
// p1, p2, p3, p4, p5 : Pneu
// (Devem ser instanciados no construtor
// com aro 14 e marca Pirelli)


}