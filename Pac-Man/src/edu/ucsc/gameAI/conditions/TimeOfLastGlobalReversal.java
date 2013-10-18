package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class TimeOfLastGlobalReversal implements ICondition{
	
	int mmin;
	int mmax;
	
	public TimeOfLastGlobalReversal(int min, int max){
		mmin = min;
		mmax = max;
	}
	
	public boolean test(Game game){
		int time = game.getTimeOfLastGlobalReversal();
		return time >= mmin && time <= mmax;
	}
	
}
