package entities;

public class Gamer extends User {

	private int gameScore;

	public Gamer() {
		super();
	}

	public Gamer(int id, String name, String lastName, String identityNumber,String ageofYear, int gameScore) {
		super();
		this.gameScore = gameScore;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}
	
}
