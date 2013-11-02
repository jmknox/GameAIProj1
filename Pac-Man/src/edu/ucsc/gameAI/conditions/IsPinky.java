package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class IsPinky implements ICondition {
	
	GHOST gghost;
	public IsPinky(GHOST ghost)
	{
		gghost=ghost;
	}
	
	public boolean test(Game game) 
	{
		return gghost == GHOST.PINKY;
	}
}
