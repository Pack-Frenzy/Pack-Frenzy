package com.example.packathon.model;

public class Player {
    private String name;
    private int score;


    public Player() {
        // have a field for image (face)
        name = null;
        score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
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
}
