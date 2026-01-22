package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookNotFoundException;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService {

    private List<AddressBookModel> contactList = new ArrayList<>();
    private int contactId = 1;

    // ---- UC3-POST ----
    public AddressBookModel addContact(AddressBookDTO dto) {
        AddressBookModel model =
                new AddressBookModel(contactId++, dto.getName(), dto.getPhoneNumber(), dto.getCity());
        contactList.add(model);
        return model;
    }

    // ---- UC3-GET-ALL ----
    public List<AddressBookModel> getAllContacts() {
        return contactList;
    }

    // ---- UC3-GET-BY-ID ----
    public AddressBookModel getContactById(int id) {
        return contactList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new AddressBookNotFoundException(
                                "AddressBook contact with id " + id + " not found"));
    }

    // ---- UC3-PUT ----
    public AddressBookModel updateContact(int id, AddressBookDTO dto) {
        AddressBookModel contact = getContactById(id);
        contact.setName(dto.getName());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setCity(dto.getCity());
        return contact;
    }

    // ---- UC3-DELETE ----
    public boolean deleteContact(int id) {
        AddressBookModel contact = getContactById(id);
        contactList.remove(contact);
        return true;
    }
}
