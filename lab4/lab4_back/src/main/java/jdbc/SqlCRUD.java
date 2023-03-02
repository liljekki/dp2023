package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import servlet.LabCRUDInterface;
import paint.paint;

public class SqlCRUD implements LabCRUDInterface<paint> {

	
	Connection connection;
	
	
	public SqlCRUD() {
		
		this.connection = new Connect().getCon();
		System.out.println(connection);
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(paint t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("INSERT INTO paint (title,price,type) " + "VALUES (?,?,?)")) {
			st.setString(1, t.getTitle());
			st.setFloat(2, t.getPrice());
			st.setString(3, t.getType());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<paint> read() {
		// TODO Auto-generated method stub
		List<paint> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM paint;");) {
			while (rs.next()) {
				list.add(new paint(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(int cat, paint t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("UPDATE paint " + "SET \"title\"=?, \"price\"=?, \"type\"=? WHERE cat=?;")) {
			st.setString(1, t.getTitle());
			st.setFloat(2, t.getPrice());
			st.setString(3, t.getType());
			st.setInt(4, cat);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int cat) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("DELETE FROM paint WHERE cat=?;")) {
			st.setInt(1, cat);			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}