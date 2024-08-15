package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "PATRON")
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patronId;
    private String patronName;
    private String patronAddress;
    private int patronPhone;
    private String patronEmail;
}
