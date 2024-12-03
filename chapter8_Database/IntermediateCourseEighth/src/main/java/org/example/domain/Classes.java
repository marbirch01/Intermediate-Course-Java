package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "classes")
    Set<Student> students;

    public Classes(String name) {
        students = new HashSet<>();
        this.name = name;
    }

    public Classes(){}

    public void addStudent(Student student) {
        students.add(student);
    }
}
