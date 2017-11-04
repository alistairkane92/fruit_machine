package com.example.user.fruitmachine;

/**
 * Created by user on 03/11/2017.
 */

//could use emojis or maybe put in codeclan symbol (as img) worth lots of munny?
//could output to system using pause etc

public enum Symbol {

    STRAWBERRY(10, "Strawberry"),
    LEMON(9, "Lemon"),
    DATE(8, "Date"),
    SEVEN(7, "Seven"),
    PEACH(6, "Peach"),
    LIME(5, "Lime"),
    APPLE(4, "Apple"),
    ASIANPEAR(3, "Asian Pear"),
    KIWI(2, "Kiwi"),
    ORANGE(1, "Orange");

    private int value;
    private String name;

    Symbol(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }



}


