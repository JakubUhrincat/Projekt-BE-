package com.example.projekt.osoba;

import com.example.projekt.Osoba.Osoba;
import com.example.projekt.Osoba.OsobaService;
import com.example.projekt.Vakcina.VakcinaController;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VakcinaController.class)
public class OsobaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OsobaService osobaService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    @SneakyThrows
    public void createVakcina() {
        when(osobaService.createOsoba(any())).thenReturn(1);

        Osoba osoba = new Osoba()
                .setMeno("Johnson")
                .setPriezvisko("Ištanovič")
                .setRok_nar("1955")
                .setRod_cislo("0154815/8778")
                .setBydlisko("RA")
                .setPohlavie("Muz")
                .setTel_cislo("0915330788");

        String json = mapper.writeValueAsString(osoba);

        mockMvc.perform(
                        post("/api/osoba")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.equalTo(1)));

        verify(osobaService, times(1)).getOsobaById(any());
    }
}
