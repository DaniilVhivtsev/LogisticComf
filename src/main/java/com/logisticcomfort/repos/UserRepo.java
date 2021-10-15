package com.logisticcomfort.repos;

import com.logisticcomfort.model.Company;
import com.logisticcomfort.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

//    List<User> findAllByCompany(Company company);

}