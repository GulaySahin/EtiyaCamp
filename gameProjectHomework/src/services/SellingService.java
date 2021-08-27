package services;

import entities.Game;
import entities.Gamer;
import entities.Offer;
import interfaces.SellingServiceManager;

public class SellingService implements SellingServiceManager {

	@Override
	public void sellGame(Gamer gamer, Game game,Offer offer) {
		
		System.out.println(gamer.getFirstName()+" user named"	+ " "+game.getGameName()+"game "+offer.getOfferName()+" with the bought . ");
		
		
		
	}

}
