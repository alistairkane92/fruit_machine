package com.example.user.fruitmachine;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 03/11/2017.
 */

public class Runner {

    public static void main(String[] args) {
        FruitMachine fruitMachine = new FruitMachine("The Juicy Lucy", 200, 100);
        fruitMachine.play();
    }

}