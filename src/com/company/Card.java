package com.company;

/**
 * Encapsulates Card details
 */
class Card {

    private int value;
    private Suit suit;

    Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        return getValueString(value) + " of " + getSuitString(suit);
    }

    private String getValueString(int val){
        switch(val){
            case 1:
                return "Ace";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return String.valueOf(val);
        }
    }

    private String getSuitString(Suit suit){
        switch(suit){
            case HEARTS:
                return "Hearts";
            case SPADES:
                return "Spades";
            case CLUBS:
                return "Clubs";
            case DIAMONDS:
                return "Diamonds";
            default:
                return "Unknown suit";
        }
    }
}