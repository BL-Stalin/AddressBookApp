package com.bridgelabz.addressbookapp.model;

public class AddressBookModel {

    private int id;
    private String name;
    private String phoneNumber;
    private String city;

    public AddressBookModel(int id, String name, String phoneNumber, String city) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }
}
