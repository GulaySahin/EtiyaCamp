package interfaces;

import entities.Game;
import entities.Gamer;
import entities.Offer;

public interface SellingServiceManager {
	
	void sellGame(Gamer gamer,Game game,Offer offer );

}
