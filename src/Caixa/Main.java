package Caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Date;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		CriaConexao criaConexao = new CriaConexao();
		Connection connection = criaConexao.Conexao();

		Menu menu = new Menu();
		Produtos prod = new Produtos();

		int opcao;
		int lastid = criaConexao.getLastId();

		try (Scanner scanner = new Scanner(System.in)) {
			do {
				opcao = menu.menu(scanner);
				switch (opcao) {

				case 1:

					for (int i = 0; i < 3; i++) {

						System.out.println("Você escolheu 1");

						PreparedStatement stm = connection.prepareStatement(
								"INSERT INTO PRODUTO (nome, descricao, desconto, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
						try {
							stm.setString(1, prod.setNome());
							stm.setString(2, prod.setDescricao());
							stm.setFloat(3, prod.setDesconto());
							stm.setDate(4, prod.setDatai());
							stm.setDate(5, prod.setDataf());
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

						stm.execute();

						ResultSet rst = stm.getGeneratedKeys();

						try {
							while (rst.next()) {
								Integer id = rst.getInt(1);
								System.out.println("O id criado foi: " + id);
								lastid = criaConexao.getLastId();
								System.out.println(lastid);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}

					break;
				case 2:

					System.out.println("Você escolheu 2");

					lastid = lastid - 2;

					PreparedStatement stm = connection.prepareStatement(
							"UPDATE PRODUTO  SET nome=?, descricao=?, desconto=?, data_inicio=?, data_fim=? WHERE id = (?)");

					try {
						stm.setString(1, prod.setNome());
						stm.setString(2, prod.setDescricao());
						stm.setFloat(3, prod.setDesconto());
						stm.setDate(4, prod.setDatai());
						stm.setDate(5, prod.setDataf());
						stm.setInt(6, lastid);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

					stm.executeUpdate();

					break;
				case 3:

					System.out.println("Você escolheu 3");

					lastid = criaConexao.getLastId();

					lastid = lastid - 1;

					stm = connection.prepareStatement("DELETE from PRODUTO WHERE id = (?)");

					stm.setInt(1, lastid);

					stm.execute();

					System.out.println("Você deletou o id: " + lastid);

					break;

				case 4:

					System.out.println("\nVocê escolheu 4");
					System.out.println("Digite o id máximo");
					int idmax = scanner.nextInt();
					System.out.println("Digite o id mínimo");
					int idmin = scanner.nextInt();
					lastid = criaConexao.getLastId();
					try {
						if (idmax < lastid && idmin > 0) {

							stm = connection.prepareStatement(
									"SELECT id, nome, descricao, desconto, data_inicio, data_fim FROM PRODUTO WHERE id >= (?) AND id <= (?)");

							stm.setInt(1, idmin);
							stm.setInt(2, idmax);

							stm.execute();

							ResultSet rst = stm.getResultSet();

							while (rst.next()) {

								Integer id = rst.getInt("id");
								System.out.println(id);
								String nome = rst.getString("nome");
								System.out.println(nome);
								String descricao = rst.getString("descricao");
								System.out.println(descricao);
								Float desconto = rst.getFloat("desconto");
								System.out.println(desconto);
								Date data_inicio = rst.getDate("data_inicio");
								System.out.println(data_inicio);
								Date data_fim = rst.getDate("data_fim");
								System.out.println(data_fim);

							}
						}
					} catch (Exception e) {
						System.out.println("valor inválido");
					}

					break;

				case 5:

					for (int i = 0; i < 3; i++) {
						stm = connection.prepareStatement(
								"INSERT INTO PRODUTO (nome, descricao, desconto, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);

						stm.setString(1, "MESA");
						stm.setString(2, "REDONDA");
						stm.setFloat(3, 350);
						stm.setString(4, "2022-10-11");
						stm.setString(5, "2022-10-12");

						stm.execute();

					}
					System.out.println("Feito");
					break;
				case 6:

					for (int i = 0; i < 20; i++) {
						stm = connection.prepareStatement(
								"INSERT INTO PRODUTO (nome, descricao, desconto, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);

						stm.setString(1, "Teste Cadeira" + (i));
						stm.setString(2, "Cadeira");
						stm.setFloat(3, 450);
						stm.setString(4, "2022-10-11");
						stm.setString(5, "2022-10-12");

						stm.execute();

					}
					System.out.println("Feito");
					break;

				case 0:
					System.out.println("Você escolheu 0");
					System.out.println("Programa finalizado");
					connection.close();

					break;
				default:
					System.out.println("Opção errada");
					connection.close();

					System.out.println("Programa finalizado");
					break;
				}
			} while (opcao != 0 && opcao < 6 && opcao > 0);
		} catch (Exception e) {
			System.out.println("Inválido");;
		}
		prod.fecharscan();
	}

}