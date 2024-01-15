package main.java;

import main.java.TennisGame;

public class TennisGame1 implements TennisGame {
    private Player player1;
	private Player player2;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1 = new Player(player1Name);
		this.player2 = new Player(player2Name);
	}

	public void wonPoint(String playerName) {
		findPlayer(playerName).wonPoint();
	}

	public String getScore() {
		return TennisRule.instance.getScore(this.player1, this.player2);
	}
	
	public Player findPlayer(String playerName) {
		return this.player1.isEqualName(playerName)? this.player1 : this.player2;	
	}
}