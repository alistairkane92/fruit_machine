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
        System.out.println("Do you want to play a game? Y/N");

        try {
            response = br.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }

    public void showUserSymbols(String threeSymbols){
        System.out.println("----------------- Spinning the wheel ---------------------");
        System.out.println(" ");
        System.out.println("             ===== " + threeSymbols + "======");
        System.out.println(" ");
        System.out.println("Gambling is for bloody idiots. You probably lost. Let's play again.");
    }
}
