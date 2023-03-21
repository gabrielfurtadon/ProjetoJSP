package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {

	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true"; // autoReconnect=true = caso o banco caia ele consegue fazer a reconexão
	private static String user = "postgres";
	private static String senha = "admin";
	private static Connection conn = null;
	
	public static Connection getConn() {
		return conn;
	}
	
	static {
		conectar();
	}
	
	public SingleConnectionBanco() {
		conectar();
	}
	
	private static void conectar() { //QUANDO TIVER UMA INSTANCIA, VAI CONECTAR
		try {
			
			if(conn == null) {
				Class.forName("org.postgresql.Driver"); //CARREGA O DRIVER DE CONEZAO COM O BANCO
				conn = DriverManager.getConnection(banco, user, senha);
				conn.setAutoCommit(false); //PARA NAO EFETUAR ALTERAÇÕES NO BANCO SEM O NOSSO COMANDO
			}
			
		}catch (Exception e) {
			e.printStackTrace(); // mostra qualquer errro que ocorra com a conexão
		}
	}
	
}
