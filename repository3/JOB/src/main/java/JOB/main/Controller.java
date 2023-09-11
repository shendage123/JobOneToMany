package JOB.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import JOB.dto.Employess;
import JOB.dto.Jobd;

public class Controller {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Employess e1 = new Employess();
		Employess e2 = new Employess();
		Employess e3 = new Employess();
		List<Employess> employesses = new ArrayList<Employess>();
		employesses.add(e1);
		employesses.add(e2);
		employesses.add(e3);

		Jobd jobd = new Jobd();
		jobd.setEmployesses(employesses);

		System.out.println("1.Add EmpData \n2.Find\n3.Delete\n4.Update");

		switch (sc.nextInt()) {
		case 1:
			System.out.println("Enter The Name");
			e1.setJobname(sc.next());
			System.out.println("Enter The Salary");
			e1.setSal(sc.nextDouble());
			System.out.println("Enter Contact");
			e1.setNumber(sc.nextLong());
			
			System.out.println(">>>>Next Employess");
			System.out.println("Enter The Name");
			e2.setJobname(sc.next());
			System.out.println("Enter The Salary");
			e2.setSal(sc.nextDouble());
			System.out.println("Enter Contact");
			e2.setNumber(sc.nextLong());
			
			System.out.println(">>>>>Next Employess");
			System.out.println("Enter The Name");
			e3.setJobname(sc.next());
			System.out.println("Enter The Salary");
			e3.setSal(sc.nextDouble());
			System.out.println("Enter Contact");
			e3.setNumber(sc.nextLong());

			System.out.println("Deparment");
			System.out.println("Enter The JOb");
			jobd.setJob(sc.next());
			System.out.println("Enter Address");
			jobd.setAddress(sc.next());

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("root");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.persist(e1);
			entityManager.persist(e2);
			entityManager.persist(e3);
			entityManager.persist(jobd);
			entityTransaction.commit();

			break;
		case 2:
			System.out.println("Enter The Id");
			Find(sc.nextInt());
			break;

		case 3:
			System.out.println("Enter The Id");
			delete(sc.nextInt());
			break;
			
		case 4:
			System.out.println("Enter The JOb");
			jobd.setJob(sc.next());
			System.out.println("Enter Address");
			jobd.setAddress(sc.next());
			Update(jobd, 1);

		default:
			break;
		}

	}

	public static void delete(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("root");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employess employess = entityManager.find(Employess.class, id);
		Jobd jobd = entityManager.find(Jobd.class, id);
		entityTransaction.begin();
		entityManager.remove(employess);
		entityManager.remove(jobd);
		entityTransaction.commit();
		System.out.println("Remove Employess");
	}
	
	public static void Find(int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("root");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employess employess = entityManager.find(Employess.class, id);
		Jobd jobd = entityManager.find(Jobd.class, id);
		System.out.println(employess);
		System.out.println(jobd);

	}
	
	public static void Update(Jobd jobd,int id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("root");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Jobd jobd1 = entityManager.find(Jobd.class, id);
		if(jobd1!=null)
		{
			jobd.setId(id);
			jobd.setEmployesses(jobd1.getEmployesses());
			entityTransaction.begin();
			entityManager.merge(jobd);
			entityTransaction.commit();
			
			System.out.println("Succefully Updated");
		}
		else
		{
			System.out.println("Id Not Found");
		}
	}

}
