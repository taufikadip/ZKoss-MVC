package com.fif.service;

import com.fif.model.Person;

import java.util.List;

public interface PersonService {

    public List<Person> findAll();

    public List<Person> search(String keyword);

}
