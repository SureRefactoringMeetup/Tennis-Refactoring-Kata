package main.java;

public class Player {
	private int score = 0;
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public boolean isEqualName(String name) {
		return this.name.equals(name);
	}
	
	public void wonPoint() {
		this.score++;
	}
}