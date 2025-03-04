package com.agendapp;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;  // Evita problemas en la deserialización
    private String name;
    private int age;
    private String email;
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public Person() {
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}