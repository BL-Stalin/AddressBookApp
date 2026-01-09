package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private final List<AddressBookModel> contacts = new ArrayList<>();
    private int contactId = 1;

    // ---- UC3-POST ----
    public AddressBookModel addContact(AddressBookDTO dto) {
        AddressBookModel model =
                new AddressBookModel(contactId++, dto.getName(), dto.getPhoneNumber(), dto.getCity());
        contacts.add(model);
        return model;
    }

    // ---- UC3-GET-ALL ----
    public List<AddressBookModel> getAllContacts() {
        return contacts;
    }

    // ---- UC3-GET-BY-ID ----
    public AddressBookModel getContactById(int id) {
        return contacts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ---- UC3-PUT ----
    public AddressBookModel updateContact(int id, AddressBookDTO dto) {
        AddressBookModel contact = getContactById(id);
        if (contact != null) {
            contact.setName(dto.getName());
            contact.setPhoneNumber(dto.getPhoneNumber());
            contact.setCity(dto.getCity());
        }
        return contact;
    }

    // ---- UC3-DELETE ----
    public boolean deleteContact(int id) {
        return contacts.removeIf(c -> c.getId() == id);
    }
}
