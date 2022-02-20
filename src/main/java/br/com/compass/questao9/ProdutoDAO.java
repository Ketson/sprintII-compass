package br.com.compass.questao9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoDAO {
	
	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) {
		try {
			String sql = "INSERT INTO PRODUTO (ID, NOME, DESCRICAO, DESCONTO, DATA_INICIO) VALUES (?, ?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				pstm.setInt(1, produto.getId());
				pstm.setString(2, produto.getNome());
				pstm.setString(3, produto.getDescricao());
				pstm.setDouble(4, produto.getDesconto());
				pstm.setString(5, produto.getData_inicio());
				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	/*
	public static Produto inserirProduto() {
		Scanner entrada = new Scanner(System.in);
		String nome, descricao, data_inicio;
		double desconto;
		int id;
		System.out.println("digite o ID");
		id = Integer.valueOf(entrada.nextLine());
		System.out.println("digite o nome");
		nome = entrada.nextLine();
		System.out.println("digite a descricao");
		descricao = entrada.nextLine();
		System.out.println("digite o desconto");
		desconto = entrada.nextDouble();
		System.out.println("digite a data");
		data_inicio = entrada.nextLine();

		Produto produto = new Produto(id, nome, descricao, desconto, data_inicio);
		return produto;
	}
*/
	

	public void listar() {
		String chave = "";
		Scanner entrada = new Scanner(System.in);
		System.out.println("Bsucar Palavra: ");
		chave = entrada.nextLine();

		List<Produto> produtos = new ArrayList<Produto>();
		try {
			String sql = "SELECT * FROM PRODUTO WHERE DESCRICAO LIKE ?";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, "%" +chave+ "%");
				pstm.execute();
				resultToProduto(produtos, pstm);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		for(Produto p: produtos) {
			System.out.println("[id:"+p.getId() +"],"
					+ " [Nome:"+ p.getNome()+"], [Descricao:"+ p.getDescricao() +
					"], [Desconto:R$"+p.getDesconto()+"], [Data Inicio:"+p.getData_inicio()+"]");
    	}
	}
	
	public void deletar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(String nome, String descricao, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE PRODUTO P SET P.NOME = ?, P.DESCRICAO = ? WHERE ID = ?")) {
			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.setInt(3, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void resultToProduto(List<Produto> produtos, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getFloat(4), rst.getString(5));
				produtos.add(produto);
				
			}
		}
	}
}
