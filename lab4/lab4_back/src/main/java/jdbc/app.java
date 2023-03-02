package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.MyEntity;
import servlet.LabCRUDInterface;

public class app {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		LabCRUDInterface crud = new SqlCRUD();
		Connection connection = new Connect().getCon();


		List<MyEntity> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM entity.entity;");) {
			while (rs.next()) {
				list.add(new MyEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(list);

	}

}