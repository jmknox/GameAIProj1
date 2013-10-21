package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class CurrentGhostNodeIndex implements ICondition{
	
	GHOST gghost;
	int iindex;

	
	public CurrentGhostNodeIndex(GHOST ghost, int index){
		gghost = ghost;
		iindex = index;

	}
	
	public boolean test(Game game){
		int ghostIndex = game.getGhostCurrentNodeIndex(gghost);
		return ghostIndex == iindex;
	}
	
}
