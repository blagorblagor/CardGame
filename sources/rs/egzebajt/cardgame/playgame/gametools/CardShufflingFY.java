package rs.egzebajt.cardgame.playgame.gametools;

import java.util.ArrayList;
import rs.egzebajt.cardgame.playingcards.Card;

public class CardShufflingFY {
    
    private static CardShufflingFY cardShufflingFY = null;
    
    private CardShufflingFY() {
        //
    }
    
    public static CardShufflingFY GetCardShufflingFY() {
        if (CardShufflingFY.cardShufflingFY == null) {
            CardShufflingFY.cardShufflingFY = new CardShufflingFY();
        }
        return CardShufflingFY.cardShufflingFY;
    }
    
    //This method implements Fisher-Yates shuffle
    public void shuffleCards(ArrayList<Card> cards) {
        ArrayList<Card> cardsNewOrder = new ArrayList<>();
        
        int start = 1;
        int end = cards.size();
        for (int i = start; i <= end; i++) {
            int min = 1;
            int max = cards.size();
            int range = max - min + 1; 
            int randomIndex = (int)(Math.random() * range) + min; 
            cardsNewOrder.add(cards.get(randomIndex - 1));
            cards.remove(randomIndex - 1);
        }
        
        cards.addAll(cardsNewOrder);
    }
    
}
