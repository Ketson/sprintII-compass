package br.com.compass.questao10;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TesteQuestao10 {
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Digite :-) para feliz e :-( para triste:");
		Scanner entrada = new Scanner(System.in);
		String mensagem = entrada.nextLine();
		Pergunta pergunta = new Pergunta(mensagem);

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			PerguntaDAO perguntaDAO = new PerguntaDAO(connection);
			System.out.println(pergunta.getResposta());
			perguntaDAO.salvar(pergunta);
		}
		entrada.close();
	}
}
