package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Apps3 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Employee_1 firstEmployee = new Employee_1("Peter", "Holland",
                    "Manager", 120000d);

            Employee_1 secondEmployee = new Employee_1("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee_1 thirdEmployee = new Employee_1("Naomi", "Miller",
                    "Vice President", 160000d);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);


            Employee_1 empOne = entityManager.find(Employee_1.class, 1);

            System.out.println("\n****************************\n");
            System.out.println("Deleting an employee:");

            entityManager.remove(empOne);

            System.out.println("Employee removed...");
            System.out.println("\n****************************\n");

        }
        catch (Exception exception){

            System.err.println("An exception occurred:" + exception);
        }
        finally {

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}
