package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class CurrentLevelTime implements ICondition{
	
	int mmax;
	int mmin;

	
	public CurrentLevelTime(int min, int max){
		mmax = max;
		mmin = min;

	}
	
	public boolean test(Game game){
		int time = game.getCurrentLevelTime();
		return time >= mmin && time <= mmax;
	}
	
}
