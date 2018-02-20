package com.imaginea.abm.ttt;

import java.util.List;

import com.imaginea.abm.Agent;
import com.imaginea.abm.AgentAction;
import com.imaginea.abm.Behaviour;
import com.imaginea.abm.action.GridAction;

public class StrategicBehaviour implements Behaviour {

	private final Agent[][] agentMap;
	private Agent agent;
	private Agent opponent;

	public StrategicBehaviour(Agent[][] agentMap) {
		if (agentMap.length != 3 || agentMap[0].length != 3) {
			throw new RuntimeException("This behaviour is only applicable for 3 X 3 map");
		}
		this.agentMap = agentMap;
	}

	public void setAgent(Agent agent) {
		if (this.agent != null) {
			return;
		}
		this.agent = agent;

	}

	public void setOpponent(Agent agent) {
		if (this.opponent != null) {
			return;
		}
		this.opponent = agent;

	}

	@Override
	public AgentAction selectAction(List<AgentAction> actions) {
		if (this.agent == null || this.opponent == null) {
			throw new RuntimeException("Plaese provide the player for this behaviour and its opponent");
		}

		// check if your game is completing in the next move
		for (int i = 0; i < agentMap.length; i++) {
			for (int j = 0; j < agentMap[i].length; j++) {
				if (agentMap[i][j] != null) {
					continue;
				}
				if (isRowCompleting(agent, i, j)) {
					return new GridAction(agent, i, j);
				}
				if (isColCompleting(agent, i, j)) {
					return new GridAction(agent, i, j);
				}
				if (isDiag1Completing(agent, i, j)) {
					return new GridAction(agent, i, j);
				}
				if (isDiag2Completing(agent, i, j)) {
					return new GridAction(agent, i, j);
				}
			}
		}

		// check if other's game is completing in the next move
		for (int i = 0; i < agentMap.length; i++) {
			for (int j = 0; j < agentMap[i].length; j++) {
				if (agentMap[i][j] != null) {
					continue;
				}
				if (isRowCompleting(opponent, i, j)) {
					return new GridAction(opponent, i, j);
				}
				if (isColCompleting(opponent, i, j)) {
					return new GridAction(opponent, i, j);
				}
				if (isDiag1Completing(opponent, i, j)) {
					return new GridAction(opponent, i, j);
				}
				if (isDiag2Completing(opponent, i, j)) {
					return new GridAction(opponent, i, j);
				}
			}
		}

		// random
		return actions.get((int) (actions.size() * Math.random()));

	}

	private boolean isDiag2Completing(Agent a, int x, int y) {
		if(x + y + 1 != 3) {
			return false;
		}
		int count = 0;
		for (int i = x - 2; i < x + 2; i++) {
			if (i < 0 || i >= agentMap.length) {
				continue;
			}
			int j = 2 - i;
			if (agentMap[i][j] != null && agentMap[i][j].equals(a)) {
				count++;
			}
		}
		return count > 1;
	}

	private boolean isDiag1Completing(Agent a, int x, int y) {
		if(x != y) {
			return false;
		}
		int count = 0;
		for (int i = x - 2; i < x + 2; i++) {
			if (i < 0 || i >= agentMap.length) {
				continue;
			}
			int j = i;
			if (agentMap[i][j] != null && agentMap[i][j].equals(a)) {
				count++;
			}
		}
		return count > 1;
	}

	private boolean isColCompleting(Agent a, int x, int y) {
		int count = 0;
		for (int i = x - 2; i < x + 2; i++) {
			if (i < 0 || i >= agentMap.length) {
				continue;
			}
			int j = y;
			if (agentMap[i][j] != null && agentMap[i][j].equals(a)) {
				count++;
			}
		}
		return count > 1;
	}

	private boolean isRowCompleting(Agent a, int x, int y) {
		int count = 0;
		for (int j = y - 2; j < y + 2; j++) {
			if (j < 0 || j >= agentMap.length) {
				continue;
			}
			int i = x;
			if (agentMap[i][j] != null && agentMap[i][j].equals(a)) {
				count++;
			}
		}
		return count > 1;
	}
	
	// getter methods
	// ------------------------------------------------------------------------

	public Agent[][] getAgentMap() {
		return agentMap.clone();
	}

}
