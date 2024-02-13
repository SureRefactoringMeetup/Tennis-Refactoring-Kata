package han.tennisgame;

import han.tennisgame.handler.TennisHandlerImpl;
import han.tennisgame.handler.multi.TennisMultiScoreHandlerV1;
import han.tennisgame.handler.v1.TennisGetScoreHandlerV1;
import han.tennisgame.handler.v3.TennisGetScoreHandlerV3;

public class TennisScoreDelegator{
    private TennisHandlerImpl tennisHandler;
    private static TennisScoreDelegator instance;
    public static TennisScoreDelegator getInstance(){
        return instance == null ?
                new TennisScoreDelegator() :
                instance;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGame1 tennisGame1) {
        tennisHandler = new TennisGetScoreHandlerV1(tennisGame1);
        return this;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGame3 tennisGame3) {
        tennisHandler = new TennisGetScoreHandlerV3(tennisGame3);
        return this;
    }
    public TennisScoreDelegator createTennisScoreHandler(TennisGameMulti tennisGameMulti) {
        tennisHandler = new TennisMultiScoreHandlerV1(tennisGameMulti);
        return this;
    }
    public String getScore(int score1, int score2) {
        return tennisHandler.getScoreResult(score1, score2);
    }
    public String getScore(TennisTeam team1, TennisTeam team2) {
        return tennisHandler.getScoreResult(team1, team2);
    }
}
