package managers;

import entities.Gamer;
import interfaces.GamerService;
import interfaces.UserIdentityValidatorService;

public class GamerManager implements GamerService{
    UserIdentityValidatorService userIdentityValidatorService;
    
    public GamerManager(UserIdentityValidatorService userIdentityValidatorService) {
    	this.userIdentityValidatorService=userIdentityValidatorService;
    }
	@Override
	public void add(Gamer gamer) {
		
		System.out.println(gamer.getName()+" isimli oyuncu sisteme eklendi");
		
	}

	@Override
	public void remove(Gamer gamer) {
		

		System.out.println(gamer.getName()+" isimli oyuncu sistemden silindi");
	}

	@Override
	public void update(Gamer gamer) {

		System.out.println(gamer.getName()+" isimli oyuncu bilgileri sistemde güncellendi");
		
	}

}
