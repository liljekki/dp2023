package jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entity.MyEntity;
import servlet.Helpers;
import servlet.LabCRUDInterface;

public class SqlCRUD implements LabCRUDInterface<MyEntity> {
	List<MyEntity> list = new ArrayList<>();
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
	public void create(MyEntity element) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try (SessionFactory sessionFactory = new MetadataSources(registry)
				.addAnnotatedClass(MyEntity.class)
				.buildMetadata()
				.buildSessionFactory()) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			int id = Helpers.getNext(list);

			session.save(new MyEntity(
					id,
					element.getName(),
					element.getDescription(),
					element.getimg())
			);

			session.getTransaction().commit();
		}
	}

	@Override
	public List<MyEntity> read() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try (SessionFactory sessionFactory = new MetadataSources(registry)
				.addAnnotatedClass(MyEntity.class)
				.buildMetadata()
				.buildSessionFactory()) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			list = (List<MyEntity>) session.createQuery("from MyEntity").list();

			session.getTransaction().commit();
		}

		return list;
	}

	@Override
	public void update(int id, MyEntity element) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try (SessionFactory sessionFactory = new MetadataSources(registry)
				.addAnnotatedClass(MyEntity.class)
				.buildMetadata()
				.buildSessionFactory()) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			MyEntity updateTent = new MyEntity(
					id,
					element.getName(),
					element.getDescription(),
					element.getimg());

			session.update(updateTent);

			session.getTransaction().commit();
		}
	}


	@Override
	public void delete(int id){
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try (SessionFactory sessionFactory = new MetadataSources(registry)
				.addAnnotatedClass(MyEntity.class)
				.buildMetadata()
				.buildSessionFactory()) {

			Session session = sessionFactory.openSession();
			session.beginTransaction();

			session.delete(session.get(MyEntity.class, id));

			session.getTransaction().commit();
			session.close();
		}
}
}