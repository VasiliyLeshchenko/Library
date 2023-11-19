package by.vasya.springcourse.dao;

import by.vasya.springcourse.models.Book;
import by.vasya.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person ORDER BY full_name", new PersonMapper());
    }

    public void save(Person person) {
        jdbcTemplate.update(
                "INSERT INTO person (full_name, birth_age) VALUES (?, ?)",
                person.getFullName(), person.getBirthAge()
        );
    }

    public Person show(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM person WHERE person_id=?",
                new Object[] {id},
                new PersonMapper()).stream().findAny().orElse(null);


    }

    public Optional<Person> show(String fullName) {
        return jdbcTemplate.query(
                "SELECT * FROM person WHERE full_name=?",
                new Object[] {fullName},
                new PersonMapper()).stream().findAny();


    }

    public List<Book> getBooks(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM book WHERE person_id=?",
                new Object[] {id},
                new BookMapper()
        );
    }

    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE person_id=?", id);
    }

    public void update(int id, Person person) {
        jdbcTemplate.update(
                "UPDATE person SET full_name=?, birth_age=? WHERE person_id=?",
                    person.getFullName(), person.getBirthAge(), id
        );
    }
}
