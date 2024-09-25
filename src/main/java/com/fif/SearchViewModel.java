package com.fif;

import com.fif.model.Person;
import com.fif.service.Impl.PersonServiceImpl;
import com.fif.service.PersonService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.ListModelList;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SearchViewModel extends SelectorComposer<Component> {

    private String keyword;

    private List<Person> personList = new ListModelList<Person>();

    private Person selectedPerson;

    private PersonService personService = new PersonServiceImpl();

    private String id;

    private String name;

    private String gender;

    private Date birthday;

    private String employment;

    private String country;

    public void Person(String id, String name, String gender, Date birthday, String employment, String country) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

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

    @Command
    public void search() {
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.search(keyword));

        UUID.randomUUID().toString();
    }

    @Command
    public void delete() {
        if (selectedPerson == null) {
            throw new RuntimeException("Please select a user before deleting");
        }
        personService.delete(selectedPerson.getId());
        personList.remove(selectedPerson);
        System.out.println("--------------------");
        System.out.println("Id: " + selectedPerson.getId());
        System.out.println("Username: " + selectedPerson.getName());
        System.out.println("Gender: " + selectedPerson.getGender());
        System.out.println("--------------------");
    }

    @Command
    public void addPerson() {
        personService.addPerson(UUID.randomUUID().toString(), this.name, this.gender, this.birthday, this.employment, this.country);
        System.out.println(this.name);
        System.out.println(this.gender);
        System.out.println(this.birthday);
        System.out.println(this.employment);
        System.out.println(this.country);
        Executions.sendRedirect("searchMvvm.zul");
    }

    @Command
    public void update(@BindingParam("id") String id) {
        Executions.sendRedirect("/updateform.zul?id=" + id);
    }

    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getKeyword() { return keyword; }

    public List<Person> getPersonList() { return personList; }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public Person getSelectedPerson() { return selectedPerson; }
}
