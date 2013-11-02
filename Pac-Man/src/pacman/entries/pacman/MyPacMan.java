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
	int prevlives = 3;
	
	private MOVE myMove=MOVE.NEUTRAL;
	
	public MyPacMan(){
		//create fsm
				getPills = new State();
				getPills.setName("getPills");
				getPills.setAction(new SeekPills());
				
				avoidGhosts = new State();
				avoidGhosts.setName("avoidGhosts");
				avoidGhosts.setAction(new FleeGhosts());
				//avoidGhosts.setEntryAction(new Reverse());
				
				eatGhosts = new State();
				eatGhosts.setName("eatGhosts");
				eatGhosts.setAction(new EatGhosts());
				
				//transition to get pills when pills in region and ghosts are not
				transPills = new Transition();
				transPills.setName("transPills");
				//transPills.setCondition(new AndCondition(new NotCondition(new GhostStillEdible()), 
				//										new NotCondition(new GhostInRegion(0,0,0,0))));
				transPills.setTargetState(getPills);
				transPills.setAction(new SeekPills());
			
				//transition to avoid ghosts when ghosts in area
				transAvoid = new Transition();
				transAvoid.setName("transAvoid");
				//transAvoid.setCondition(new AndCondition(new NotCondition(new GhostStillEdible()),
				//						new GhostInRegion(0,0,0,0)));
				transAvoid.setTargetState(avoidGhosts);
				transAvoid.setAction(new FleeGhosts());
				
				//transition to eat ghosts when ppill eaten
				transEat = new Transition();
				transEat.setName("transEat");
				transEat.setCondition(new PowerPillWasEaten());
				transEat.setTargetState(eatGhosts);
				transEat.setAction(new EatGhosts());
				
				listtpills = new LinkedList<ITransition>();
				listtavoid = new LinkedList<ITransition>();
				listteat = new LinkedList<ITransition>();
				
				listtpills.add(transAvoid);
				listtpills.add(transEat);
				listtavoid.add(transPills);
				listtavoid.add(transEat);
				listteat.add(transAvoid);
				listteat.add(transPills);
				
				getPills.setTransitions(listtpills);
				avoidGhosts.setTransitions(listtavoid);
				eatGhosts.setTransitions(listteat);
				
				fsm = new StateMachine();
				fsm.setCurrentState(getPills);
	}
	
	public MOVE getMove(Game game, long timeDue) 
	{
		if(prevlives > game.getPacmanNumberOfLivesRemaining()){
			fsm.setCurrentState(getPills);
			prevlives--; 
		}
		int current=game.getPacmanCurrentNodeIndex();
		int pacX = game.getNodeXCood(current);
		int pacY = game.getNodeYCood(current);
		
		transPills.setCondition(new AndCondition(new NotCondition(new GhostStillEdible()),
								new NotCondition(new GhostInRegion(pacX-6,pacY-6,pacX+6,pacY+6))));
		
		transAvoid.setCondition(new AndCondition(new NotCondition(new GhostStillEdible()),
								new GhostInRegion(pacX-6,pacY-6,pacX+6,pacY+6)));
		
		Collection<IAction> actions = fsm.update(game);
		if(actions.iterator().hasNext()) myMove = actions.iterator().next().getMove(game);
		
		return myMove;
	}
}