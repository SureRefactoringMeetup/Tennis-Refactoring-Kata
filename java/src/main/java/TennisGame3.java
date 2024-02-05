package main.java;

public class TennisGame3 implements TennisGame {
    
    private int player2Point;
    private int player1Point;
    private String player1Name;
    private String player2Name;
    String[] point = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        String scoreCall = "";

        if (isNormalScore()) {
            scoreCall = getNormalScoreCall();
        }
        if (isFinishableGame()) {
            scoreCall = getFinishableScoreCall();
        }

        return scoreCall;
    }

    private boolean isNormalScore() {
        return player1Point < 4 && player2Point < 4 && !(player1Point + player2Point == 6);
    }

    private String getNormalScoreCall() {
        if(player1Point == player2Point)
            return point[player1Point] + "-All";

        return point[player1Point] + "-" + point[player2Point];
    }

    private boolean isFinishableGame() {
        return !isNormalScore();
    }

    private String getFinishableScoreCall() {

        if (player1Point == player2Point)
            return "Deuce";

        String winPlayer = getWinPlayer();

        if(hasWinScore()){
            return "Win for " + winPlayer;
        }

        return "Advantage " + winPlayer;
    }

    private String getWinPlayer() {
        return player1Point > player2Point ? player1Name : player2Name;
    }

    private boolean hasWinScore() {
        return !((player1Point - player2Point) * (player1Point - player2Point) == 1);
    }

    public void wonPoint(String playerName) {
        //== 는 객체의 주소값을 비교하는 것이고, equals()는 객체의 값을 비교하는 것이다.
        // 아래의 문자열 "player1" 이라는 문자열과 playerName 이라는 문자열을 비교하는 것인데
        // == 을 사용해도 같은 결과를 얻을 수 있는 이유는 자바에서 문자열은 상수풀에 저장되기 때문이다.
        // 그렇기 때문에 playerName 이라는 문자열이 상수풀에 저장되어 있기 때문에 같은 주소값을 가지게 된다.
        if (playerName == "player1")
            this.player1Point += 1;
        else
            this.player2Point += 1;
        
    }

}
