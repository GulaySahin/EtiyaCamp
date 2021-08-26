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
			System.out.println("Kullanıcı eklend i"+gamer.getFirstName());
			gamers.add(gamer);
		} else {
			System.out.println("Kullanıcı Yanlis kimlik numarasından eklenemedi :"+gamer.getFirstName());
		}

	}

	@Override
	public void update(Gamer gamer) {
		System.out.println("Kullanıcı güncellendi . : " + gamer.getFirstName());

	}

	@Override
	public void remove(Gamer gamer) {
		System.out.println("Kullanıcı silindi . : " + gamer.getFirstName());

	}

	public ArrayList<Gamer> getAllGames() {
		System.out.println(this.gamers);
		return this.gamers;

	}

	

}
