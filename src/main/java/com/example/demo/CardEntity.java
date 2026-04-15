package com.example.demo;

public class CardEntity {

    private String question;
    private String answer;
    private boolean learned;

    public CardEntity(String question, String answer, boolean learned) {
        this.question = question;
        this.answer = answer;
        this.learned = false;
    }

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
}

