package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App1 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee1 firstEmployee = new Employee1(1115, "Nomi", "Miller",
                "Vice President", 160000);

        Employee1 secondEmployee = new Employee1(1147,"Raj", "Chawanda",
                "Associate", 90000);

        entityManager.persist(firstEmployee);
        entityManager.persist(secondEmployee);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }
}