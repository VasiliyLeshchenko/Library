package by.vasya.springcourse.models;

public class Person {
    private int id;
    private String fullName;
    private int birthAge;

    public Person() {}

    public Person(int id, String fullName, int birthAge) {
        this.id = id;
        this.fullName = fullName;
        this.birthAge = birthAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
