package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class CurrentPacmanNodeIndex implements ICondition{
	
	int iindex;

	
	public CurrentPacmanNodeIndex(int index){
		iindex = index;
	}
	
	public boolean test(Game game){
		int index = game.getPacmanCurrentNodeIndex();
		return index == iindex;
	}
	
}
