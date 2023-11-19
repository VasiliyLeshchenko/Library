package by.vasya.springcourse.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
    private int person_id;
    @Size(min = 8, max = 100)
    private String fullName;
    @Min(value = 1900, message = "Birth of age should be bigger than 1900")
    private int birthAge;

    public Person() {}

    public Person(int person_id, String fullName, int birthAge) {
        this.person_id = person_id;
        this.fullName = fullName;
        this.birthAge = birthAge;
    }

    public int getPersonId() {
        return person_id;
    }

    public void setPersonId(int person_id) {
        this.person_id = person_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthAge() {
        return birthAge;
    }

    public void setBirthAge(int birthAge) {
        this.birthAge = birthAge;
    }

    @Override
    public String toString() {
        return fullName + ", " + birthAge;
    }
}
