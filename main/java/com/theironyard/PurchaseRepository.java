package com.theironyard;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Storage (CRUD) for all purchases made. Each is related to a customer by the customer ID for tracking.
 */
public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{
    // @Query("FROM Purchase p WHERE p.category=?1")
    List<Purchase> findByCategory(String category);
}
