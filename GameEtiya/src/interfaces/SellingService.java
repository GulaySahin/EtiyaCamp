package interfaces;

import entities.Game;
import entities.Gamer;
import entities.Offer;
import entities.Selling;


public interface SellingService {
	
	void getAll();
	
	void update(Selling selling);

	void add(Game game,Gamer gamer,Offer offer);

}
