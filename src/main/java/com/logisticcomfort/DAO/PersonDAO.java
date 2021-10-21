package com.logisticcomfort.DAO;

import com.logisticcomfort.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static int PEOPLE_COUNT;

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show (int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void Save(Person person){
//        jdbcTemplate.update("INSERT INTO users VALUES( DEFAULT , ?, ?, ?, ?)", person.getUsername(), person.getPassword(), person.getEmail(), person.getCompany_name());
        jdbcTemplate.update("INSERT INTO users VALUES( ?, ?, 1)", person.getUsername(), person.getPassword());
    }

    public void Update(int id, Person updatedPerson){
//        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(), updatedPerson.getAge(),
//                updatedPerson.getEmail(), id);
    }

    public void Delete(int id){
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }
}
