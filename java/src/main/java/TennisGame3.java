package main.java;

import main.java.TennisGame;

public class TennisGame3 implements TennisGame {
    String[] tennisScores = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 

    private Player player1;
    private Player player2;

    public TennisGame3(String playerName1, String playerName2) {
        this.player1 = new Player(playerName1);
        this.player2 = new Player(playerName2);
    }

    public String getScore() {
        if (isInPlayAndNotDeuce()) {
            return getTennisScore(player1) + "-" + (isDraw()? "All" : getTennisScore(player2));
        } else {
            if (isDraw())
                return "Deuce";
            return (isAdvantage()? "Advantage " : "Win for ") + whoIsWinningPlayer();
        }
    }
    
    public void wonPoint(String playerName) {
        if (player1.isEqualName(playerName))
            player1.wonPoint();
        else
            player2.wonPoint();
        
    }

    public boolean isInPlayAndNotDeuce() {
        return player1.getScore() < 4 && player2.getScore() < 4 && !(player1.getScore() + player2.getScore() == 6);
    }

    public boolean isDraw() {
        return player1.getScore() == player2.getScore();
    }
    
    public String whoIsWinningPlayer() {
        return player1.getScore() > player2.getScore()? player1.getName() : player2.getName();
    }

    public boolean isAdvantage() {
        return (player1.getScore()-player2.getScore())*(player1.getScore()-player2.getScore()) == 1;
    }

    public String getTennisScore(Player player) {
        return tennisScores[player.getScore];
    }
}
