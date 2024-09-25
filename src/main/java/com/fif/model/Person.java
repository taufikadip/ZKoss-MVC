package com.fif.model;

import java.util.Date;

public class Person {

    private String id;

    private String name;

    private String gender;

    private Date birthday;

    private String employment;

    private String country;

    public Person(String id, String name, String gender, Date birthday, String employment, String country) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;  // Pastikan tipe birthday adalah Date
        this.employment = employment;
        this.country = country;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() { return birthday; }

    public String getEmployment() {
        return employment;
    }

    public String getCountry() {
        return country;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
