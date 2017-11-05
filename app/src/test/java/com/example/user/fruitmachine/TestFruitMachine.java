package com.example.user.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 03/11/2017.
 */

public class TestFruitMachine {
    private FruitMachine fruitMachine;
    private ArrayList<Symbol> symbols;
    private ArrayList<Symbol> results;

    @Before
    public void setUp() throws Exception {
        symbols = new ArrayList<>();
        results = new ArrayList<>();
        fruitMachine = new FruitMachine("The Juicy Lucy", 100, 200, 1, 3);
    }

    @Test
    public void testGetFunds() throws Exception {
        assertEquals(100, fruitMachine.getFunds());
    }

    @Test
    public void testSetFunds() throws Exception {
        fruitMachine.setMachineFunds(200);
        assertEquals(200, fruitMachine.getFunds());
    }

    @Test
    public void testFruitMachineHasSymbols() throws Exception {
        assertEquals(10, fruitMachine.getSymbols().size());
    }

    @Test
    public void testFruitMachineSingleRandomFruit() throws Exception {
        FruitMachine spyMachine = Mockito.spy(new FruitMachine("Test", 100, 200, 1, 4));
        Mockito.when(spyMachine.generateSingleRandomFruit()).thenReturn(Symbol.APPLE);
        int valueOfSingleFruit = spyMachine.generateSingleRandomFruit().getValue();
        assertEquals(4, valueOfSingleFruit);
    }

    @Test
    public void testAddThreeFruitsToResults() throws Exception {
        fruitMachine.spin(fruitMachine.getNumberOfFruits());
        assertEquals(3, fruitMachine.getResults().size());
    }

    @Test
    public void testRemovePreviousResultFromMachine() throws Exception {
        fruitMachine.spin(fruitMachine.getNumberOfFruits());
        fruitMachine.removeOldResults();
        assertEquals(0, fruitMachine.getResults().size());
    }

    @Test
    public void testCompareSymbolsAndReturnValue() throws Exception {
        FruitMachine spyMachine = Mockito.spy(new FruitMachine("Test", 100, 200, 1, 4));
        spyMachine.spin(fruitMachine.getNumberOfFruits());
        Mockito.when(spyMachine.compareSymbolsReturnWinnings()).thenReturn(9);
        assertEquals(9, spyMachine.compareSymbolsReturnWinnings());
    }

    @Test
    public void testPayout() throws Exception {
        FruitMachine spyMachine = Mockito.spy(new FruitMachine("Test", 100, 200, 1, 4));
        spyMachine.spin(fruitMachine.getNumberOfFruits());
        Mockito.when(spyMachine.compareSymbolsReturnWinnings()).thenReturn(9);
        int winnings = spyMachine.compareSymbolsReturnWinnings();
        spyMachine.payout(winnings);
        assertEquals(91, spyMachine.getFunds());
    }
}
