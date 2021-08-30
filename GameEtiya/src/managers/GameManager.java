package managers;

import entities.Game;
import interfaces.GameService;

public class GameManager implements GameService {

	@Override
	public void add(Game game) {
		System.out.println(game.getName() +"isimli oyun sisteme eklendi");
		
	}

	@Override
	public void remove(Game game) {
		System.out.println(game.getName() +"isimli oyun sistemden silindi");		
	}

	@Override
	public void update(Game game) {
		System.out.println(game.getName() +"isimli oyun sistemde güncellendi");
		
	}

}
