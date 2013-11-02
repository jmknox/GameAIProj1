package edu.ucsc.gameAI.conditions;

import pacman.game.Constants.GHOST;
import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class OneGhostInRegion implements ICondition{
	
	int xx1;
	int xx2;
	int yy1;
	int yy2;
	GHOST gghost;
	
	public OneGhostInRegion(GHOST ghost, int x1, int y1, int x2, int y2){
		xx1 = x1;
		xx2 = x2;
		yy1 = y1;
		yy2 = y2;
		gghost = ghost;
	}

	@Override
	public boolean test(Game game) {
		int index = game.getGhostCurrentNodeIndex(gghost);
		int ghostX = game.getNodeXCood(index);
		int ghostY = game.getNodeYCood(index);
		
		return ghostX >= xx1 && ghostX <= xx2 && ghostY >= yy1 && ghostY <= yy2;
		
		
	}
		/*
		int ghostPos[] = {game.getGhostCurrentNodeIndex(GHOST.BLINKY),
						game.getGhostCurrentNodeIndex(GHOST.INKY),
						game.getGhostCurrentNodeIndex(GHOST.PINKY),
						game.getGhostCurrentNodeIndex(GHOST.SUE)};
		
		for(int i = 0; i <= 3; i++){
			int ghostX = game.getNodeXCood(ghostPos[i]);
			int ghostY = game.getNodeYCood(ghostPos[i]);
			if(ghostX >= xx1 && ghostX <= xx2 && ghostY >= yy1 && ghostY <= yy2) return true;
		}
		 
		return false;
	}
	*/

}
