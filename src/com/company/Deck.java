package com.company;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

/**
 * Simulates a deck of cards
 */
class Deck {

    private Queue<Card> theDeck;

    Deck(){
        this.dealDeck();
    }

    void dealDeck(){
        LinkedList<Card> newDeck = new LinkedList<>();
        for(Suit suit: Suit.values()){
            for(int i=1; i<=13; i++){
                newDeck.add(new Card(i, suit));
            }
        }
        Collections.shuffle(newDeck);
        theDeck = newDeck;
    }

    Hand dealHand(){
        Hand newHand = new Hand();
        newHand.add(nextCard());
        newHand.add(nextCard());
        return newHand;
    };

    Card nextCard(){
        if(theDeck.element() == null){
            dealDeck();
        }
        Card nextCard = theDeck.poll();
        return nextCard;
    }

}
