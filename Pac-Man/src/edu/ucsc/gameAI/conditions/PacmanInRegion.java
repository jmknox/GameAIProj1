package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PacmanInRegion implements ICondition{
	
	int xx1;
	int xx2;
	int yy1;
	int yy2;
	
	public PacmanInRegion(int x1, int y1, int x2, int y2){
		xx1 = x1;
		xx2 = x2;
		yy1 = y1;
		yy2 = y2;
	}

	@Override
	public boolean test(Game game) {
		int pacIndex = game.getPacmanCurrentNodeIndex();
		int pacX = game.getNodeXCood(pacIndex);
		int pacY = game.getNodeYCood(pacIndex);
		
		if(pacX >= xx1 && pacX <= xx2 && pacY >= yy1 && pacY <= yy2) return true;
		
		return false;
	}

}
