package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DConnexion {
private static Connection connection;

	private DConnexion() {	
	};
	
	static {
		try {
			String url = "jdbc:mysql://localhost:3306/getion_hospiliere";
			String name = "root";
			String password = "akabli";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, name, password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
