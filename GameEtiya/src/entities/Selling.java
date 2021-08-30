package entities;

public class Selling {
  private int id;
  private Game game;
  private Gamer gamer;
  private Offer offer;
public Selling() {
	super();
}
public Selling(int id, Game game, Gamer gamer, Offer offer) {
	super();
	this.id = id;
	this.game = game;
	this.gamer = gamer;
	this.offer = offer;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Game getGame() {
	return game;
}
public void setGame(Game game) {
	this.game = game;
}
public Gamer getGamer() {
	return gamer;
}
public void setGamer(Gamer gamer) {
	this.gamer = gamer;
}
public Offer getOffer() {
	return offer;
}
public void setOffer(Offer offer) {
	this.offer = offer;
}
  


}
