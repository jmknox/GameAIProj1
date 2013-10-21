package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class PillInRegion implements ICondition {
	
	int xx1;
	int xx2;
	int yy1;
	int yy2;
	
	public PillInRegion(int x1, int y1, int x2, int y2){
		xx1 = x1;
		xx2 = x2;
		yy1 = y1;
		yy2 = y2;
	}

	@Override
	public boolean test(Game game) {
		int pillIndices[] = game.getActivePillsIndices();
		for(int i = 0; i < pillIndices.length; i++){
			int pillX = game.getNodeXCood(pillIndices[i]); 
			int pillY = game.getNodeYCood(pillIndices[i]);
			if(pillX >= xx1 && pillX <= xx2 && pillY >= yy1 && pillY <= yy2) return true;
		}
		
		return false;
	}
	
}
