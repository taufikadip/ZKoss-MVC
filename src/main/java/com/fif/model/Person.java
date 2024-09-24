package com.fif.model;

public class Person {

    private String name;

    private String gender;

    private String birthday;

    private String employment;

    private String country;

    public Person(String name, String gender, String birthday, String employment, String country) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.employment = employment;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmployment() {
        return employment;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
