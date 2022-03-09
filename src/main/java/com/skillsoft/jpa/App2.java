package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App2 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Employee3 firstEmployee = new Employee3(1121, "Peter", "Holland",
                    "Manager", 120000d);

            Employee3 secondEmployee = new Employee3(1141,"Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee3 thirdEmployee = new Employee3();
            thirdEmployee.setId(1115);

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
