package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private List<AddressBookModel> contacts = new ArrayList<>();
    private int contactId = 1;

    // ---- UC2-GET-ALL ----
    @GetMapping
    public List<AddressBookModel> getAllContacts() {
        return contacts;
    }

    // ---- UC2-GET-BY-ID ----
    @GetMapping("/{id}")
    public AddressBookModel getContactById(@PathVariable int id) {
        return contacts.stream()
                .filter(contact -> contact.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ---- UC2-POST ----
    @PostMapping
    public AddressBookModel addContact(@RequestBody AddressBookDTO dto) {
        AddressBookModel model =
                new AddressBookModel(contactId++, dto.getName(), dto.getPhoneNumber(), dto.getCity());
        contacts.add(model);
        return model;
    }

    // ---- UC2-PUT ----
    @PutMapping("/{id}")
    public AddressBookModel updateContact(
            @PathVariable int id,
            @RequestBody AddressBookDTO dto) {

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
    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable int id) {
        boolean removed = contacts.removeIf(c -> c.getId() == id);
        return removed ? "Contact deleted successfully" : "Contact not found";
    }
}
