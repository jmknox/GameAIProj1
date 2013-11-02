package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class AndCondition implements ICondition {
	ICondition conditionA;
	ICondition conditionB;
	
	public AndCondition(ICondition conditionA, ICondition conditionB){
		this.conditionA = conditionA;
		this.conditionB = conditionB;
	}

	@Override
	public boolean test(Game game) {
		if(conditionA.test(game) && conditionB.test(game)){
			//System.out.println("true");
		}else{
			//System.out.println("false");
		}
		return conditionA.test(game) && conditionB.test(game);
	}

}
