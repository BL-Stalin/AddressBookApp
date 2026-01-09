package com.bridgelabz.addressbookapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private List<String> contacts = new ArrayList<>();

    // ---- UC2-GET-ALL ----
    @GetMapping
    public List<String> getAllContacts() {
        return contacts;
    }

    // ---- UC2-GET-BY-ID ----
    @GetMapping("/{id}")
    public String getContactById(@PathVariable int id) {
        if (id >= 0 && id < contacts.size()) {
            return contacts.get(id);
        }
        return "Contact not found";
    }

    // ---- UC2-POST ----
    @PostMapping
    public String addContact(@RequestBody String name) {
        contacts.add(name);
        return "Contact added successfully";
    }

    // ---- UC2-PUT ----
    @PutMapping("/{id}")
    public String updateContact(@PathVariable int id, @RequestBody String name) {
        if (id >= 0 && id < contacts.size()) {
            contacts.set(id, name);
            return "Contact updated successfully";
        }
        return "Contact not found";
    }

    // ---- UC2-DELETE ----
    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable int id) {
        if (id >= 0 && id < contacts.size()) {
            contacts.remove(id);
            return "Contact deleted successfully";
        }
        return "Contact not found";
    }
}
