package com.fif.controller;

import com.fif.model.Person;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import com.fif.service.PersonService;
import com.fif.service.Impl.PersonServiceImpl;

import java.util.Set;

public class SearchController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;

    @Wire
    private Textbox keywordbox;

    @Wire
    private Listbox personListbox;

    @Wire
    private Label nameLabel;

    @Wire
    private Label genderLabel;

    @Wire
    private Label birthdayLabel;

    @Wire
    private Label employmentLabel;

    @Wire
    private Label countryLabel;

    private ListModelList<Person> dataModel = new ListModelList<>();

    private PersonService personService = new PersonServiceImpl();

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        personListbox.setModel(dataModel);
    }

    @Listen("onClick = #searchButton; onOK = window")
    public void search() {
        String keyword = keywordbox.getValue();
        dataModel.clear();
        dataModel.addAll(personService.search(keyword));
    }

    @Listen("onSelect = #personListbox")
    public void showDetail() {
        Set<Person> selection = dataModel.getSelection();
        Person selected = selection.iterator().next();
        nameLabel.setValue(selected.getName());
        genderLabel.setValue(selected.getGender());
//        birthdayLabel.setValue(dateUtils.convertToLocalDateViaInstant(selected.getBirthday()));
        employmentLabel.setValue(selected.getEmployment());
        countryLabel.setValue(selected.getCountry());
    }
}
