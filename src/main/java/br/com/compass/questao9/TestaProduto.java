package br.com.compass.questao9;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestaProduto {

	public static void main(String[] args) throws SQLException {

		int opcao;

		try (Scanner op = new Scanner(System.in);) {

			do {
				menu();
				opcao = op.nextInt();
				switch (opcao) {
				case 0:
					System.out.println("SISTEMA ENCERRADO!!!");
					System.exit(0);
					break;

				case 1:
					try (Connection connection = new ConnectionFactory().recuperaConexao()) {
						ProdutoDAO produtoDao = new ProdutoDAO(connection);
						produtoDao.salvar(new Produto(1, "notebook LG", "nao e uma boa ter notebook lg", 50.0, "2022-02-17"));
						produtoDao.salvar(new Produto(2, "notebook gamer asus", "esse notebook até vai", 60.0, "2023-03-18"));
						produtoDao.salvar(new Produto(3, "notebook dell", "esse notebook da dell é o melhor", 0.25, "2024-04-19"));
						connection.close();
						System.out.println("[1] OFERTAS CADASTRADAS COM SUCESSO!");
					}
					break;

				case 2:
					try (Connection connection = new ConnectionFactory().recuperaConexao()) {
						ProdutoDAO produtoDao = new ProdutoDAO(connection);
						produtoDao.alterar("Celular", "notebook i7", 2);
						connection.close();
						System.out.println("[2] OFERTAS ATUALIZADAS COM SUCESSO!");
					}
					break;

				case 3:
					try (Connection connection = new ConnectionFactory().recuperaConexao()) {
						ProdutoDAO produtoDao = new ProdutoDAO(connection);
						produtoDao.deletar(1);
						connection.close();
						System.out.println("[3] OFERTA DELETADA COM SUCESSO!");

					}
					break;

				case 4:
					try (Connection connection = new ConnectionFactory().recuperaConexao()) {
						ProdutoDAO produtoDao = new ProdutoDAO(connection);
						produtoDao.listar();
						connection.close();
						System.out.println("[4] OFERTAS LISTADAS COM SUCESSO!");
					}
					break;
				default:
					System.out.println("Opção invalida! Escolha uma das opções do menu.");

				}
			} while (opcao != 0);
		} catch (NumberFormatException e) {
			System.out.println("erro");
			e.printStackTrace();
		}
	}

	public static void menu() {
		System.out.println("========MENU========\n");
		System.out.println("[1] - INSERIR OFERTA");
		System.out.println("[2] - ATUALIZAR OFERTA");
		System.out.println("[3] - DELETAR OFERTA");
		System.out.println("[4] - LISTAR PRODUTOS");
		System.out.println("[0] - Sair");
		System.out.println("Informe uma opção: ");
	}
}
