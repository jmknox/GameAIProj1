package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import edu.ucsc.gameAI.IAction;

public class State implements IState  {

	IAction action;
	@Override
	public IAction getAction() {
		return action;
	}
	
	@Override
	public void setAction(IAction action) {
		this.action = action;
		
	}

	IAction entryAction;
	@Override
	public IAction getEntryAction() {
		return entryAction;
	}
	
	@Override
	public void setEntryAction(IAction action) {
		this.entryAction = action;
		
	}

	IAction exitAction;
	@Override
	public IAction getExitAction() {
		return exitAction;
	}
	
	@Override
	public void setExitAction(IAction action) {
		this.exitAction = action;
		
	}

	Collection<ITransition> transitions;
	@Override
	public Collection<ITransition> getTransitions() {
		return transitions;
	}

	@Override
	public void setTransitions(Collection<ITransition> trans) {
		this.transitions = trans;
		
	}

}
