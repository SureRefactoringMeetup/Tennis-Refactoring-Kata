package main.java;

public class TennisRule {
	static public TennisRule instance = new TennisRule();
	private final String ALL = "All";
	private final String HYPHEN = "-";
	
	public String getScore(Player player1, Player player2) {
		if(isDraw(player1, player2)) {
			return player1.getScore() == 3? "Deuce" : toStringScore(player1.getScore()) + HYPHEN + ALL;
		}
		
		if(isEndGame(player1, player2)) {
			return "Win for " + winningPlayer(player1, player2);  
		}
		
		if(isAdvantage(player1, player2)) {
			return "Advantage " + winningPlayer(player1, player2);
		}
		
		return toStringScore(player1.getScore()) + HYPHEN + toStringScore(player2.getScore());
	}
	
	public boolean isDraw(Player player1, Player player2) {
		return player1.getScore() == player2.getScore();
	}

	public boolean isOverScore(Player player1, Player player2) {
		return player1.getScore() >= 4 || player2.getScore() >= 4;
	}
	
	public boolean isEndGame(Player player1, Player player2) {
		return isOverScore(player1, player2) && Math.abs(player1.getScore() - player2.getScore()) >= 2;
	}
	
	public boolean isAdvantage(Player player1, Player player2) {
		return isOverScore(player1, player2) && Math.abs(player1.getScore() - player2.getScore()) == 1;
	}
	
	public String winningPlayer(Player player1, Player player2) { 
		return player1.getScore() > player2.getScore()? "player1" : "player2";
	}
	
	public String toStringScore(int score) {
		switch(score) {
			case 0:		return "Love";
			case 1:		return "Fifteen";
			case 2:		return "Thirty";
			case 3:		return "Forty";
			default:	return "";
		}
	}
}