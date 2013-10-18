package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class IsPillStillAvailable implements ICondition{
	int ppillindex;
	
	public IsPillStillAvailable(int pillindex){
		ppillindex = pillindex;
	}
	
	public boolean test(Game game){
		return game.isPillStillAvailable(ppillindex);
	}
	
}
