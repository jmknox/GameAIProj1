package edu.ucsc.gameAI.conditions;

import pacman.game.Game;
import edu.ucsc.gameAI.ICondition;

public class NotCondition implements ICondition {

	ICondition condition;
	
	public NotCondition(ICondition condition){
		this.condition = condition;
	}
	
	@Override
	public boolean test(Game game) {
		return !condition.test(game);
	}

}
