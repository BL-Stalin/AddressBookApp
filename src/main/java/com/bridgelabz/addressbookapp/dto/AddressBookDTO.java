package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(
            regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
            message = "Name must start with a capital letter and have at least 3 characters"
    )
    private String name;

    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must be 10 digits"
    )
    private String phoneNumber;

    @NotEmpty(message = "City cannot be empty")
    private String city;
}
