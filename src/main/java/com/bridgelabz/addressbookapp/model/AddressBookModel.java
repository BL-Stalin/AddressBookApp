package com.bridgelabz.addressbookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressBookModel {
    private int id;
    private String name;
    private String phoneNumber;
    private String city;
}
