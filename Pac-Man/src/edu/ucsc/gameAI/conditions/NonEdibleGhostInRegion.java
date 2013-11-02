package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;
import pacman.game.Constants.GHOST;

public class NonEdibleGhostInRegion implements ICondition {
	int xx1;
	int xx2;
	int yy1;
	int yy2;
	
	public NonEdibleGhostInRegion(int x1, int y1, int x2, int y2){
		xx1 = x1;
		xx2 = x2;
		yy1 = y1;
		yy2 = y2;
	}
	
	@Override
	public boolean test(Game game) {
		int ghostPos[] = {game.getGhostCurrentNodeIndex(GHOST.BLINKY),
						game.getGhostCurrentNodeIndex(GHOST.INKY),
						game.getGhostCurrentNodeIndex(GHOST.PINKY),
						game.getGhostCurrentNodeIndex(GHOST.SUE)};
		
		GHOST ghost[] = {GHOST.BLINKY, GHOST.INKY, GHOST.PINKY, GHOST.SUE};
		
		for(int i = 0; i <= 3; i++){
			int ghostX = game.getNodeXCood(ghostPos[i]);
			int ghostY = game.getNodeYCood(ghostPos[i]);
			if(ghostX >= xx1 && ghostX <= xx2 && ghostY >= yy1 && ghostY <= yy2)
				if(!game.isGhostEdible(ghost[i])) return true;
		}
		 
		return false;
	}
	
}
