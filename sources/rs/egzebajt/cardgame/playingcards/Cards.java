/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.egzebajt.cardgame.playingcards;

/**
 *
 * @author goran
 */
public abstract class Cards extends Card {
    
    protected abstract void SuitPondering();    
    protected abstract void CreateCards();
    public abstract int CompareTwoCards(Card card_1, Card card_2);
    
}
