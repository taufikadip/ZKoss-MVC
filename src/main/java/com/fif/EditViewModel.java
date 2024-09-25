package com.fif;

import com.fif.model.Person;
import com.fif.service.Impl.PersonServiceImpl;
import com.fif.service.PersonService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;

import java.text.ParseException;
import java.util.Date;

public class EditViewModel extends SelectorComposer<Component> {
    private String id = "";
    private String name;
    private String gender;
    private Date birthday;
    private String employment;
    private String country;

    PersonService personService = new PersonServiceImpl();

    @Init
    public void init() {
        this.id = Executions.getCurrent().getParameter("id");
        if (this.id == null || this.id.isEmpty()) {
            Executions.sendRedirect("helloworld.zul");
            return;
        }
        Person selectedPerson = personService.getById(id);
        if (selectedPerson == null)
            throw new RuntimeException("Please go through from Table");

        this.setName(selectedPerson.getName());
        this.setGender(selectedPerson.getGender());
        this.setBirthday(selectedPerson.getBirthday());
        this.setEmployment(selectedPerson.getEmployment());
        this.setCountry(selectedPerson.getCountry());
    }

    @Command
    public void updatePerson() {
            personService.updatePerson(this.id, this.name, this.gender, this.birthday, this.employment, this.country);
            Executions.sendRedirect("searchMvvm.zul");
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
}
