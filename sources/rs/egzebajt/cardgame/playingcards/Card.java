package rs.egzebajt.cardgame.playingcards;

public class Card {
    
    //Card suit is not implemented yet.
    //Only CardSuit.Undefined is in use.
    public enum CardSuit {
        Undefined,
        Club, 
        Spade, 
        Heart, 
        Diamond
    }
    
    protected int cardValue;
    protected CardSuit cardSuit;

    public int getCardValue() {
        return cardValue;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }
    
}
