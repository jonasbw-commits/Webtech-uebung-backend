package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CardController.class)
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CardRepository cardRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllCards_returnsListOfCards() throws Exception {
        CardEntity card = new CardEntity("Was ist Java?", "Eine Programmiersprache", false);

        when(cardRepository.findAll()).thenReturn(List.of(card));

        mockMvc.perform(get("/cards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].question").value("Was ist Java?"))
                .andExpect(jsonPath("$[0].answer").value("Eine Programmiersprache"));
    }

    @Test
    void createCard_savesAndReturnsCard() throws Exception {
        CardEntity card = new CardEntity("Frage", "Antwort", false);

        when(cardRepository.save(any())).thenReturn(card);

        mockMvc.perform(post("/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(card)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.question").value("Frage"))
                .andExpect(jsonPath("$.answer").value("Antwort"));
    }

    @Test
    void deleteCard_callsDeleteById() throws Exception {
        doNothing().when(cardRepository).deleteById(1L);

        mockMvc.perform(delete("/cards/1"))
                .andExpect(status().isOk());

        verify(cardRepository, times(1)).deleteById(1L);
    }

    @Test
    void updateCard_updatesFieldsAndReturnsCard() throws Exception {
        CardEntity existing = new CardEntity("Alt", "Alte Antwort", false);
        CardEntity updated = new CardEntity("Neu", "Neue Antwort", true);

        when(cardRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(cardRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        mockMvc.perform(put("/cards/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.question").value("Neu"))
                .andExpect(jsonPath("$.answer").value("Neue Antwort"))
                .andExpect(jsonPath("$.learned").value(true));
    }
}
