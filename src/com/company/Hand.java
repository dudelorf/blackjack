package com.company;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class that simulaes a hand of cards
 */
public class Hand {

    private List<Card> theHand;

    Hand(){
        theHand = new ArrayList<>();
    }

    void add(Card newCard){
        theHand.add(newCard);
    }

    int scoreHand(){
        int score = 0;
        List<Card> aces = new ArrayList<>(4);
        for(Card nextCard : theHand){
            if(nextCard.getValue() == 1){
                aces.add(nextCard);
            }else if(nextCard.getValue() > 10){
                score += 10;
            }else{
                score += nextCard.getValue();
            }
        }
        Iterator<Card> acesIterator = aces.iterator();
        while(acesIterator.hasNext()){
            acesIterator.next();
            if(score + 10 >= 21 && acesIterator.hasNext()){
                score += 1;
            }else if(score + 10 < 21){
                score += 10;
            }else{
                score += 1;
            }
        }
        return score;
    }

    public String toString(){
        StringWriter writer = new StringWriter();
        for(Card nextCard : theHand){
            writer.write(nextCard.toString() + "\n");
        }
        return writer.toString();
    }
}
