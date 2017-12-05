package com.suchen.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {

	SessionFactory sessionFactory;

	public void setup() {
		// code to load the hibernate session factory

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	public void exit() {
		// code to close the Hibernate session factory
		sessionFactory.close();

	}

	public void create(String title, String author, float price) {
		// code to save the book
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(price);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();

	}

	public void read(long bookId) {
		// code to read the book
		Session session = sessionFactory.openSession();

		Book book = session.get(Book.class, bookId);

		System.out.println("Title: " + book.getTitle());
		System.out.println("Author: " + book.getAuthor());
		System.out.println("Price: " + book.getPrice());

		session.close();

	}

	public void update(long id, String title, String author, float price) {
		// code to update the book details
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPrice(price);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.update(book);

		session.getTransaction().commit();
		session.close();

	}

	public void delete(long bookId) {
		// code to delete the book details
		Book book = new Book();
		book.setId(bookId);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.delete(book);

		session.getTransaction().commit();
		session.close();

	}

	public static void main(String[] args) {
		// main code to run
		BookManager manager = new BookManager();
		manager.setup();

		// manager.create("My Life","Suchen",100f);
		// manager.read(6);
		// manager.update(6, "Title6", "Suchen", 100f);
		manager.delete(6);

		manager.exit();

	}

}
