package com.example.library.service;

import com.example.library.dto.PatronDTO;
import com.example.library.mapper.PatronMapper;
import com.example.library.model.Patron;
import com.example.library.repository.PatronRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PatronServiceTest {

    @InjectMocks
    private PatronService patronService;

    @Mock
    private PatronRepository patronRepository;

    public PatronServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllPatrons() {
        Patron patron = new Patron();
        patron.setPatronId(1L);
        patron.setPatronName("Test Patron");
        patron.setPatronAddress("Tst add");
        patron.setPatronEmail("tst@mal.cc");
        patron.setPatronPhone(10333322);

        when(patronRepository.findAll()).thenReturn(Collections.singletonList(patron));

        PatronDTO patronDTO = PatronMapper.mapToPatronDTO(patron);
        assertEquals(Collections.singletonList(patronDTO), patronService.getAllPatrons());
    }

    @Test
    void testGetPatronById() {
        Patron patron = new Patron();
        patron.setPatronId(1L);
        patron.setPatronName("Test Patron");
        patron.setPatronAddress("Tst add");
        patron.setPatronEmail("tst@mal.cc");
        patron.setPatronPhone(10333322);

        when(patronRepository.findById(1L)).thenReturn(Optional.of(patron));

        PatronDTO patronDTO = PatronMapper.mapToPatronDTO(patron);
        assertEquals(Optional.of(patronDTO), patronService.getPatronById(1L));
    }

    @Test
    void testSavePatron() {
        PatronDTO patronDTO = new PatronDTO();
        patronDTO.setPatronName("Test Patron");
        patronDTO.setPatronAddress("Tst add");
        patronDTO.setPatronEmail("tst@mal.cc");
        patronDTO.setPatronPhone(10333322);


        Patron patron = PatronMapper.mapToPatron(patronDTO);

        when(patronRepository.save(patron)).thenReturn(patron);

        assertEquals(patronDTO, patronService.savePatron(patronDTO));
    }

    @Test
    void testDeletePatron() {
        patronService.deletePatron(1L);
        verify(patronRepository, times(1)).deleteById(1L);
    }
}
