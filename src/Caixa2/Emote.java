package Caixa2;

import java.util.Scanner;

public class Emote {

	public static void main(String[] args) {

		int contadorD = 0;
		int contadorC = 0;
		int sorriso=0;
		int tristeza=0;
		int nariz=0;
		int olho=0;

		String s;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite a frase: ");

		s = sc.nextLine();

		s = s.replaceAll(" ", "");

		try {
			for (int i = 0; i < s.length();) {

				if (s.contains("=-)") || s.contains("=-(")) {

					for (int j = 0; j < s.length(); j++) {
						if (s.contains(")")) {
							sorriso += 1;
						}
						if (s.contains("(")) {
							tristeza += 1;
						}
						if (s.contains("-")) {
							nariz += 1;
						}
						if (s.contains("=")) {
							olho += 1;
						}

						try {
							contadorD = (sorriso + nariz + olho) / 3;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

						try {
							contadorC = (tristeza + nariz + olho) / 3;
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
					i++;
				} else {
					System.out.println("Inválido");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		sc.close();
 try {
		if (contadorD > contadorC) {
			System.out.println("Divertido");
		} if (contadorC > contadorD) {
			System.out.println("Chateado");
		} if (contadorD == contadorC) {
			System.out.println("Neutro");
		}
		} catch (Exception e) {
			System.out.println("Teste");
		}

	}

}
