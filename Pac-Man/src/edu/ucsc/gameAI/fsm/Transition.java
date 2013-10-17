package edu.ucsc.gameAI.fsm;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;
import edu.ucsc.gameAI.ICondition;

public class Transition implements ITransition {

	IState targetState;
	@Override
	public IState getTargetState() {
		return targetState;
	}
	
	@Override
	public void setTargetState(IState targetState) {
		this.targetState = targetState;
		
	}

	IAction actions;
	@Override
	public IAction getAction() {
		return actions;
	}

	@Override
	public void setAction(IAction action) {
		this.actions = action;
		
	}
	
	ICondition condition;
	@Override
	public void setCondition(ICondition condition) {
		this.condition = condition;
		
	}

	@Override
	public boolean isTriggered(Game game) {
		return condition.test(game);
	}

}
