package com.talenthub.model;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import java.util.Random;
import java.util.UUID;

/**
 * Created by user on 13/05/2017.
 */
@Entity
@Table(name="buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;

    public Buyer(){

    }
    public Buyer(String firstName, String lastName){

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
