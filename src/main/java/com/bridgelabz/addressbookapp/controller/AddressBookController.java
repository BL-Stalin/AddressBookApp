package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // ---- UC2-POST ----
    @PostMapping
    public AddressBookModel addContact(@RequestBody AddressBookDTO dto) {
        return addressBookService.addContact(dto);
    }

    // ---- UC2-GET-ALL ----
    @GetMapping
    public List<AddressBookModel> getAllContacts() {
        return addressBookService.getAllContacts();
    }

    // ---- UC2-GET-BY-ID ----
    @GetMapping("/{id}")
    public AddressBookModel getContactById(@PathVariable int id) {
        return addressBookService.getContactById(id);
    }

    // ---- UC2-PUT ----
    @PutMapping("/{id}")
    public AddressBookModel updateContact(
            @PathVariable int id,
            @RequestBody AddressBookDTO dto) {
        return addressBookService.updateContact(id, dto);
    }

    // ---- UC2-DELETE ----
    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable int id) {
        boolean deleted = addressBookService.deleteContact(id);
        return deleted ? "Contact deleted successfully" : "Contact not found";
    }
}
