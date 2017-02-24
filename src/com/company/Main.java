package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to blackjack!");
        Game theGame = new Game();
        while(theGame.inProgress){
            theGame.doRound();
        }
        System.out.println("Thanks for playing");
    }
}
