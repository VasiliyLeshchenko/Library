package by.vasya.springcourse.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Book {
    private int bookId;

    @Size(min=2, max=100, message="Name should be between 2 and 100")
    private String title;
    @Size(min=2, max=100, message="Your author should be between 2 and 100")
    private String author;
    @Min(value = 0, message="Year should be greater than 0")
    private int year;

    public Book() {}

    public Book(int bookId, String title, String author, int year) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + year;
    }
}
