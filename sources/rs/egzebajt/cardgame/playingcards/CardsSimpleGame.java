/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.egzebajt.cardgame.playingcards;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author goran
 */
public class CardsSimpleGame extends Cards {
    
    private final int MIN_CARD_VALUE = 1;
    private final int MAX_CARD_VALUE = 10; //Deck can be changed with shanging this value
    
    Map<CardSuit, Integer> suitsPonder; //Card suit is not implemented yet
    
    private final ArrayList<Card> cards;

    public ArrayList<Card> getDeck() {
        return this.cards;
    }
    
    public CardsSimpleGame() {
        this.cards = new ArrayList<>();
        this.GetCards();
    }
    
    private void GetCards() {
        this.SuitPondering();
        this.CreateCards();
    }

    @Override
    protected void SuitPondering() {
        //Card suit is not implemented yet.
    }

    @Override
    protected void CreateCards() {
        for (int i = this.MIN_CARD_VALUE; i <= this.MAX_CARD_VALUE; i++) {
            //Later, each of four cards, with the same value, will have one suite.
            //In meanwhile, a deck will contain four card with the same value and with undefined suit.
            for (int j = 1; j <= 4; j++) {
                Card card = new Card();
                card.cardValue = i;
                card.cardSuit = CardSuit.Undefined; //Card suit is not implemented yet.
                this.cards.add(card);
            }
        }
    }

    @Override
    public int CompareTwoCards(Card card_1, Card card_2) {
        int result = 0;        
        if (card_1.getCardValue() > card_2.getCardValue()) {
            result = 1;
        } else if (card_1.getCardValue() < card_2.getCardValue()) {
            result = 2;
        } else {
            //TODO: Now, cards suits should be compared, but that is not implemented yet.
            //Maybe, thar will be done in further implementation.
        }
        
        return result;
    }
    
}
