package services;

import entities.Gamer;
import interfaces.MernisCheckService;

public class GamerCheckService implements MernisCheckService{

	@Override
	public boolean checkGamer(Gamer gamer) {
		if(gamer.getFirstName().equals("Gülay")) {
			
			return true;
		}else {
			
			return false;
		}
	}

}
