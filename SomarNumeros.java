package edu.curso;
import java.util.Scanner;

public class SomarNumeros {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Por Favor digite um numero: ");
		double num1 = input.nextDouble();
		System.out.println("Por Favor digite outro numero: ");
		double num2 = input.nextDouble();
		double resultado = num1 + num2;
		System.out.printf("Resultado: %6.2f", resultado);
		input.close();
	}

}