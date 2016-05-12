package com.theironyard;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Stores the date, credit card number, CVV, and category of each purchase made
 * CSV format: customer_id,date,credit_card,cvv,category
 */
@Entity
@Table(name = "purchases")
public class Purchase {
    public Purchase(){}

    @Id
    Integer id;

    @Column(nullable = false)
    String date;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    String cvv;

    @Column(nullable = false)
    String category;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    @ManyToOne
    Customer customer;

    public Purchase(Integer id, String date, String creditCard, String cvv, String category, Customer customer) {
        this.id = id;
        this.date = date;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
        this.name = customer.name;
        this.email = customer.email;
    }
}
