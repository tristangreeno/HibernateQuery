package com.theironyard;

import javax.persistence.*;

/**
 * Stores the name and email of each customer who has made a purchase.
 * CSV format: name,email
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    Integer id;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    public Customer(){}
}
