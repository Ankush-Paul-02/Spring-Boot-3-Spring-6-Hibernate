package com.devmare.springDemo.mvc;

import com.devmare.springDemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Developer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName = "";

    @NotNull(message = "is required")
    @Min(value = 0, message = "Minimum value must be greater than or equal to 0")
    @Max(value = 10, message = "Maximum value must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{6}", message = "Only 6 chars/digits")
    private String postalCode;

    @CourseCode(value = "PAUL", message = "Must be start with PAUL")
    private String courseCode;

    public Developer() {}

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
