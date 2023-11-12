package by.vasya.springcourse.dao;

import by.vasya.springcourse.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(rs.getInt("person_id"));
        person.setFullName(rs.getString("full_name"));
        person.setBirthAge(rs.getInt("birth_age"));
        System.out.println(person);
        return person;
    }
}
