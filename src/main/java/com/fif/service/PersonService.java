package com.fif.service;

import com.fif.model.Person;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PersonService {

    public List<Person> findAll();

    public List<Person> search(String keyword);

    void delete(String id);

    void addPerson(String id, String name, String gender, Date birthday, String employment, String country);

    Person getById(String id);

    void updatePerson(String id, String name, String gender, Date birthday, String employment, String country);

}
