package ru.alexey4he.lab_5.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SystemName {
    NONESYSTEMNAME(""),
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System");

    private final String name;


    SystemName(String name){
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }

}
