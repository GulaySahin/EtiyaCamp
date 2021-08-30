package managers;

import entities.Offer;
import interfaces.OfferService;

public class OfferManager implements OfferService {
	
	@Override
	public void add(Offer offer) {
		System.out.println(offer.getName()+ " isimli kampanya sistemimize eklendi");
		
	}

	@Override
	public void remove(Offer offer) {
	
		System.out.println(offer.getName()+ " kampanyamýz sona ermiþtir.");
	}

}
