package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class OrCondition implements ICondition {
	ICondition conditionA;
	ICondition conditionB;
	
	public OrCondition(ICondition conditionA, ICondition conditionB){
		this.conditionA = conditionA;
		this.conditionB = conditionB;
	}
	
	@Override
	public boolean test(Game game) {
		return conditionA.test(game) || conditionB.test(game);
	}

}
