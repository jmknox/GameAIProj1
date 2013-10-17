package edu.ucsc.gameAI.fsm;

import java.util.Collection;

import pacman.game.Game;
import edu.ucsc.gameAI.IAction;

public class StateMachine implements IStateMachine {
	// Holds a list of states for the machine
	IState states;
	
	// Holds the initial state
	IState initialState;
	
	// Holds the current state
	IState currentState = initialState;

	@SuppressWarnings("null")
	@Override
	public Collection<IAction> update(Game game) {
		// Assume no transition is triggered
		ITransition triggeredTransition = null;
		
		// Check through each transition and store the first one that triggers
		for(ITransition transition : currentState.getTransitions()){
			if(transition.isTriggered(game)){
				triggeredTransition = transition;
				break;
			}
		}
		
		Collection<IAction> actions = null;
		
		// Check if we have a transition to fire
		if(triggeredTransition != null){
			// Find the target state
			IState targetState = triggeredTransition.getTargetState();
			
			// Add the exit action of the old state, the transition action
			// and the entry for the new state	 
			actions.add(currentState.getExitAction());
			actions.add(triggeredTransition.getAction());
			actions.add(targetState.getEntryAction());
			
			//Complete the transition and return the action list
			currentState = targetState;
			return actions;
		}
		
		// Otherwise just return the current state's actions
		actions.add(currentState.getAction());
		return actions;
	}

	@Override
	public IState getCurrentState() {
		return currentState;
	}
	
	@Override
	public void setCurrentState(IState state) {
		currentState = state;
		
	}
	
}
