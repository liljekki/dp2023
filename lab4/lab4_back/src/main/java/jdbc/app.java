package jdbc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
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

		List<MyEntity> entities;
		List<MyEntity> list = new ArrayList<>();


//JDBC connection
		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM entity.entity;");) {
			while (rs.next()) {
				list.add(new MyEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("JDBC");
		for (MyEntity entity : list) {
			System.out.println(entity);
		}


//JPA connection
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try (SessionFactory sessionFactory = new MetadataSources(registry)
				.addAnnotatedClass(MyEntity.class)
				.buildMetadata()
				.buildSessionFactory()) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

            /*session.save(new MyEntity(3, "name3", "gg", "img_new"));
            session.save(new MyEntity(2, "name2", "5","1"));

            MyEntity updateEntity1 = new MyEntity(1, "updated_name_1", "update", "gg");
            session.update(updateEntity1);
            session.delete(new MyEntity(2, "name2", "5","1"));*/

			entities = (List<MyEntity>) session.createQuery("from MyEntity").list();

			session.getTransaction().commit();

		}

		System.out.println("JPA");
		for (MyEntity entity : entities) {
			System.out.println(entity);
		}
		System.out.println("Success!");
	}
}