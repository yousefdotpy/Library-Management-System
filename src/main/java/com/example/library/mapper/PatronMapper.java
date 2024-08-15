package com.example.library.mapper;

import com.example.library.dto.PatronDTO;
import com.example.library.model.Patron;

public class PatronMapper {

    public static PatronDTO mapToPatronDTO(Patron patron) {
        PatronDTO patronDTO = new PatronDTO();
        patronDTO.setPatronId(patron.getPatronId());
        patronDTO.setPatronName(patron.getPatronName());
        patronDTO.setPatronAddress(patron.getPatronAddress());
        patronDTO.setPatronPhone(patron.getPatronPhone());
        patronDTO.setPatronEmail(patron.getPatronEmail());
        return patronDTO;
    }

    public static Patron mapToPatron(PatronDTO patronDTO) {
        Patron patron = new Patron();
        patron.setPatronId(patronDTO.getPatronId());
        patron.setPatronName(patronDTO.getPatronName());
        patron.setPatronAddress(patronDTO.getPatronAddress());
        patron.setPatronPhone(patronDTO.getPatronPhone());
        patron.setPatronEmail(patronDTO.getPatronEmail());
        return patron;
    }

}
