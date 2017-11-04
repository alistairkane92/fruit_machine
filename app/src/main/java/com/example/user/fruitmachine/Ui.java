package com.example.user.fruitmachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Created by user on 04/11/2017.
 */

public class Ui {

    Scanner sc;
    private String response;
    BufferedReader br;

    public Ui(){
        this.sc = new Scanner(System.in);
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String askUserIfTheyWantToPlay(){
        System.out.println("----------------------------------------------------------");
        System.out.println("-- Welcome to the Puggy! Please contain your excitement --");
        System.out.println("----------------------------------------------------------");
        System.out.println("   Do you want to play a game? Y/N");

        try {
            response = br.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }

    public void resultDependentText(Integer amountWon){
        if (amountWon >=30){
            System.out.println("!!!!!!! YOU WON THE JACKPOT !!!!!!!!");
        } else if (amountWon >= 27){
            System.out.println("You're a big winner, drinks are on you!");
        } else if (amountWon >= 24){
            System.out.println("Very good! You're in the money. Congrats");
        } else if (amountWon >= 21){
            System.out.println("Nice win!");
        } else if (amountWon >= 18){
            System.out.println("We have ourselves a winner!");
        } else if (amountWon >= 15){
            System.out.println("Its a moderate win! You should be moderately happy!");
        } else if (amountWon >= 12){
            System.out.println("A small win. Good for you.");
        } else if (amountWon >= 9){
            System.out.println("Well at least you didn't lose");
        } else if (amountWon >= 6){
            System.out.println("You won. A bit. Sort of...");
        } else if (amountWon >= 3){
            System.out.println("Bad news I'm afraid. You've won. The worst amount possible. Feel bad.");
        } else System.out.println("You did not win. I am deeply sorry for your loss. Please try again. Please.");
    }

    public void showUserSymbols(String threeSymbols){
        System.out.println("----------------- Spinning the wheel ---------------------");
        System.out.println(" ");
        System.out.println("             ===== " + threeSymbols + "=====");
        System.out.println(" ");
    }

    public void showUserFunds(int playerFunds) {
        System.out.println("You have " + playerFunds + " coins remaining.");
    }
}
