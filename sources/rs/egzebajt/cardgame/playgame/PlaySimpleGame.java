package rs.egzebajt.cardgame.playgame;

import java.util.ArrayList;
import rs.egzebajt.cardgame.playgame.gametools.CardShufflingFY;
import rs.egzebajt.cardgame.playingcards.Card;
import rs.egzebajt.cardgame.playingcards.CardsSimpleGame;

public class PlaySimpleGame extends PlayGame {
    
    CardsSimpleGame cardsSimpleGame;
    ArrayList<Card> cards;
    
    private final int NUMBER_OF_PLAYERS = 2; //Numbers of players may be changed in further implementation
    ArrayList<ArrayList<Card>> playersDrawPiles; 
    ArrayList<ArrayList<Card>> playersDiscardPiles;
    ArrayList<ArrayList<Card>> cardsOnDeck;
    
    public PlaySimpleGame() {
        this.playersDrawPiles = new ArrayList<>();        
        for (int i = 0; i < this.NUMBER_OF_PLAYERS; i++) {
            ArrayList<Card> pile = new ArrayList<>();
            this.playersDrawPiles.add(pile);
        }
        
        this.playersDiscardPiles = new ArrayList<>();
        for (int i = 0; i < this.NUMBER_OF_PLAYERS; i++) {
            ArrayList<Card> pile = new ArrayList<>();
            this.playersDiscardPiles.add(pile);
        }
        
        this.cardsOnDeck = new ArrayList<>();
        for (int i = 0; i < this.NUMBER_OF_PLAYERS; i++) {
            ArrayList<Card> pileOnDeck = new ArrayList<>();
            this.cardsOnDeck.add(pileOnDeck);
        }
    }
    
    public void playGame() {
        System.out.println("Game is started.");
        
        this.CreateCards();
        this.ShuffleCards();
        this.GiveCardsToEachPlayer();
        this.PlayersFighting();
        
        System.out.println("Game is over.");
    }
    
    @Override
    protected void CreateCards() {      
        this.cardsSimpleGame = new CardsSimpleGame();
        this.cards = this.cardsSimpleGame.getDeck();
        
        System.out.println("Cards are got.");
    }
    
    @Override
    protected void ShuffleCards() {
        CardShufflingFY cardShufflingFY = CardShufflingFY.GetCardShufflingFY();
        cardShufflingFY.shuffleCards(this.cards);
        
        System.out.println("Cards are shuffled.");
    }
    
    @Override
    protected void GiveCardsToEachPlayer() {        
        for (int i = (this.cards.size() - 1); i >= 0; i -= this.NUMBER_OF_PLAYERS) {
            for (int j = 0; j < this.NUMBER_OF_PLAYERS; j++) {
                this.playersDrawPiles.get(j).add(this.cards.get(i - j));
            }
        }
        
        System.out.println("Each player gets his own stack of cards");
    }

    @Override
    protected void PlayersFighting() {
        //Check whether the game is over and move cards from discard to draw pile if draw pile is empty. BEGINNING
        int numberOfPlayersWithoutCards = 0;
        ArrayList<Integer> numberOfCardsByPlayer = new ArrayList<>();
        for (int i = 0; i < this.NUMBER_OF_PLAYERS; i++) {
            int numberOfCards = this.playersDrawPiles.get(i).size() + this.playersDiscardPiles.get(i).size();
            numberOfCardsByPlayer.add(numberOfCards);
            
            if (numberOfCards > 0) {
                if (this.playersDrawPiles.get(i).isEmpty()) {
                    //Discard pile should be shuffled and get a place of draw pile which is ampty actually.
                    CardShufflingFY cardShufflingFY = CardShufflingFY.GetCardShufflingFY();
                    cardShufflingFY.shuffleCards(this.playersDiscardPiles.get(i));
                    
                    this.playersDrawPiles.get(i).addAll(this.playersDiscardPiles.get(i));
                    this.playersDiscardPiles.get(i).clear();
                }
            } else {
                numberOfPlayersWithoutCards++;
            }
        }
        
        if (numberOfPlayersWithoutCards == (this.NUMBER_OF_PLAYERS - 1)) {
            for (int i = 0; i < numberOfCardsByPlayer.size(); i++) {
                if (numberOfCardsByPlayer.get(i) > 0) {
                    System.out.println();
                    System.out.println("Player " + Integer.toString(i + 1) + " wins the game!");
                    break;
                }
            }
            return;
        }
        
        this.ExcludePlayersIfNeeded();
        //Check whether the game is over and move cards from discard to draw pile if draw pile is empty. END
        
        System.out.println();
        ArrayList<Card> cardsToBeCompared = new ArrayList<>();
        for (int i = 0; i < this.NUMBER_OF_PLAYERS; i++) {
            ArrayList<Card> discardPileCards = this.playersDiscardPiles.get(i);
            ArrayList<Card> drawPileCards = this.playersDrawPiles.get(i);
            
            Card cardOnDeck = drawPileCards.get(drawPileCards.size() - 1);
            this.cardsOnDeck.get(i).add(cardOnDeck);
            cardsToBeCompared.add(cardOnDeck);
            
            int numberOfCardAtPlayer = drawPileCards.size() + discardPileCards.size();
            System.out.println("Player " + Integer.toString(i + 1) + " ("  + Integer.toString(numberOfCardAtPlayer) + " cards): " + Integer.toString(cardOnDeck.getCardValue()));
            
            drawPileCards.remove(drawPileCards.size() - 1);
            
        }
        
        this.findRoundWinner(cardsToBeCompared);
        
        this.PlayersFighting(); //Method is salled recursivelly. That is, plaayers fight until some of them wins
    }
    
    private void ExcludePlayersIfNeeded() {        
        //TODO: When number of players is greater than 2, some workarround shoud be done here
        //A player which does not have cards must be excluded.
        //Actually, there is nothing to be done. There is only 2 players.
    }
    
    private void findRoundWinner(ArrayList<Card> cardsToBeCompared) {
        //TODO: Change the way of comparing when NUMBER_OF_PLAYERS has been changed
        
        Card card_1 = cardsToBeCompared.get(0);
        Card card_2 = cardsToBeCompared.get(1);
        int compareResult = this.cardsSimpleGame.CompareTwoCards(card_1, card_2);
        
        switch (compareResult) {
            case 1:
                System.out.println("Player 1 wins this round!");
                break;
            case 2:
                System.out.println("Player 2 wins this round!");                
                break;
            default:
                System.out.println("No player wins this round!");
                break;
        }
        
        if (compareResult > 0) {
            for (int i = 0; i < this.NUMBER_OF_PLAYERS; i++) {
                this.playersDiscardPiles.get(compareResult - 1).addAll(this.cardsOnDeck.get(i));
                this.cardsOnDeck.get(i).clear();
            }
        }
    }
    
}
