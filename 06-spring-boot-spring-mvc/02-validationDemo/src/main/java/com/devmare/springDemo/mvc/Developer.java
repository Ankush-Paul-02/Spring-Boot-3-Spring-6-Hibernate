package com.devmare.springDemo.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Developer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName = "";

    @Min(value = 0, message = "Minimum value must be greater than or equal to 0")
    @Max(value = 10, message = "Maximum value must be less than or equal to 10")
    private int freePasses;

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

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }
}
