package org.example;

import org.example.domain.Student;
import org.example.domain.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPAApp {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ClockworkPersistence");

    static EntityManager entityManager = factory.createEntityManager();

    public static void main(String[] args) {

        entityManager.getTransaction().begin();

        Student pawel = entityManager.merge(new Student("Pawel", "123456"));

        Student merge = entityManager.merge(pawel);

        entityManager.getTransaction().commit();

        System.out.println(pawel);
        System.out.println(pawel.getIndeks());

        entityManager.getTransaction().begin();

        University umk = entityManager.merge(new University("UMK"));

        umk.addStudent(pawel);

        entityManager.getTransaction().commit();


    }

    private static void deleteStudent() {

        Student student = entityManager.find(Student.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();

    }

    private static void updateStudent() {

        Student kinga = new Student("Kinga");

        entityManager.getTransaction().begin();
        Student student = entityManager.merge(kinga);

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

        Student pawel = new Student("Pawel");

        entityManager.getTransaction().begin();
        entityManager.persist(pawel);
        entityManager.getTransaction().commit();

    }


}
