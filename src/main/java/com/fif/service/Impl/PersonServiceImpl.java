package com.fif.service.Impl;

import com.fif.model.Person;
import com.fif.service.PersonService;

import java.util.LinkedList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private List<Person> personList = new LinkedList<Person>();

//    private static int id = 1;

    public PersonServiceImpl() {
        personList.add(
                new Person(
                      "ZK",
                      "Male",
                      "2 October 2000",
                      "fulltime",
                      "Indonesia"
                )
        );
        personList.add(
                new Person(
                        "Luka",
                        "Female",
                        "2 October 2000",
                        "fulltime",
                        "Japan"
                )
        );
    }


    public List<Person> findAll() { return personList; }

    public List<Person> search(String keyword) {
        List<Person> result = new LinkedList<Person>();
        if (keyword==null || equals(keyword)){
            result = personList;
        } else {
            for (Person p: personList) {
                if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    result.add(p);
                } else if (p.getGender().equalsIgnoreCase(keyword)) {
                    result.add(p);
                }
            }
        }
        return result;
    }
}
