package edu.curso;

public class Carro {
    String marca = "";
    String modelo = "";
    private Motor motor;
    int ano;
    Pneu p1;
    Pneu p2;
    Pneu p3;
    Pneu p4;
    Pneu p5;

    public Carro(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        motor = new Motor(marca);
        Pneu p1 = new Pneu(14, "Pirelli");
        Pneu p2 = new Pneu(14, "Pirelli");
        Pneu p3 = new Pneu(14, "Pirelli");
        Pneu p4 = new Pneu(14, "Pirelli");
        Pneu p5 = new Pneu(14, "Pirelli");

    }
}