package com.logisticcomfort.DAO;


import com.logisticcomfort.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setUsername(resultSet.getString("username"));
        person.setPassword(resultSet.getString("password"));
//        person.setEmail(resultSet.getString("email"));
//        person.setCompany_name(resultSet.getString("company_name"));

        return person;
    }
}
