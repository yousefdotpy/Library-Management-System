package com.example.library.service;

import com.example.library.dto.PatronDTO;
import com.example.library.model.Patron;
import com.example.library.repository.PatronRepository;
import com.example.library.mapper.PatronMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

    public List<PatronDTO> getAllPatrons() {
        return patronRepository.findAll()
                .stream()
                .map(PatronMapper::mapToPatronDTO)
                .collect(Collectors.toList());
    }

    public Optional<PatronDTO> getPatronById(Long id) {
        return patronRepository.findById(id).map(PatronMapper::mapToPatronDTO);
    }

    public PatronDTO savePatron(PatronDTO patronDTO) {
        Patron patron = PatronMapper.mapToPatron(patronDTO);
        Patron savedPatron = patronRepository.save(patron);
        return PatronMapper.mapToPatronDTO(savedPatron);
    }

    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
