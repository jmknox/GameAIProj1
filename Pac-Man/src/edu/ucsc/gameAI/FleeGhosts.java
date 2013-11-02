package edu.ucsc.gameAI;

import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class FleeGhosts implements IAction, IBinaryNode {
	private static final int MIN_DISTANCE=20;	//if a ghost is this close, run away

	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MOVE getMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MOVE getMove(Game game) {
		//System.out.println("checking for ghost move");
		int current=game.getPacmanCurrentNodeIndex();
		
		//Strategy 1: if any non-edible ghost is too close (less than MIN_DISTANCE), run away
		for(GHOST ghost : GHOST.values())
			if(game.getGhostEdibleTime(ghost)==0 && game.getGhostLairTime(ghost)==0){
				//System.out.println("Ghost chasing");
				if(game.getShortestPathDistance(current,game.getGhostCurrentNodeIndex(ghost))<MIN_DISTANCE){
					//System.out.println("Ghost within distance");
					return game.getNextMoveAwayFromTarget(game.getPacmanCurrentNodeIndex(),game.getGhostCurrentNodeIndex(ghost),DM.PATH);
				}
			}
		return MOVE.NEUTRAL;
	}

}
