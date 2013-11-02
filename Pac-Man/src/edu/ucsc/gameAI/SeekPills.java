package edu.ucsc.gameAI;

import java.util.ArrayList;

import pacman.game.Constants.DM;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import edu.ucsc.gameAI.decisionTrees.binary.IBinaryNode;

public class SeekPills implements IAction, IBinaryNode {

	@Override
	public IAction makeDecision(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MOVE getMove() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public MOVE getMove(Game game) {
		int current=game.getPacmanCurrentNodeIndex();
		
		int[] pills=game.getPillIndices();
		int[] powerPills=game.getPowerPillIndices();		
		
		ArrayList<Integer> targets=new ArrayList<Integer>();
		
		for(int i=0;i<pills.length;i++)					//check which pills are available			
			if(game.isPillStillAvailable(i))
				targets.add(pills[i]);
		
		for(int i=0;i<powerPills.length;i++)			//check with power pills are available
			if(game.isPowerPillStillAvailable(i))
				targets.add(powerPills[i]);				
		
		int[] targetsArray=new int[targets.size()];		//convert from ArrayList to array
		
		for(int i=0;i<targetsArray.length;i++)
			targetsArray[i]=targets.get(i);
		
		MOVE mmove = game.getNextMoveTowardsTarget(current,game.getClosestNodeIndexFromNodeIndex(current,targetsArray,DM.PATH),DM.PATH);
		//if(mmove == MOVE.UP && )
		
		//return the next direction once the closest target has been identified
		return mmove;
	}
	

}
