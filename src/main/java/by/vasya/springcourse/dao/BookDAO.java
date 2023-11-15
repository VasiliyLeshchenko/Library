package by.vasya.springcourse.dao;

import by.vasya.springcourse.models.Book;
import by.vasya.springcourse.models.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book ORDER BY title", new BookMapper());
    }

    public void save(Book book) {
        jdbcTemplate.update(
                "INSERT INTO book (title, author, year) VALUES (?, ?, ?)",
                book.getTitle(),
                book.getAuthor(),
                book.getYear()
        );
    }

    public Book show(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM book WHERE book_id=?",
                new Object[] {id},
                new BookMapper()
        ).stream().findAny().orElse(null);
    }

    public Optional<Person> getOwner(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM person WHERE (SELECT person_id FROM book WHERE book_id=?)=person_id",
                new Object[]{id},
                new PersonMapper()
        ).stream().findAny();
    }

    public void update(int id, Book book) {
        jdbcTemplate.update(
                "UPDATE book SET title=?, author=?, year=? WHERE book_id=?",
                book.getTitle(), book.getAuthor(), book.getYear(), id
        );
    }

    public void assign(int id, Person issignPerson) {
        jdbcTemplate.update("UPDATE book SET person_id=? WHERE book_id=?", issignPerson.getPersonId(), id);
    }

    public void release(int id) {
        jdbcTemplate.update("UPDATE book SET person_id=NULL WHERE book_id=?", id);
    }

    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE book_id=?", id);
    }
}
