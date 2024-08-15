package com.example.library.dto;

import lombok.Data;

@Data
public class PatronDTO {

    private long patronId;
    private String patronName;
    private String patronAddress;
    private int patronPhone;
    private String patronEmail;
}
