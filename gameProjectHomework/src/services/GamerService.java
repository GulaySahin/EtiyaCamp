package services;

import java.util.ArrayList;

import entities.Gamer;
import interfaces.GamerServiceManager;

public class GamerService implements GamerServiceManager {
	GamerCheckService checkGamer2;
	ArrayList<Gamer> gamers;

	public GamerService(GamerCheckService checkGamer) {

		gamers = new ArrayList<Gamer>();
		this.checkGamer2 = checkGamer;
	}

	@Override
	public void add(Gamer gamer) {
		
		if (this.checkGamer2.checkGamer(gamer)) {
			System.out.println(gamer.getFirstName()+" person added. ");
			gamers.add(gamer);
		} else {
			System.out.println("Unable to add user information because incorrect :"+gamer.getFirstName());
		}

	}

	@Override
	public void update(Gamer gamer) {
		System.out.println("updated contact  : " + gamer.getFirstName());

	}

	@Override
	public void remove(Gamer gamer) {
		System.out.println("remove contact  : " + gamer.getFirstName());

	}

	public ArrayList<Gamer> getAllGames() {
		System.out.println(this.gamers);
		return this.gamers;

	}

	

}
