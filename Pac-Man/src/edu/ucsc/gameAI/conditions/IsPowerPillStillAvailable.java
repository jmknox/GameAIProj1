package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class IsPowerPillStillAvailable implements ICondition{
	int iindex;
	
	public IsPowerPillStillAvailable(int index){
		iindex = index;
	}
	
	public boolean test(Game game){
		return game.isPowerPillStillAvailable(iindex);
	}
	
}
