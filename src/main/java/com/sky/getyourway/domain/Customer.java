package com.sky.getyourway.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customer {

    // ATTRIBUTES
    @Id  // sets ID to be a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Sets the ID to auto_increment
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // CONSTRUCTORS
    // Defined Constructors
    public Customer(Integer id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Customer(String firstName, String lastName, String email, String password) {
        super();
        // id not needed as it is automatically assigned and autoincrement as it has been flagged as primary key
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    // Default Constructor
    public Customer() {
        super();
    }


    // BEHAVIOURS (METHODS)
    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Other methods
    public boolean updatePassword(String current_password, String new_password) {
        if(current_password.equals((this.getPassword()))) {
            this.setEmail(new_password);
            return true;  // success, password changed
        }
        return false; // password not changed
        }


    // TO STRING METHOD
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }
}
