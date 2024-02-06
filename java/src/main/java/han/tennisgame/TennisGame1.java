package han.tennisgame;

public class TennisGame1 implements TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) m_score1 += 1;
        else m_score2 += 1;
    }

    public String getScore() {
        return TennisScoreDelegator.getInstance()
                    .createTennisScoreHandler(this)
                    .getScoreResult(m_score1, m_score2);
    }
}
