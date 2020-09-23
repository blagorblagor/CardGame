/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.egzebajt.cardgame.playgame;

/**
 *
 * @author goran
 */
public abstract class PlayGame {
    
    protected abstract void CreateCards();
    protected abstract void ShuffleCards();
    protected abstract void GiveCardsToEachPlayer();
    protected abstract void PlayersFighting();
    
}
