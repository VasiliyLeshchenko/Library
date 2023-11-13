package by.vasya.springcourse.models;

public class Person {
    private int person_id;
    private String fullName;
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
