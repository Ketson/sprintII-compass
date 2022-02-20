package br.com.compass.questao9;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
public DataSource dataSource;
	
	public ConnectionFactory() {
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/questao09?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("");
		comboPooledDataSource.setMaxPoolSize(15);
		this.dataSource =  comboPooledDataSource;
	}
	
	public Connection recuperaConexao() throws SQLException {
		
		return this.dataSource.getConnection();
	}

}
