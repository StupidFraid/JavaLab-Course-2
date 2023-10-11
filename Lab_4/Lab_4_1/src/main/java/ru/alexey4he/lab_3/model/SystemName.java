package ru.alexey4he.lab_3.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SystemName {
    USERREQUEST(""),
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    SERVICE1("First Service");

    private final String name;


    SystemName(String name){
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }

}
