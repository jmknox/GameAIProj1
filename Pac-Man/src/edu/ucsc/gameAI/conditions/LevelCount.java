//help
package edu.ucsc.gameAI.conditions;

import edu.ucsc.gameAI.ICondition;
import pacman.game.Game;


public class LevelCount implements ICondition{

	int llevel;
	
	public LevelCount(int level){
		llevel = level;
	}
	
	public boolean test(Game game){
		return true;
	}
	
}
