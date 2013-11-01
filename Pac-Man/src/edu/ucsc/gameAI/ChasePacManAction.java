package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import pacman.game.Constants.GHOST;

public class ChasePacManAction implements IAction, IBinaryNode {
	
	private Game game;
	private GHOST gghost;

	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
	public ChasePacManAction(GHOST ghost){
		gghost = ghost;
	}
	
	public IAction makeDecision(Game game) {
		this.game = game;
		return this;
	}
	
	public MOVE getMove() {
		MOVE move = game.getApproximateNextMoveTowardsTarget(game.getGhostCurrentNodeIndex(gghost),
			game.getPacmanCurrentNodeIndex(),game.getGhostLastMoveMade(gghost),DM.PATH);
		return move;
	}
	
}