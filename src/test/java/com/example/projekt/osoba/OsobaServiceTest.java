package com.example.projekt.osoba;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Osoba.OsobaEntity;
import com.example.projekt.Osoba.OsobaRepository;
import com.example.projekt.Osoba.OsobaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class OsobaServiceTest {

    @InjectMocks
    private OsobaService osobaService;

    @Mock
    private OsobaRepository osobaRepository;

    @Test
    public void osobaServiceCreate() {
        int generatedId = 1;

        OsobaEntity fakeEntity = new OsobaEntity().setId(generatedId)
                .setMeno("Johnson")
                .setPriezvisko("Ištanovič")
                .setRok_nar("1955")
                .setRod_cislo("0154815/8778")
                .setBydlisko("RA")
                .setPohlavie("Muz")
                .setTel_cislo("0915330788");

        when(osobaRepository.save(any(OsobaEntity.class)))
                .thenReturn(fakeEntity);

        Osoba id = osobaService.getOsobaById(1);

        assertEquals(generatedId, id);
        verify(osobaRepository, times(1)).save(any());

    }

    @Test
    public void osobaServiceCreateFail() {

        Osoba osobaToSave = new Osoba().setMeno("Marek");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> osobaService.createOsoba(osobaToSave));
        assertEquals("Author or Title are empty fields", exception.getMessage());

        verify(osobaRepository, times(0)).save(any());
    }
}
