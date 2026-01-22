package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    // ---- UC2-POST ----
    @PostMapping
    public AddressBookModel addContact(@RequestBody AddressBookDTO dto) {
        log.info("Adding address book contact with name: {}", dto.getName());
        return addressBookService.addContact(dto);
    }

    // ---- UC2-GET-ALL ----
    @GetMapping
    public List<AddressBookModel> getAllContacts() {
        log.info("Fetching all address book contacts");
        return addressBookService.getAllContacts();
    }

    // ---- UC2-GET-BY-ID ----
    @GetMapping("/{id}")
    public AddressBookModel getContactById(@PathVariable int id) {
        log.info("Fetching address book contact with id: {}", id);
        return addressBookService.getContactById(id);
    }

    // ---- UC2-PUT ----
    @PutMapping("/{id}")
    public AddressBookModel updateContact(
            @PathVariable int id,
            @RequestBody AddressBookDTO dto) {
        log.info("Updating address book contact with id: {}", id);
        return addressBookService.updateContact(id, dto);
    }

    // ---- UC2-DELETE ----
    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable int id) {
        log.info("Deleting address book contact with id: {}", id);
        boolean deleted = addressBookService.deleteContact(id);
        return deleted ? "Contact deleted successfully" : "Contact not found";
    }
}
