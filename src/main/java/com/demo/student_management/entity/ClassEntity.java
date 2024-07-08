package com.demo.student_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "class")
public class ClassEntity {
    @Id
//    @GeneratedValue dValue(strategy = GenerationType.IDENTITY)
    private int classID;

    @Size(min=2,max=45, message = "firstname from 2 to 45 characters")
    @Column(name = "className")
    private String className;

//    public Set<StudentEntity> getClassList() {
//        return classList;
//    }

//    @ManyToMany
//    @JoinTable(name = "class_info", joinColumns = @JoinColumn(name = "classID"), inverseJoinColumns = @JoinColumn(name = "id"))
//    private Set<StudentEntity> classList;

    public ClassEntity(int classID, String className) {
        this.classID = classID;
        this.className = className;
    }

    public ClassEntity() {

    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public @Size(min = 2, max = 45, message = "firstname from 2 to 45 characters") String getClassName() {
        return className;
    }

    public void setClassName(@Size(min = 2, max = 45, message = "firstname from 2 to 45 characters") String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "classID=" + classID +
                ", className='" + className + '\'' +
                '}';
    }
}
