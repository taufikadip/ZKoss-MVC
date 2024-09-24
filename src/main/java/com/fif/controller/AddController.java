package com.fif.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class AddController extends SelectorComposer<Component> {

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

    @Wire
    private Textbox username;

    @Wire
    private Radio gender;

    @Wire
    private Datebox birthday;

    @Wire
    private Combobox employment;

    @Wire
    private Combobox country;

//    private
//
//    @Listen("onClick = #submitButton;")
//    public void add() {
//        nameLabel.setValue(String.valueOf(username));
//        genderLabel.setValue(String.valueOf(gender));
//        birthdayLabel.setValue(String.valueOf(birthday));
//        employmentLabel.setValue(String.valueOf(employment));
//        countryLabel.setValue(String.valueOf(country));
//    }

}
