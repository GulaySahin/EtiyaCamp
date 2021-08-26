package services;

import entities.Game;
import entities.Gamer;
import entities.Offer;
import interfaces.SellingServiceManager;

public class SellingService implements SellingServiceManager {

	@Override
	public void sellGame(Gamer gamer, Game game,Offer offer) {
		
		System.out.println(gamer.getFirstName()+" adlý oyuncu "+game.getGameName()+" adlý oyunu"+offer.getOfferName()+" ile satýn aldý. ");
		
		
		
	}

}
