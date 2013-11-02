package pacman.entries.ghosts;

import java.util.EnumMap;


import pacman.controllers.Controller;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.conditions.*;
import edu.ucsc.gameAI.decisionTrees.binary.*;
import edu.ucsc.gameAI.*;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getActions() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.ghosts.mypackage).
 */
public class MyGhosts extends Controller<EnumMap<GHOST,MOVE>>
{
	
	//private GHOST gghost = GHOST.BLINKY;
	private EnumMap<GHOST, MOVE> myMoves=new EnumMap<GHOST, MOVE>(GHOST.class);
	BinaryDecision BisPacmanTop = new BinaryDecision();
	BinaryDecision BisBottom = new BinaryDecision();
	BinaryDecision BisTop = new BinaryDecision();
	BinaryDecision BisEdible = new BinaryDecision();
	BinaryDecision BisPacmanTopE = new BinaryDecision();
	BinaryDecision BisBottomE = new BinaryDecision();
	BinaryDecision BisTopE = new BinaryDecision();
	
	BinaryDecision IisPacmanTop = new BinaryDecision();
	BinaryDecision IisBottom = new BinaryDecision();
	BinaryDecision IisTop = new BinaryDecision();
	BinaryDecision IisEdible = new BinaryDecision();
	BinaryDecision IisPacmanTopE = new BinaryDecision();
	BinaryDecision IisBottomE = new BinaryDecision();
	BinaryDecision IisTopE = new BinaryDecision();
	
	BinaryDecision PisPacmanTop = new BinaryDecision();
	BinaryDecision PisBottom = new BinaryDecision();
	BinaryDecision PisTop = new BinaryDecision();
	BinaryDecision PisEdible = new BinaryDecision();
	BinaryDecision PisPacmanTopE = new BinaryDecision();
	BinaryDecision PisBottomE = new BinaryDecision();
	BinaryDecision PisTopE = new BinaryDecision();
	
	BinaryDecision SisPacmanTop = new BinaryDecision();
	BinaryDecision SisBottom = new BinaryDecision();
	BinaryDecision SisTop = new BinaryDecision();
	BinaryDecision SisEdible = new BinaryDecision();
	BinaryDecision SisPacmanTopE = new BinaryDecision();
	BinaryDecision SisBottomE = new BinaryDecision();
	BinaryDecision SisTopE = new BinaryDecision();
	


	

	public MyGhosts(){
		int ix1 = 0;
		int ix2 = 110;
		int iy1 = 0;
		int iy2 = 60;
		int iy3 = 120;
		
		//Blinky Tree
		BisPacmanTop.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		BisTop.setCondition(new OneGhostInRegion(GHOST.BLINKY,ix1,iy2+1,ix2,iy3));
		BisBottom.setCondition(new OneGhostInRegion(GHOST.BLINKY,ix1,iy2+1,ix2,iy3));
		BisEdible.setCondition(new IsEdible(GHOST.BLINKY));
		BisPacmanTopE.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		BisBottomE.setCondition(new OneGhostInRegion(GHOST.BLINKY,ix1,iy2+1,ix2,iy3));
		BisTopE.setCondition(new OneGhostInRegion(GHOST.BLINKY,ix1,iy2+1,ix2,iy3));

				
		BisEdible.setFalseBranch(BisPacmanTop);
		
		BisPacmanTop.setFalseBranch(BisBottom);
		BisPacmanTop.setTrueBranch(BisTop);
				
		BisBottom.setFalseBranch(new ChasePacManAction(GHOST.BLINKY));
		BisBottom.setTrueBranch(new ChasePacManAction(GHOST.BLINKY));	
		
		BisTop.setFalseBranch(new ChasePacManAction(GHOST.BLINKY));
		BisTop.setTrueBranch(new ChasePacManAction(GHOST.BLINKY));
		
		BisEdible.setTrueBranch(BisPacmanTopE);
		
		BisPacmanTopE.setFalseBranch(BisBottomE);
		BisPacmanTopE.setTrueBranch(BisTopE);		
		
		BisBottomE.setFalseBranch(new GoDownAction());
		BisBottomE.setTrueBranch(new EvadePacManAction(GHOST.BLINKY));
		
		BisTopE.setFalseBranch(new GoUpAction());
		BisTopE.setTrueBranch(new EvadePacManAction(GHOST.BLINKY));
		
		//Inky Tree
		IisPacmanTop.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		IisTop.setCondition(new OneGhostInRegion(GHOST.INKY,ix1,iy2+1,ix2,iy3));
		IisBottom.setCondition(new OneGhostInRegion(GHOST.INKY,ix1,iy2+1,ix2,iy3));
		IisEdible.setCondition(new IsEdible(GHOST.INKY));
		IisPacmanTopE.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		IisBottomE.setCondition(new OneGhostInRegion(GHOST.INKY,ix1,iy2+1,ix2,iy3));
		IisTopE.setCondition(new OneGhostInRegion(GHOST.INKY,ix1,iy2+1,ix2,iy3));

				
		IisEdible.setFalseBranch(IisPacmanTop);
		
		IisPacmanTop.setFalseBranch(IisBottom);
		IisPacmanTop.setTrueBranch(IisTop);
				
		IisBottom.setFalseBranch(new GoDownAction());
		IisBottom.setTrueBranch(new ChasePacManAction(GHOST.INKY));	
		
		IisTop.setFalseBranch(new GoUpAction());
		IisTop.setTrueBranch(new ChasePacManAction(GHOST.INKY));
		
		IisEdible.setTrueBranch(IisPacmanTopE);
		
		IisPacmanTopE.setFalseBranch(IisBottomE);
		IisPacmanTopE.setTrueBranch(IisTopE);		
		
		IisBottomE.setFalseBranch(new EvadePacManAction(GHOST.INKY));
		IisBottomE.setTrueBranch(new GoDownAction());
		
		IisTopE.setFalseBranch(new EvadePacManAction(GHOST.INKY));
		IisTopE.setTrueBranch(new GoUpAction());
		
		//PINKY Tree
		PisPacmanTop.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		PisTop.setCondition(new OneGhostInRegion(GHOST.PINKY,ix1,iy2+1,ix2,iy3));
		PisBottom.setCondition(new OneGhostInRegion(GHOST.PINKY,ix1,iy2+1,ix2,iy3));
		PisEdible.setCondition(new IsEdible(GHOST.PINKY));
		PisPacmanTopE.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		PisBottomE.setCondition(new OneGhostInRegion(GHOST.PINKY,ix1,iy2+1,ix2,iy3));
		PisTopE.setCondition(new OneGhostInRegion(GHOST.PINKY,ix1,iy2+1,ix2,iy3));

				
		PisEdible.setFalseBranch(PisPacmanTop);
		
		PisPacmanTop.setFalseBranch(PisBottom);
		PisPacmanTop.setTrueBranch(PisTop);
				
		PisBottom.setFalseBranch(new GoDownAction());
		PisBottom.setTrueBranch(new ChasePacManAction(GHOST.PINKY));	
		
		PisTop.setFalseBranch(new GoUpAction());
		PisTop.setTrueBranch(new ChasePacManAction(GHOST.PINKY));
		
		PisEdible.setTrueBranch(PisPacmanTopE);
		
		PisPacmanTopE.setFalseBranch(PisBottomE);
		PisPacmanTopE.setTrueBranch(PisTopE);		
		
		PisBottomE.setFalseBranch(new GoUpAction());
		PisBottomE.setTrueBranch(new EvadePacManAction(GHOST.PINKY));	
		
		PisTopE.setFalseBranch(new GoDownAction());
		PisTopE.setTrueBranch(new EvadePacManAction(GHOST.PINKY));
		
		//SUE Tree
		SisPacmanTop.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		SisTop.setCondition(new OneGhostInRegion(GHOST.SUE,ix1,iy2+1,ix2,iy3));
		SisBottom.setCondition(new OneGhostInRegion(GHOST.SUE,ix1,iy2+1,ix2,iy3));
		SisEdible.setCondition(new IsEdible(GHOST.SUE));
		SisPacmanTopE.setCondition(new PacmanInRegion(ix1,iy1,ix2,iy2));
		SisBottomE.setCondition(new OneGhostInRegion(GHOST.SUE,ix1,iy2+1,ix2,iy3));
		SisTopE.setCondition(new OneGhostInRegion(GHOST.SUE,ix1,iy2+1,ix2,iy3));

				
		SisEdible.setFalseBranch(SisPacmanTop);
		
		SisPacmanTop.setFalseBranch(SisBottom);
		SisPacmanTop.setTrueBranch(SisTop);
				
		SisBottom.setFalseBranch(new GoDownAction());	
		SisBottom.setTrueBranch(new ChasePacManAction(GHOST.SUE));	
		
		SisTop.setFalseBranch(new GoUpAction());	
		SisTop.setTrueBranch(new ChasePacManAction(GHOST.SUE));
		
		SisEdible.setTrueBranch(SisPacmanTopE);
		
		SisPacmanTopE.setFalseBranch(SisBottomE);
		SisPacmanTopE.setTrueBranch(SisTopE);		
		
		//SisBottomE.setFalseBranch(new GoUpAction());
		SisBottomE.setFalseBranch(new EvadePacManAction(GHOST.SUE));
		SisBottomE.setTrueBranch(new EvadePacManAction(GHOST.SUE));	
		
//		SisTopE.setFalseBranch(new GoDownAction());
		SisTopE.setFalseBranch(new EvadePacManAction(GHOST.SUE));
		SisTopE.setTrueBranch(new EvadePacManAction(GHOST.SUE));
		
	}

	public EnumMap<GHOST, MOVE> getMove(Game game, long timeDue){
	myMoves.clear();
		
	for(GHOST ghost : GHOST.values()){	//for each ghost
//		gghost = ghost;
		IAction action;
			if(game.doesGhostRequireAction(ghost)){	//if ghost requires an action
				if(ghost == GHOST.BLINKY){
					action = BisEdible.makeDecision(game);
				}
				else if(ghost == GHOST.INKY){
					action = IisEdible.makeDecision(game);
				}
				else if(ghost == GHOST.PINKY){
					action = PisEdible.makeDecision(game);
				}
				else{
					action = SisEdible.makeDecision(game);
				}
					myMoves.put(ghost, action.getMove());
			}
		}
		return myMoves;

	}
}