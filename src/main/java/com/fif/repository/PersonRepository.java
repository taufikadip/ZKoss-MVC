package com.fif.repository;

import com.fif.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class PersonRepository {

    private static List<Person> personList = new LinkedList<Person>();

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

        try {
            personList.add(
                    new Person(
                            "1",
                            "ZK",
                            "Male",
                            dateFormat.parse("2 October 2000"),
                            "fulltime",
                            "Indonesia"
                    )
            );
            personList.add(
                    new Person(
                            "2",
                            "Luka",
                            "Female",
                            dateFormat.parse("2 October 2000"),
                            "fulltime",
                            "Japan"
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Person> findAll() {
        return personList;
    }
}
