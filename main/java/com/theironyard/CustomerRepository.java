package com.theironyard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Storage system (CRUD) for data on customers.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    @Query("SELECT c from Customer c where c.id=?1")
    Customer findById(Integer id);
}
