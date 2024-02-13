package main.java;

import main.java.TennisGame;

public class TennisGame3 implements TennisGame {

    // 변수명 알아보기 쉽게 변경
    // 남들이 봤을 때 한 번에 알 수 있어야 함
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;

        // 계산식을 함수로 별도로 분리
        // 무슨 계산식인지 다른 사람은 바로 알 수가 없음
        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            s = p[p1];
            
            // 계산식을 함수로 별도로 분리
            // 무슨 계산식인지 다른 사람은 바로 알 수가 없음
            return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
        } else {
            if (p1 == p2)
                return "Deuce";
            s = p1 > p2 ? p1N : p2N;
            // 계산식을 함수로 별도로 분리
            // 무슨 계산식인지 다른 사람은 바로 알 수가 없음
            return ((p1-p2)*(p1-p2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        // else 없애기
        // 조기 return을 쓰면 else 없어도 됨
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
