package com.codegym.model;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sex;
    private Double score;
    @ManyToOne
    private ClassRoom classRoom;

    public Student(Long id, String name, String sex, Double score, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.score = score;
        this.classRoom = classRoom;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
