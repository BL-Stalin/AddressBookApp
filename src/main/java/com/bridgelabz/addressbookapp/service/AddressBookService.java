package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
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

    // ---- UC2-POST ----
    public AddressBookModel addContact(AddressBookDTO dto) {
        log.debug("Service: Adding contact {}", dto);
        AddressBookModel model =
                new AddressBookModel(contactId++, dto.getName(), dto.getPhoneNumber(), dto.getCity());
        contactList.add(model);
        log.debug("Service: Contact added successfully {}", model);
        return model;
    }

    // ---- UC2-GET-ALL ----
    public List<AddressBookModel> getAllContacts() {
        log.debug("Service: Fetching all contacts");
        return contactList;
    }

    // ---- UC2-GET-BY-ID ----
    public AddressBookModel getContactById(int id) {
        log.debug("Service: Fetching contact with id {}", id);
        return contactList.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ---- UC2-PUT ----
    public AddressBookModel updateContact(int id, AddressBookDTO dto) {
        log.debug("Service: Updating contact with id {}", id);
        AddressBookModel contact = getContactById(id);
        if (contact != null) {
            contact.setName(dto.getName());
            contact.setPhoneNumber(dto.getPhoneNumber());
            contact.setCity(dto.getCity());
            log.debug("Service: Contact updated successfully {}", contact);
        } else {
            log.warn("Service: Contact with id {} not found for update", id);
        }
        return contact;
    }

    // ---- UC2-DELETE ----
    public boolean deleteContact(int id) {
        log.debug("Service: Deleting contact with id {}", id);
        boolean removed = contactList.removeIf(c -> c.getId() == id);
        if (removed) {
            log.debug("Service: Contact with id {} deleted successfully", id);
        } else {
            log.warn("Service: Contact with id {} not found for deletion", id);
        }
        return removed;
    }
}
