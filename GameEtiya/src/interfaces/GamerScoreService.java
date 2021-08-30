package interfaces;

import entities.Gamer;
import entities.GamerScore;

public interface GamerScoreService {
	
	void levelUp(GamerScore gamerPlayed);
	
	
	void scoreCalculate(Gamer gamer);
	
	
    void getAll();
}
