package com.example.projekt.vakcina;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Vakcina.Vakcina;
import com.example.projekt.Vakcina.VakcinaEntity;
import com.example.projekt.Vakcina.VakcinaRepository;
import com.example.projekt.Vakcina.VakcinaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class VakcinaServiceTest {

    @InjectMocks
    private VakcinaService vakcinaService;

    @Mock
    private VakcinaRepository vakcinaRepository;

    @Test
    public void vakcinaServiceCreate() {
        int generatedId = 1;

        VakcinaEntity fakeEntity = new VakcinaEntity().setId(generatedId)
                .setNazov("Johnson")
                .setPocet_davok(1);

        when(vakcinaRepository.save(any(VakcinaEntity.class)))
                .thenReturn(fakeEntity);

        Vakcina id = vakcinaService.getVakcinaById(1);

        assertEquals(generatedId, id);
        verify(vakcinaRepository, times(1)).save(any());

    }
    @Test
    public void vakcinaServiceCreateFail() {

        Vakcina vakcinaToSave = new Vakcina().setNazov("Vakcina");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> vakcinaService.createVakcina(vakcinaToSave));
        assertEquals("Author or Title are empty fields", exception.getMessage());

        verify(vakcinaRepository, times(0)).save(any());
    }
}
