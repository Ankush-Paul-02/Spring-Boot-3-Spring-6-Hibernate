package com.devmare.springDemo.mvc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Developer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName = "";

    public Developer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
