package com.example.projekt.ockovanie;

import com.example.projekt.Ockovanie.Ockovanie;
import com.example.projekt.Ockovanie.OckovanieEntity;
import com.example.projekt.Ockovanie.OckovanieRepository;
import com.example.projekt.Ockovanie.OckovanieService;
import com.example.projekt.Vakcina.Vakcina;
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
public class OckovanieServiceTest {
    @InjectMocks
    private OckovanieService ockovanieService;

    @Mock
    private OckovanieRepository ockovanieRepository;

    @Test
    public void ockovanieServiceCreate() {
        int generatedId = 1;

        OckovanieEntity fakeEntity = new OckovanieEntity().setId(generatedId)
                .setOsoba("1")
                .setVakcina("1")
                .setDatum("22.22.2222");


        when(ockovanieRepository.save(any(OckovanieEntity.class)))
                .thenReturn(fakeEntity);

        Ockovanie id = ockovanieService.getOckovanie(1);

        assertEquals(generatedId, id);
        verify(ockovanieRepository, times(1)).save(any());

    }

    @Test
    public void ockovanieServiceCreateFail() {

        Ockovanie ockovanieToSave = new Ockovanie().setOsobaId(2).setVakcinaId(2);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ockovanieService.createOckovanie(ockovanieToSave));
        assertEquals("Author or Title are empty fields", exception.getMessage());

        verify(ockovanieRepository, times(0)).save(any());
    }
}
