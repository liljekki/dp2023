package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	private String url = "jdbc:postgresql://localhost:5432/dp2023newlab";
	private Connection conn;

	public Connect() {

		try {
			this.conn = DriverManager.getConnection(url,"sample", "111");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Connection getCon() {
		return conn;
	}

	public void setCon(Connection conn) {
		this.conn = conn;
	}
	
	public void closeCon() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}