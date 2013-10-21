package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class NumberOfLovesRemaining implements ICondition{
	
	int mmax;
	int mmin;

	
	public NumberOfLovesRemaining(int min, int max){
		mmax = max;
		mmin = min;

	}
	
	public boolean test(Game game){
		int lives = game.getPacmanNumberOfLivesRemaining();
		return lives >= mmin && lives <= mmax;
	}
	
}
