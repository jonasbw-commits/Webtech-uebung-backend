# Webtech-uebung-backend: Flashcard Web Application

## Description
This project is a simple web application for managing flashcards. It provides a REST API to create, view, and delete flashcards.

## Purpose
The application is designed as a learning tool for students to practice with question-and-answer cards.

## Technologies
Java, Spring Boot, REST API

## Features
Users can create new flashcards, view all flashcards, and delete flashcards. An update function can be added if needed.

## Data Model

### Card
A card contains a question and an answer. It can also include a field to mark whether the card has been learned.

### Deck (optional)
A deck is a collection of cards with a name.

## API Endpoints
GET /cards returns all flashcards.
POST /cards creates a new flashcard.
DELETE /cards/{index} deletes a flashcard by index.

## How to Run
Start the application with mvn spring-boot:run. The API is available at: 

## Purpose of the Project
The project is part of a Web Technologies course. The goal is to gradually develop a web application throughout the course and ultimately create a complete website by the end.


