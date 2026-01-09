package com.bridgelabz.addressbookapp.dto;

public class AddressBookDTO {

    private String name;
    private String phoneNumber;
    private String city;

    public AddressBookDTO() {}

    public AddressBookDTO(String name, String phoneNumber, String city) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
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
