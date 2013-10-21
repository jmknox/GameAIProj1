package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Constants.GHOST;
import pacman.game.Game;

public class LairTime implements ICondition{
	
	GHOST gghost;
	int mmin;
	int mmax;

	
	public LairTime(GHOST ghost, int min,int max){
		gghost = ghost;
		mmin = min;
		mmax = max;
	}
	
	public boolean test(Game game){
		int time = game.getGhostLairTime(gghost);
		return time >= mmin && time <= mmax;
	}
	
}
