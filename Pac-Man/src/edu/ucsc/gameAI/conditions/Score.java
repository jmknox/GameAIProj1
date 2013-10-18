package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class Score implements ICondition{

	int mmin;
	int mmax;
	
	public Score(int min, int max){
		mmin = min;
		mmax = max;
	}
	
	public boolean test(Game game){
		int score = game.getScore();
		return score >= mmin && score <= mmax;
	}
	
}
