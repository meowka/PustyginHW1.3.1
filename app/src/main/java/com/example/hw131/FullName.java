package com.example.hw131;

import java.io.Serializable;

public class FullName implements Serializable {

    String name;
    String surname;
    String middleName;
    String age;

    public FullName(String name, String surname, String middleName, String age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
