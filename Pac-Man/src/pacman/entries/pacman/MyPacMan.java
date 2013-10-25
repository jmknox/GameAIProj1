package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;

import edu.ucsc.gameAI.fsm.*;
import edu.ucsc.gameAI.conditions.*;

import java.util.LinkedList;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	State getPills;
	State avoidGhosts;
	State eatGhosts;
	Transition transPills;
	LinkedList<ITransition> listtpills;
	Transition transAvoid;
	LinkedList<ITransition> listtavoid; 
	Transition transEat;
	LinkedList<ITransition> listteat;
	StateMachine fsm;
	
	private MOVE myMove=MOVE.NEUTRAL;
	
	public MOVE getMove(Game game, long timeDue) 
	{
		//create fsm
		getPills = new State();
		getPills.setAction(null);
		
		avoidGhosts = new State();
		avoidGhosts.setAction(null);
		
		eatGhosts = new State();
		eatGhosts.setAction(null);
		
		transPills = new Transition();
		transPills.setCondition(null);
		transPills.setTargetState(getPills);
		listtpills = new LinkedList<ITransition>();
		listtpills.add(transPills);
		
		transAvoid = new Transition();
		transAvoid.setCondition(new GhostInRegion(20,20,20,20));
		transAvoid.setTargetState(avoidGhosts);
		listtavoid = new LinkedList<ITransition>();
		listtavoid.add(transAvoid);
		
		transEat = new Transition();
		transEat.setCondition(new PowerPillWasEaten());
		transEat.setTargetState(eatGhosts);
		listteat = new LinkedList<ITransition>();
		listteat.add(transEat);
		
		fsm = new StateMachine();
		fsm.setCurrentState(getPills);
		
		return myMove;
	}
}