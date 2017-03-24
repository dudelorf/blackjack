package com.company;

import java.io.*;

public class Game {

    private BufferedReader in;
    private Deck theDeck;

    private Hand myHand;
    private Hand dealersHand;

    private boolean bust;
    boolean inProgress;

    Game(){
        in = new BufferedReader(new InputStreamReader(System.in));
        inProgress = true;
        theDeck = new Deck();
    }

    void doRound(){
        prepareRound();
        playerTurn();
        dealerTurn();
        concludeRound();
    }

    private void playerTurn() {
        String action = "";
        bust = false;
        do {
            System.out.println("My hand is:");
            System.out.println(myHand);
            do{
                System.out.println("Enter h to hit or s to stay:");
                try{
                    action = in.readLine();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }while(!action.equals("h") && !action.equals("s"));
            if(action.equals("h")){
                Card newCard = theDeck.nextCard();
                System.out.println("Your card is: " + newCard);
                myHand.add(newCard);
            }
        }while(myHand.scoreHand() <= 21 && !action.equals("s"));
        if(myHand.scoreHand() > 21){
            System.out.println("Bust!");
            bust = true;
        }
    }

    private void dealerTurn() {
        if(bust) return;
        while(dealersHand.scoreHand() < 18){
            Card nextCard = theDeck.nextCard();
            System.out.println("Dealer draws: " + nextCard);
            dealersHand.add(nextCard);
            System.out.println("Dealer's hand is:");
            System.out.println(dealersHand);
        }
        if(dealersHand.scoreHand() > 21){
			System.out.println("Dealer busts!");
		}else{
			System.out.println("Dealer stays.");
		}
    }

    private void prepareRound() {
        dealersHand = theDeck.dealHand();
        System.out.println("Dealer's hand is:");
        System.out.println(dealersHand);
        myHand = theDeck.dealHand();
    }

    private void concludeRound() {
        if(myHand.scoreHand() <= 21 && (myHand.scoreHand() > dealersHand.scoreHand() || dealersHand.scoreHand() > 21)){
            System.out.println("you win!");
        }else{
            System.out.println("Dealer wins, sukka!");
        }
        String response = "";
        do{
            System.out.println("Enter y to continue or n to quit");
            try {
                response = in.readLine();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }while(!response.equals("y") && !response.equals("n"));
        if(response.equals("n")) inProgress = false;
    }

}
