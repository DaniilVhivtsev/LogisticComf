package com.logisticcomfort.repos;

import com.logisticcomfort.model.Company;
import com.logisticcomfort.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CompanyRepo extends CrudRepository<Company, Long>{
    Company findById(long id);
//    Company findById (long id);
}
