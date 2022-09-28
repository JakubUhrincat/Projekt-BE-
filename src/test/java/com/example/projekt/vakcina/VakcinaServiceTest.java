package com.example.projekt.vakcina;

import com.example.projekt.Vakcina.Vakcina;
import com.example.projekt.Vakcina.VakcinaEntity;
import com.example.projekt.Vakcina.VakcinaRepository;
import com.example.projekt.Vakcina.VakcinaService;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VakcinaServiceTest {

    @InjectMocks
    private VakcinaService vakcinaService;

    @Mock
    private VakcinaRepository vakcinaRepository;

    @Captor
    private ArgumentCaptor<String> nazovBodyCaptor;

    @Test
    public void vakcinaServiceSave() {
        // --- setup
        int generatedId = 1;

        VakcinaEntity fakeEntity = new VakcinaEntity().setId(generatedId)
                .setNazov("Johnson")
                .setPocet_davok("1");

        when(vakcinaRepository.save(any(VakcinaEntity.class)))
                .thenReturn(fakeEntity);

        // --- execution
        Vakcina vakcinaToGet = new Vakcina().setNazov("NovaVakcina")
                                            .setPocet_davok("5");

        int id = vakcinaService.getVakcinaByNazov(vakcinaToGet);

        // verification
        assertEquals(generatedId, id);
        verify(vakcinaRepository, times(1)).save(any());

    }
}
