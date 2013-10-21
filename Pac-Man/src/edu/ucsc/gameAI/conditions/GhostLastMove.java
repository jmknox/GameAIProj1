package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.MOVE;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class GhostLastMove implements ICondition{
	
	GHOST gghost;
	MOVE mmove;

	
	public GhostLastMove(GHOST ghost, MOVE move){
		gghost = ghost;
		mmove = move;

	}
	
	public boolean test(Game game){
		MOVE move = game.getGhostLastMoveMade(gghost);
		return move == mmove;
	}
	
}
