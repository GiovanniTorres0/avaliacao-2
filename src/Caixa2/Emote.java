package Caixa2;

import java.util.Scanner;

public class Emote {

	public static void main(String[] args) {

		int contadorD=0;
		int contadorC=0;

		String s;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a frase: ");
		
		
		s=sc.nextLine();
		
		s = s.replaceAll(" ", "");
				
		for (int i = 0; i < s.length();) {
			
			
		if (s.contains("=-)") || s.contains("=-(")) {	
			if (s.contains(")")) {
				contadorD++;
			}  if (s.contains("(")) {
				contadorC++;
			} 
			
			i++;
		} else {
			System.out.println("Inv�lido");
			break;
		}
		}

		sc.close();
		
		if (contadorD > contadorC) {
			System.out.println("Divertido");
		} else if (contadorC > contadorD) {
			System.out.println("Chateado");
		} else if (contadorD == contadorC) {
			System.out.println("Neutro");
		} else {
			System.out.println("inv�lido");
		}

		

	}

}
