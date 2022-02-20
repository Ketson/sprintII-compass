package br.com.compass.questao10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PerguntaDAO {
	private Connection connection;

	public PerguntaDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public void salvar(Pergunta pergunta) throws SQLException {
		String sql = "INSERT INTO questao10 (pergunta, resposta) VALUES (?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, pergunta.getPergunta());
			pstm.setString(2, pergunta.getResposta());
			pstm.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}
