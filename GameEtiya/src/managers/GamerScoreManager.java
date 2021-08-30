package managers;
import java.time.LocalDate;

import entities.Gamer;
import entities.GamerScore;
import interfaces.GamerScoreService;

public class GamerScoreManager implements GamerScoreService {
	LocalDate timenow = LocalDate.now();
   
	@Override
	public void levelUp(GamerScore gamerPlayed) {
		System.out.println("level atlandý");
	}

	@Override
	public void scoreCalculate(Gamer gamer ) {
		int diffAge = gamer.getAgeofYear() - timenow.getYear();
	if(diffAge>70) {
	double score=gamer.getGameScore()+90;
	System.out.println(gamer.getName()+" oyuncusunun rekoru: "+score);

	
	} else if(diffAge<18) {
		double score=gamer.getGameScore()+100;
		System.out.println(gamer.getName()+" oyuncusunun rekoru: "+score);
	} else {
	double score=gamer.getGameScore()+70;
	System.out.println(gamer.getName()+" oyuncusunun rekoru: "+score);
	
	}
	}
	@Override
	public void getAll() {
		System.out.println("Listelendi");
		
	}
	
}


