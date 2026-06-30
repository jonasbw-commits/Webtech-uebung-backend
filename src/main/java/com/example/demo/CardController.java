package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    
    @GetMapping
    public List<CardEntity> getAllCards(){
        return cardRepository.findAll();
    }

    @PostMapping
    public CardEntity createCard(@RequestBody CardEntity card) {
        return cardRepository.save(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public CardEntity updateCard(@PathVariable Long id, @RequestBody CardEntity updated) {
        CardEntity card = cardRepository.findById(id).orElseThrow();
        card.setQuestion(updated.getQuestion());
        card.setAnswer(updated.getAnswer());
        card.setLearned(updated.isLearned());
        return cardRepository.save(card);
    }
}
