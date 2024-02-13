package han.tennisgame.handler;
import han.tennisgame.TennisTeam;

public interface TennisHandler {
    String getScoreResult(int score1, int score2);
    String getScoreResult(TennisTeam team1, TennisTeam team2);
}
