package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App3 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Employee4 firstEmployee = new Employee4("Peter", "Holland",
                    "Manager", 120000d);

            Employee4 secondEmployee = new Employee4("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee4 thirdEmployee = new Employee4("Naomi", "Miller",
                    "Vice President", 160000d);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);

        }catch (Exception exception){

            System.err.println("An exception occurred:" + exception);
        }finally {

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}
