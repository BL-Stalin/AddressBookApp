package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private List<AddressBookModel> contacts = new ArrayList<>();
    private int contactId = 1;

    // ---- UC2-POST ----
    public AddressBookModel addContact(AddressBookDTO dto) {
        AddressBookModel model =
                new AddressBookModel(contactId++, dto.getName(), dto.getPhoneNumber(), dto.getCity());
        contacts.add(model);
        return model;
    }

    // ---- UC2-GET-ALL ----
    public List<AddressBookModel> getAllContacts() {
        return contacts;
    }

    // ---- UC2-GET-BY-ID ----
    public AddressBookModel getContactById(int id) {
        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ---- UC2-PUT ----
    public AddressBookModel updateContact(int id, AddressBookDTO dto) {
        AddressBookModel contact = getContactById(id);
        if (contact != null) {
            contacts.remove(contact);
            AddressBookModel updated =
                    new AddressBookModel(id, dto.getName(), dto.getPhoneNumber(), dto.getCity());
            contacts.add(updated);
            return updated;
        }
        return null;
    }

    // ---- UC2-DELETE ----
    public boolean deleteContact(int id) {
        return contacts.removeIf(contact -> contact.getId() == id);
    }
}
