package com.demo.student_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "class_info")
public class ClassInfoEntity {
    @Id
    private int infoID;

    private int classID;
    private int id;

    public ClassInfoEntity(int infoID, int classID, int id) {
        this.infoID = infoID;
        this.classID = classID;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClassInfoEntity{" +
                "infoID=" + infoID +
                ", classID=" + classID +
                ", id=" + id +
                '}';
    }

    public ClassInfoEntity() {
    }

    public int getInfoID() {
        return infoID;
    }

    public void setInfoID(int infoID) {
        this.infoID = infoID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
