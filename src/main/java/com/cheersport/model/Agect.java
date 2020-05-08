package com.cheersport.model;

public enum Agect {
    ADULT("взрослый"),
    UNIOR("юниор"),
    CHILD("дети");

    private String name;

    Agect(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
