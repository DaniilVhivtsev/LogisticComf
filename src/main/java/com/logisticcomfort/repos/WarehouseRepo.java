package com.logisticcomfort.repos;

import com.logisticcomfort.model.Company;
import com.logisticcomfort.model.Warehouse;
import org.springframework.data.repository.CrudRepository;

public interface WarehouseRepo extends CrudRepository<Warehouse, Long> {
    Warehouse findById(long id);
}
