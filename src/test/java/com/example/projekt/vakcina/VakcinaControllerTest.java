package com.example.projekt.vakcina;

import com.example.projekt.Vakcina.Vakcina;
import com.example.projekt.Vakcina.VakcinaController;
import com.example.projekt.Vakcina.VakcinaService;
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
public class VakcinaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VakcinaService vakcinaService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    @SneakyThrows
    public void createVakcina() {
        when(vakcinaService.createVakcina(any())).thenReturn(1);

        Vakcina vakcina = new Vakcina()
                .setNazov("Johnson")
                .setPocet_davok(5);

        String json = mapper.writeValueAsString(vakcina);

        mockMvc.perform(
                        post("/api/vakcina")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.equalTo(1)));

        verify(vakcinaService, times(1)).getVakcinaById(any());
    }
}