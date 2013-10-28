package edu.ucsc.gameAI;

import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;
import pacman.game.Game;
import pacman.game.Constants.MOVE;

public class GoUpAction implements IAction, IBinaryNode {

	public void doAction() {
		// TODO Auto-generated method stub
		
	}
	
	public IAction makeDecision(Game game) {return this;}
	
	public MOVE getMove() {return MOVE.UP;}

	@Override
	public MOVE getMove(Game game) {
		// TODO Auto-generated method stub
		return null;
	}
	
}