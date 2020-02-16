package com.example.packathon.model;

public class Player {
    private String name;
    private int score;

    public Player() {
        // TODO: have a field for image (face)
        name = "";
        score = 0;
    }

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void subtractScore(int score) {
        this.score -= score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
