package com.skillsoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Apps4 {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            EmployeeContactInfo eciOne = new EmployeeContactInfo("101 Main St", "555-101");
            EmployeeContactInfo eciTwo = new EmployeeContactInfo("51 Broadway", "555-155");
            EmployeeContactInfo eciThree = new EmployeeContactInfo("24 Walnut St", "555-222");

            Employees firstEmployee = new Employees("Peter", "Holland",
                    "Manager", 120000d);

            Employees secondEmployee = new Employees("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employees thirdEmployee = new Employees("Naomi", "Miller",
                    "Vice President", 160000d);

            firstEmployee.setContactInfo(eciOne);
            secondEmployee.setContactInfo(eciTwo);
            thirdEmployee.setContactInfo(eciThree);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);

            entityManager.persist(eciOne);
            entityManager.persist(eciTwo);
            entityManager.persist(eciThree);


            List<Employees> employeeList = entityManager
                    .createQuery("SELECT ed FROM Employees ed")
                    .getResultList();

            System.out.println("\n****************************\n");
            System.out.println("The employees in the Employee table:");
            for(Employees emp: employeeList){
                System.out.println(emp);
            }

            System.out.println("\n****************************\n");

            List<EmployeeContactInfo> contactInfos = entityManager
                    .createQuery("SELECT eci FROM EmployeeContactInfo eci")
                    .getResultList();

            System.out.println("\nThe contact details for employees:\n");
            for(EmployeeContactInfo eci: contactInfos){
                System.out.println(eci);
            }

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
