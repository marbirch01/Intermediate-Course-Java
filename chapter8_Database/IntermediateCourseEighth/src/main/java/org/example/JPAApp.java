package org.example;

import org.example.domain.Student;
import org.example.domain.University;
import org.example.domain.Indeks;
import org.example.domain.Professor;
import org.example.domain.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPAApp {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClockworkPersistence");

    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {

        entityManager.getTransaction().begin();

        Student marcin = entityManager.merge(new Student("Marcin", "408932"));

        University agh = entityManager.merge(new University("AGH"));
        marcin.setUniversity(agh);
        agh.addStudent(marcin);

        entityManager.merge(marcin);
        entityManager.merge(agh);

        entityManager.getTransaction().commit();

        University university = entityManager.find(University.class, agh.getId());
        System.out.println(university);

//        Student merge = entityManager.merge(marcin);
//
//        entityManager.getTransaction().commit();
//
//        System.out.println(marcin);
//        System.out.println(marcin.getIndeks());
//
//        entityManager.getTransaction().begin();
//
//        University agh = entityManager.merge(new University("AGH"));
//
//        agh.addStudent(marcin);




    }

    private static void deleteStudent() {

        Student student = entityManager.find(Student.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();

    }

    private static void updateStudent() {

        Student kasia = new Student("Kasia");

        entityManager.getTransaction().begin();
        Student student = entityManager.merge(kasia);

        student.setTelephone("1234567");

        entityManager.merge(student);

        entityManager.getTransaction().commit();

    }

    private static void readStudents() {

        Student student = entityManager.find(Student.class, 0);

        System.out.println(student);

        List fromStudent = entityManager.createQuery("from Student").getResultList();

        fromStudent.forEach(System.out::println);

    }

    private static void createStudent() {

        Student marcin = new Student("Marcin");

        entityManager.getTransaction().begin();
        entityManager.persist(marcin);
        entityManager.getTransaction().commit();

    }


}
