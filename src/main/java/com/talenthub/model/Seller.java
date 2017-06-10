package com.talenthub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;

/**
 * Created by user on 13/05/2017.
 */
@Entity
public class Seller {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    public Seller(){

    }
    public Seller(String firstName, String lastName){

        this.firstName=firstName;
        this.lastName=lastName;

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

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }
}
