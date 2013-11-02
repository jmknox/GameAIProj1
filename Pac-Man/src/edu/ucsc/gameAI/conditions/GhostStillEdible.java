package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class GhostStillEdible implements ICondition {
	
	public GhostStillEdible(){
		
	}

	@Override
	public boolean test(Game game) {
		for(GHOST ghost: GHOST.values()){
			if(game.isGhostEdible(ghost)) return true;
		}
		
		return false;
	}

}
