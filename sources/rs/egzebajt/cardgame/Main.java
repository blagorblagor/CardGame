package rs.egzebajt.cardgame;

import rs.egzebajt.cardgame.playgame.PlaySimpleGame;

public class Main {

    public static void main(String[] args) {
        if (args[0].compareTo("-simplegame") == 0) {
            PlaySimpleGame playSimpleGame = new PlaySimpleGame();
            playSimpleGame.playGame();
        } 
        //TODO: Add else if controls when other games have been implemented
        else {
            System.out.println("Game " + args[0] + " is not supported.");
        }
    }
    
}
