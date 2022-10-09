package com.example.projekt.ockovanie;

import com.example.projekt.Ockovanie.Ockovanie;
import com.example.projekt.Ockovanie.OckovanieEntity;
import com.example.projekt.Ockovanie.OckovanieRepository;
import com.example.projekt.Ockovanie.OckovanieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class OckovanieServiceTest {
    @InjectMocks
    private OckovanieService ockovanieService;

    @Mock
    private OckovanieRepository ockovanieRepository;

    @Test
    public void osobaServiceCreate() {
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
}
