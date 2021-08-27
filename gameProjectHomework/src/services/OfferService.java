package services;

import interfaces.OfferServiceManager;

public class OfferService implements OfferServiceManager{

	@Override
	public void add() {
		System.out.println(" Campaign added. ");
		
	}

	@Override
	public void update() {
		System.out.println(" Campaign updated. ");
		
	}

	@Override
	public void remove() {
		System.out.println("The campaign has been deleted from the system.");
		
	}

}
