package Caixa;

import java.text.ParseException;
import java.sql.Date;
import java.util.Scanner;

public class Produtos {


	private Date Datai;
	private Date Dataf;
	private String data;

	Scanner sc = new Scanner(System.in);


	public float setDesconto() {
		System.out.println("Digite o desconto que quer cadastrar");
		float desconto = sc.nextFloat();
		return desconto;
	}

	public String setDescricao() {
		System.out.println("Digite a descricao desejada do produto");
		String descricao = "";

		if (sc.hasNextLine()) {
			descricao = sc.nextLine();
		}
		return descricao;
	}

	public String setNome(){
		System.out.println("Digite o nome do produto");
		String nome = sc.nextLine();
		return nome;
	}

	public java.sql.Date setDatai() throws ParseException {
		System.out.println("Digite a data de entrada\n O padrão de data deve ser (YYYY-MM-DD) Separados por -");
		data = sc.next();
		Date date = Date.valueOf(data);
		Datai = date;
		return Datai;
	}

	public java.sql.Date setDataf() throws ParseException {
		System.out.println("Digite a data de saida\n O padrão de data deve ser (YYYY-MM-DD) Separados por -");
		data = sc.next();
		Date date = Date.valueOf(data);
		Dataf = date;
		return Dataf;
	}

	public void fecharscan() {
		sc.close();
	}

}
