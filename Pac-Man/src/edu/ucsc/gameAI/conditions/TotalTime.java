package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class TotalTime implements ICondition{

	int mmax;
	int mmin;
	
	public TotalTime(int min, int max){
		mmin = min;
		mmax = max;
	
	}
	
	public boolean test(Game game){
		int time = game.getTotalTime();
		return time >= mmin && time <=mmax;
	}
	
}
