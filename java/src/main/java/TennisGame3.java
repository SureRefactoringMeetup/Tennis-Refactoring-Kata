package main.java;

import main.java.TennisGame;

public class TennisGame3 implements TennisGame {
    String[] tennisScores = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
    
    private Player playerOne;
    private Player playerTwo;
    
    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOne = playerOneName;
        this.playerTwo = playerTwoName;
    }

    public String getScore() {
        if (isInPlayAndNotDeuce()) {
            return getTennisScore(playerOne) + "-" + (isDeuce()? "All" : getTennisScore(playerTwo));
        } else {
            if (isDeuce())
                return "Deuce";
            return (isAdvantage()? "Advantage " : "Win for ") + whoIsWinningPlayer();
        }
    }
    public void wonPoint(String playerName) {
        if (playerOne.isEqualName(playerName))
            playerOne.wonPoint();
        else
            playerTwo.wonPoint();
        
    }

    public boolean isInPlayAndNotDeuce() {
        return playerOne.getScore() < 4 && playerTwo.getScore() < 4 && !(playerOne.getScore() + playerTwo.getScore() == 6);
    }

    public boolean isDeuce() {
        return playerOne.getScore() == playerTwo.getScore();
    }
    
    public String whoIsWinningPlayer() {
        return playerOne.getScore() > playerTwo.getScore()? playerOne.getName() : playerTwo.getName();
    }

    public boolean isAdvantage() {
        return Math.abs(playerOne.getScore() - playerTwo.getScore()) == 1;
    }

    public String getTennisScore(Player player) {
        return tennisScores[player.getScore()];
    }

}
