package main.java;

public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    /*
    * Score results in Tennis
    * 0 = Love
    * 1 = Fifteen
    * 2 = Thirty
    * 3 = Forty
     */
    String[] scoreResults = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {

        if (isPlayer1(playerName))
            player1Score += 1;

        if (isPlayer2(playerName))
            player2Score += 1;
    }

    private boolean isPlayer1(String playerName) {
        return playerName.equals("player1");
    }

    private boolean isPlayer2(String playerName) {
        return playerName.equals("player2");
    }

    public String getScore() {

        if (isSameScore())
        {
            return getSameScoreResult();
        }

        if (isScoreMore4())
        {
            return getScoreMore4Result();
        }

        return getScoreUnder4Result();

    }

    private boolean isSameScore() {
        return player1Score == player2Score;
    }

    private String getSameScoreResult() {
        if(player1Score < 3)
            return scoreResults[player1Score] + "-All";

        return "Deuce";
    }

    private boolean isScoreMore4() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String getScoreMore4Result() {

        int scoreDiff = player1Score - player2Score;
        String winningPlayer = scoreDiff > 0 ? "player1" : "player2";

        if(Math.abs(scoreDiff) == 1)
            return "Advantage " + winningPlayer;

        return "Win for " + winningPlayer;
    }

    private String getScoreUnder4Result() {
        return scoreResults[player1Score] + "-" + scoreResults[player2Score];
    }

}
