package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCards_returnsAllCards() {
        CardEntity card = new CardEntity("Frage", "Antwort", false);
        when(cardRepository.findAll()).thenReturn(List.of(card));

        List<CardEntity> result = cardService.getAllCards();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getQuestion()).isEqualTo("Frage");
    }

    @Test
    void createCard_savesCard() {
        CardEntity card = new CardEntity("Frage", "Antwort", false);
        when(cardRepository.save(any())).thenReturn(card);

        CardEntity result = cardService.createCard(card);

        assertThat(result.getQuestion()).isEqualTo("Frage");
        verify(cardRepository, times(1)).save(card);
    }

    @Test
    void updateCard_throwsWhenNotFound() {
        when(cardRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> cardService.updateCard(99L, new CardEntity("x", "y", false)));
    }

    @Test
    void updateCard_setsDeckId() {
        CardEntity existing = new CardEntity("Frage", "Antwort", false);
        CardEntity updated = new CardEntity("Frage", "Antwort", false);
        updated.setDeckId(2L);

        when(cardRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(cardRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        CardEntity result = cardService.updateCard(1L, updated);

        assertThat(result.getDeckId()).isEqualTo(2L);
    }
}
