package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.MyEntity;
import servlet.LabCRUDInterface;

public class SqlCRUD implements LabCRUDInterface<MyEntity> {

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
	public void create(MyEntity ent) {
		try(
				PreparedStatement st = connection.prepareStatement("INSERT INTO entity.entity (name, description, img) "
						+ "VALUES (?, ?, ?);")){
			st.setString(1, ent.getName());
			st.setString(2, ent.getDescription());
			st.setString(3, ent.getimg());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MyEntity> read() {
		// TODO Auto-generated method stub
		List<MyEntity> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM entity.entity;");) {
			while (rs.next()) {
				list.add(new MyEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(int id, MyEntity t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("UPDATE entity.entity " + "SET \"name\"=?, \"description\"=?, \"img\"=? WHERE id=?;")) {
			st.setString(1, t.getName());
			st.setString(2, t.getDescription());
			st.setString(3, t.getimg());
			st.setInt(4, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection
				.prepareStatement("DELETE FROM entity.entity WHERE id=?;")) {
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}