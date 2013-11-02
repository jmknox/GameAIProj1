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
	Transition eatToAvoid;
	
	StateMachine fsm;
	int prevlives = 3;
	
	private MOVE myMove=MOVE.NEUTRAL;
	
	public MyPacMan(){
		//create fsm
		//state where pacman searches for pills
		getPills = new State();
		getPills.setAction(new SeekPills());
		
		//state where pacman avoids ghosts
		avoidGhosts = new State();
		avoidGhosts.setAction(new FleeGhosts());
		
		//state where pacman searches and eats ghosts
		eatGhosts = new State();
		eatGhosts.setAction(new EatGhosts());
		
		//transition to get pills when pills in region and ghosts are not
		transPills = new Transition();
		transPills.setTargetState(getPills);
		transPills.setAction(new SeekPills());
	
		//transition to avoid ghosts when ghosts in area
		transAvoid = new Transition();
		transAvoid.setTargetState(avoidGhosts);
		transAvoid.setAction(new FleeGhosts());
		
		//transition to eat ghosts when ppill eaten
		transEat = new Transition();
		transEat.setCondition(new PowerPillWasEaten());
		transEat.setTargetState(eatGhosts);
		transEat.setAction(new EatGhosts());
		
		//transition to avoid when you are eating ghosts and an inedible ghost is in range
		eatToAvoid = new Transition();
		eatToAvoid.setTargetState(avoidGhosts);
		eatToAvoid.setAction(new FleeGhosts());
		
		listtpills = new LinkedList<ITransition>();
		listtavoid = new LinkedList<ITransition>();
		listteat = new LinkedList<ITransition>();
		
		listtpills.add(transAvoid);
		listtpills.add(transEat);
		listtavoid.add(transPills);
		listtavoid.add(transEat);
		listteat.add(eatToAvoid);
		listteat.add(transPills);
		
		getPills.setTransitions(listtpills);
		avoidGhosts.setTransitions(listtavoid);
		eatGhosts.setTransitions(listteat);
		
		fsm = new StateMachine();
		fsm.setCurrentState(getPills);
	}
	
	public MOVE getMove(Game game, long timeDue) 
	{
		//reset state to getpills when pacman dies
		if(prevlives > game.getPacmanNumberOfLivesRemaining()){
			fsm.setCurrentState(getPills);
			prevlives--; 
		}
		int current=game.getPacmanCurrentNodeIndex();
		int pacX = game.getNodeXCood(current);
		int pacY = game.getNodeYCood(current);
		
		//update the conditions with pacman's new position
		transPills.setCondition(new AndCondition(new NotCondition(new GhostStillEdible()),
								new NotCondition(new GhostInRegion(pacX-7,pacY-7,pacX+7,pacY+7))));
		
		transAvoid.setCondition(new AndCondition(new NotCondition(new GhostStillEdible()),
								new GhostInRegion(pacX-7,pacY-7,pacX+7,pacY+7)));
		
		eatToAvoid.setCondition(new NonEdibleGhostInRegion(pacX-7,pacY-7,pacX+7,pacY+7));
		
		Collection<IAction> actions = fsm.update(game);
		if(actions.iterator().hasNext()) myMove = actions.iterator().next().getMove(game);
		
		return myMove;
	}
}