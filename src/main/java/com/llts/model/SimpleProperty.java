package com.llts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimpleProperty {

    @Id
    @Column(name="id")
    private int key;

    private String value;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "SimpleProperty [key=" + key + ", value=" + value + "]";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}