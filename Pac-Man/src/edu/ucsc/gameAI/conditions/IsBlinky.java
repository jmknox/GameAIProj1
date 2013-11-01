package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class IsBlinky implements ICondition {
	
	GHOST gghost;
	public IsBlinky(GHOST ghost)
	{
		gghost=ghost;
	}
	
	public boolean test(Game game) 
	{
		return gghost == GHOST.BLINKY;
	}
}
