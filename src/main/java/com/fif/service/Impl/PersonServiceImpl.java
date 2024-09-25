package com.fif.service.Impl;

import com.fif.model.Person;
import com.fif.repository.PersonRepository;
import com.fif.service.PersonService;
import org.zkoss.bind.BindUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class PersonServiceImpl implements PersonService {

    private PersonRepository repository = new PersonRepository();

    private List<Person> personList;

//    private static int id = 1;

    public PersonServiceImpl() {
        personList = repository.findAll();
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

    @Override
    public void delete(String id) {
        Person personToRemove = null;

        // Mencari person berdasarkan id
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                personToRemove = person;
                break;
            }
        }

        // Jika person ditemukan, hapus dari daftar
        if (personToRemove != null) {
            personList.remove(personToRemove);
        }
    }

    @Override
    public void addPerson(String id, String name, String gender, Date birthday, String employment, String country) {
        personList.add(new Person(id, name, gender, birthday, employment, country));
    }

    @Override
    public Person getById(String id) {
        // Mencari person berdasarkan id
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void updatePerson(String id, String name, String gender, Date birthday, String employment, String country) {
        Person personToUpdate = getById(id);
        if (personToUpdate != null) {
            delete(id);
            addPerson(id, name, gender, birthday, employment, country);
        }
    }
}
