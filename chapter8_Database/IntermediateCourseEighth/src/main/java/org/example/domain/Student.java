package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String telephone;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Indeks indeks;

    @ManyToOne
    private University university;

    @ManyToMany
    private Set<Classes> classes;

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String indexNumber) {
        this.name = name;
        this.indeks = new Indeks(indexNumber);
        this.classes = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", indeks=" + indeks +
                '}';
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setIndeks(Indeks idx) {
        this.indeks = idx;
    }

    public Indeks getIndeks() {
        return indeks;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void addClasses(Classes classes){
        this.classes.add(classes);
    }
}
