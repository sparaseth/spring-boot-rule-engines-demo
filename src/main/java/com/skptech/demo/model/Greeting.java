package com.skptech.demo.model;

public enum Greeting {

    GOOD_MORNING("Good Morning"),
    GOOD_AFTERNOON("Good Afternoon"),
    GOOD_EVENING("Good Evening"),
    GOOD_NIGHT("Good Night");

    private String literal;

    Greeting(String literal) {
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

}
