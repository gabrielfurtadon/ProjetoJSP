package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.loginBean;
import connection.SingleConnectionBanco;

public class DAOLoginRepository {

	private Connection connection;
	
	public DAOLoginRepository() {
		connection = SingleConnectionBanco.getConn();
	}
	
	public boolean validarAutenticacao(loginBean loginbean) throws Exception{
		
		String sql = "select * from login_bean where login = ? and senha = ?";
		
		PreparedStatement std = connection.prepareStatement(sql);
		
		std.setString(1, loginbean.getLogin());
		std.setString(2, loginbean.getSenha());
		
		ResultSet rs = std.executeQuery();
		
		if(rs.next()) {  // SE TIVER COM USUARIO COM LOGIN E SENHA AUTENTICA 
			return true;
		}
		
		return false; //SENAO NAO AUTENTICA
		
		
	}
	
}
