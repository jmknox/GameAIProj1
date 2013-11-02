package edu.ucsc.gameAI;

import pacman.game.Constants.MOVE;
import pacman.game.Game;

public class Reverse implements IAction {

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
		MOVE prev = game.getPacmanLastMoveMade();
		if(prev == MOVE.RIGHT) return MOVE.LEFT;
		if(prev == MOVE.LEFT) return MOVE.RIGHT;
		if(prev == MOVE.UP) return MOVE.DOWN;
		if(prev == MOVE.DOWN) return MOVE.UP;
		return MOVE.NEUTRAL;
	}

}
