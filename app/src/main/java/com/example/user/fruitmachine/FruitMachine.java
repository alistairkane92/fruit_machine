package com.example.user.fruitmachine;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 03/11/2017.
 */

public class FruitMachine {
    private String name;
    private int machineFunds;
    private int playerFunds;
    private ArrayList<Symbol> symbols;
    private ArrayList<Symbol> results;
    private int costToPlay;
    private Ui ui;
    private Integer numberOfFruits;

    public FruitMachine(String name, int machineFunds, int playerFunds, int costToPlay, int numberOfFruits) {
        this.name = name;
        this.machineFunds = machineFunds;
        this.playerFunds = playerFunds;
        this.symbols = new ArrayList<>();
        this.results = new ArrayList<>();
        this.costToPlay = costToPlay;
        this.generateSymbols();
        this.ui = new Ui();
        this.numberOfFruits = numberOfFruits;
    }

    public void generateSymbols() {
        for (Symbol symbol : Symbol.values()) {
            symbols.add(symbol);
        }
    }

    public ArrayList<Symbol> getResults() {
        return results;
    }

    public int getMachineFunds() {
        return machineFunds;
    }

    public int getPlayerFunds() {
        return playerFunds;
    }

    public int getCostToPlay() {
        return costToPlay;
    }

    public int getFunds() {
        return machineFunds;
    }

    public ArrayList<Symbol> getSymbols() {
        return symbols;
    }

    public void setMachineFunds(int newFunds) {
        this.machineFunds = newFunds;
    }

    public void setPlayerFunds(int playerFunds) {
        this.playerFunds = playerFunds;
    }

    public Symbol generateSingleRandomFruit() {
        //implement try catch to find out error if fruit machine empty
        Random rand = new Random();

        //returns a random enum from fruit machine symbols arraylist
        Symbol randomSymbol = symbols.get(rand.nextInt(symbols.size()));
        return randomSymbol;
    }


    public Integer getNumberOfFruits() {
        return numberOfFruits;
    }

    public void fillUpMachineFunds(int total) {
        setMachineFunds(total);
    }

    public void spin(int numberOfFruits) {
        //needs to generate a different number of random fruits based on number of fruits displaying

        while (numberOfFruits > 0) {
            this.results.add(generateSingleRandomFruit());
            numberOfFruits -= 1;
        }
    }

    //compares getValue of results array - if they == then prize
//            if (this.results.get(0).getValue() == this.results.get(1).getValue() && this.results.get(0).getValue() ==                   this.results.get(2).getValue()) {
//            total = this.results.get(0).getValue() * this.results.size();
//            }

    public int compareSymbolsReturnWinnings() {
        int total = 0;

        for (int i = 0; i < this.results.size(); i++) {
            for (int j = i+1; j < this.results.size(); j++){
                if (this.results.get(i).getValue() == this.results.get(j).getValue()) {
                    total += 1;
                }
            }
        }
        // ? would have thought total number of comparisons would be number of fruits - 1
        //works for three fruits but not any other number
        if (total == (numberOfFruits)) {
            return this.results.get(0).getValue() * numberOfFruits;
        }
        return 0;
    }

    public void payout(Integer winnings) {
        this.setMachineFunds(this.machineFunds - winnings);
        this.setPlayerFunds(this.playerFunds + winnings);
    }

    public String describeSymbols() {
        String resultsText = "";

        for (Symbol symbol : this.results) {
            resultsText += symbol.name() + " ";
        }

        return resultsText;
    }

    public void removeOldResults(){
        this.results.clear();
    }

    public int highestPossibleWin(){
        int highestValue = 0;
        //method that calculates the highest possible win in order to set a conditional on if the
        //machine can be played or not
        for (Symbol symbol: symbols) {
            if (symbol.getValue() > highestValue) {
                highestValue = symbol.getValue();
            }
            //change three to some kind of variable that can change the number of reels
        }
        return highestValue * 3;
    }

    public void play() {
        ui.introMessage();
        String response = ui.askUserIfTheyWantToPlay().toUpperCase();
        //change 0 to cost to play
        while (response.equals("Y") && playerFunds > costToPlay && machineFunds >= highestPossibleWin()){
                this.spin(numberOfFruits);
                int winnings = this.compareSymbolsReturnWinnings();
                this.payout(winnings);
                setPlayerFunds(playerFunds - 1);
                ui.showUserSymbols(describeSymbols());
                ui.resultDependentText(this.compareSymbolsReturnWinnings());
                ui.showWin(this.compareSymbolsReturnWinnings());
                ui.showUserFunds(playerFunds);
                response = ui.askUserIfTheyWantToPlay().toUpperCase();
                this.removeOldResults();
        }

        if (playerFunds == 0) {
            ui.showUserOutOfCash();
        } else if (machineFunds < 30) {
            ui.showMachineOutOfCash();
        }

        ui.outroMessage();
    }
}