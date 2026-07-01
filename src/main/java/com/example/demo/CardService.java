package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardEntity> getAllCards() {
        return cardRepository.findAll();
    }

    public CardEntity createCard(CardEntity card) {
        return cardRepository.save(card);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public CardEntity updateCard(Long id, CardEntity updated) {
        CardEntity card = cardRepository.findById(id).orElseThrow();
        card.setQuestion(updated.getQuestion());
        card.setAnswer(updated.getAnswer());
        card.setLearned(updated.isLearned());
        card.setDeckId(updated.getDeckId());
        return cardRepository.save(card);
    }
}
