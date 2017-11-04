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

    public void introMessage(){
        System.out.println("----------------------------------------------------------");
        System.out.println("-- Welcome to the Puggy! Please contain your excitement --");
        System.out.println("----------------------------------------------------------");
    }
    public String askUserIfTheyWantToPlay(){

        System.out.println(" Do you want to play a game? Press Y to play (Cost: 1 coin)");

        try {
            response = br.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }

    public void showWin(int amountWon){
        if (amountWon > 0){
            System.out.println("You have won " + amountWon + " coins!!!");
        }
    }

    public void resultDependentText(Integer amountWon){
        if (amountWon >=30){
            System.out.println("!!!!!!! YOU WON THE JACKPOT !!!!!!!!");
        } else if (amountWon >= 27){
            System.out.println("   !    You're a big winner, drinks are on you! --");
        } else if (amountWon >= 24){
            System.out.println("   !    Super! You're in the money. Congrats --");
        } else if (amountWon >= 21){
            System.out.println("  Good win!");
        } else if (amountWon >= 18){
            System.out.println("    !   We have ourselves a winner!");
        } else if (amountWon >= 15){
            System.out.println("   !    Its a moderate win! As such, you should be moderately happy!");
        } else if (amountWon >= 12){
            System.out.println("   !    A small win. Good for you.");
        } else if (amountWon >= 9){
            System.out.println("   !    Well at least you didn't lose");
        } else if (amountWon >= 6){
            System.out.println("   !    You won. A bit. Sort of...");
        } else if (amountWon >= 3){
            System.out.println("   !    Bad news I'm afraid. You've won. The least amount possible. Feel bad.");
        } else System.out.println(" You did not win. I am deeply sorry for your loss. Please try again. Please.");
    }

    public void showMachineOutOfCash(){
        System.out.println("    The machine is out of cash! Go do something else. Then come back later. Come back when you are worthy.");
    }

    public void showUserSymbols(String threeSymbols){
        System.out.println("----------------- Spinning the wheel ---------------------");
        System.out.println(" ");
        System.out.println("             ===== " + threeSymbols + "=====");
        System.out.println(" ");
    }

    public void showUserFunds(int playerFunds) {
        System.out.println(" You have " + playerFunds + " coins remaining.");
    }

    public void showUserOutOfCash() {
        System.out.println("    You've got no money. I no longer have any interest in doing business with you.");
    }

    public void outroMessage() {
        System.out.println("    Come back again soon!  With money! ");
    }
}
