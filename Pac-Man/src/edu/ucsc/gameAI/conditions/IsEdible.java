package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;


public class IsEdible implements ICondition {
	
	GHOST gghost;
	public IsEdible(GHOST ghost)
	{
		gghost=ghost;
	}
	
	public boolean test(Game game) 
	{
		return game.isGhostEdible(gghost);
	}
}
