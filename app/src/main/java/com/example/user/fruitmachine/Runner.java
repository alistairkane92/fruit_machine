package com.example.user.fruitmachine;

import java.util.ArrayList;

/**
 * Created by user on 03/11/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Ui ui = new Ui();
        FruitMachine fruitMachine = new FruitMachine("The Juicy Lucy", 200, 100, 1, 3);
        fruitMachine.play();
        fruitMachine.compareSymbolsReturnWinnings();
    }

}