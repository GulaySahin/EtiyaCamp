package managers;

import entities.Game;
import entities.Gamer;
import entities.Offer;
import entities.Selling;
import interfaces.SellingService;

public class SellingManager implements SellingService{

	@Override
	public void add(Game game,Gamer gamer,Offer offer) {
		System.out.println(game.getName()+ " isimli oyun "+gamer.getName()+" isimli oyuncu tarafýndan "+
	offer.getName()+" kampanyasýyla satýn alýndý");
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Selling selling) {
		// TODO Auto-generated method stub
		
	}


}
