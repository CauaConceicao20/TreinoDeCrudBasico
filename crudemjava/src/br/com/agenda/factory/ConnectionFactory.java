package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "********";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	public static Connection creatConnectionToMysql() throws Exception {
		//Criando a conexão com banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = creatConnectionToMysql();
		//Testa a conexão para saber se esta funcionando corretamente
		if(con!=null) {
			System.out.println("Conexão  obedtida com sucesso");
			con.close();
		}else {
			System.out.println("Erro ao estabelecer conexão");
			con.close();
		}
	}
}
