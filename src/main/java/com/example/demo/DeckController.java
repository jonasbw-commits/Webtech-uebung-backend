package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decks")
public class DeckController {

    private final DeckRepository deckRepository;

    public DeckController(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    @GetMapping
    public List<DeckEntity> getAllDecks() {
        return deckRepository.findAll();
    }

    @PostMapping
    public DeckEntity createDeck(@RequestBody DeckEntity deck) {
        return deckRepository.save(deck);
    }

    @DeleteMapping("/{id}")
    public void deleteDeck(@PathVariable Long id) {
        deckRepository.deleteById(id);
    }
}
