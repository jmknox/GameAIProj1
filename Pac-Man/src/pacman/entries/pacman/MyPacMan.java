package pacman.entries.pacman;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.*;
import edu.ucsc.gameAI.fsm.*;
import edu.ucsc.gameAI.conditions.*;

import java.util.Collection;
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
		int current=game.getPacmanCurrentNodeIndex();
		int pacX = game.getNodeXCood(current);
		int pacY = game.getNodeYCood(current);
		
		//create fsm
		getPills = new State();
		getPills.setAction(new SeekPills());
		
		avoidGhosts = new State();
		avoidGhosts.setAction(new FleeGhosts());
		
		eatGhosts = new State();
		eatGhosts.setAction(new GoUpAction());
		
		transPills = new Transition();
		transPills.setCondition(new PillInRegion(pacX-10,pacY-10,pacX+10,pacY+10));
		transPills.setTargetState(getPills);
		listtpills = new LinkedList<ITransition>();
		listtpills.add(transPills);
		
		transAvoid = new Transition();
		transAvoid.setCondition(new GhostInRegion(pacX-1,pacY-1,pacX+1,pacY+1));
		transAvoid.setTargetState(avoidGhosts);
		listtavoid = new LinkedList<ITransition>();
		listtavoid.add(transAvoid);
		
		transEat = new Transition();
		transEat.setCondition(new PowerPillWasEaten());
		transEat.setTargetState(eatGhosts);
		listteat = new LinkedList<ITransition>();
		listteat.add(transEat);
		
		getPills.setTransitions(listtpills);
		avoidGhosts.setTransitions(listtavoid);
		eatGhosts.setTransitions(listteat);
		
		fsm = new StateMachine();
		fsm.setCurrentState(getPills);
		
		Collection<IAction> actions = fsm.update(game);
		if(actions.iterator().hasNext()) myMove = actions.iterator().next().getMove(game);
		System.out.println(myMove);
		
		return myMove;
	}
}