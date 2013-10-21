package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class EdibleTime implements ICondition{
	
	GHOST gghost;
	int mmin;
	int mmax;

	
	public EdibleTime(GHOST ghost, int min, int max){
		gghost = ghost;
		mmax = max;
		mmin = min;

	}
	
	public boolean test(Game game){
		int time = game.getGhostEdibleTime(gghost);
		return time >= mmin && time <= mmax;
	}
	
}
