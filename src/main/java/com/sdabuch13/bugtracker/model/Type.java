package com.sdabuch13.bugtracker.model;

import javax.persistence.*;

@Entity
@Table(name = "type")
public class Type {
    public Type() {
    }

    public Type(int typeId) {
        this.typeId = typeId;
    }

    public Type(String typeName) {
        this.typeName = typeName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeId")
    public int typeId;

    @Column(name = "typeName")
    public String typeName;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
