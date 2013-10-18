package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class GhostEatScore implements ICondition{
	
	int mmin;
	int mmax;
	
	public GhostEatScore(int min, int max){
		mmin = min;
		mmax = max;
	}
	
	public boolean test(Game game){
		int eatScore = game.getGhostCurrentEdibleScore();
		return eatScore >= mmin && eatScore <= mmax;
	}
	
}
