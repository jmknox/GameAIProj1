package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;

public class MazeIndex implements ICondition{
	int iindex;
	
	public MazeIndex(int index){
		iindex = index;
	}
	
	public boolean test(Game game){
		int index = game.getMazeIndex();
		return iindex == index;
	}
	
}
