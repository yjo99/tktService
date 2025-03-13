package org.system.ticketsystem.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class FormDto {

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Please enter a valid email address")
    private String email;


    // Getter and Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
