package rs.egzebajt.cardgame.playingcards;

public abstract class Cards extends Card {
    
    protected abstract void SuitPondering();    
    protected abstract void CreateCards();
    public abstract int CompareTwoCards(Card card_1, Card card_2);
    
}
