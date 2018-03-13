package crudhibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("crudHibernate");
		ef.close();
		System.out.println("Finalizado !!!");

	}

}
