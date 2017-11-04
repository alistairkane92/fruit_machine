package com.example.user.fruitmachine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by user on 04/11/2017.
 */

public class Ui {

    Scanner sc;
    private String response;
    BufferedReader br;

    public Ui(Scanner sc, BufferedReader br) {
        this.sc = new Scanner(System.in);
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void askUserIfTheyWantToPlay(){
        System.out.println("Do you want to play a game? ");
    }

}
