package entities;

public class GamerScore {
	
	private int id;
	private Gamer gamer;
	private Game game;
	private int ScoreCalculator;
	public GamerScore() {
		super();
	}
	public GamerScore(int id, Gamer gamer, Game game, int scoreCalculator) {
		super();
		this.id = id;
		this.gamer = gamer;
		this.game = game;
		this.ScoreCalculator = scoreCalculator;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Gamer getGamer() {
		return gamer;
	}
	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public int getScoreCalculator() {
		return ScoreCalculator;
	}
	public void setScoreCalculator(int scoreCalculator) {
		this.ScoreCalculator = scoreCalculator;
	};
	

}
