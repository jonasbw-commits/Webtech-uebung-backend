package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="cards")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Frage darf nicht leer sein")
    private String question;

    @NotBlank(message = "Antwort darf nicht leer sein")
    private String answer;
    private boolean learned;

    private Long deckId;

    public CardEntity() {}

    public CardEntity(String question, String answer, boolean learned) {
        this.question = question;
        this.answer = answer;
        this.learned = learned;
    }

    public Long getId() { return id; }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public Long getDeckId() {
        return deckId;
    }

    public void setDeckId(Long deckId) {
        this.deckId = deckId;
    }
}

