package com.imaginea.abm.ttt;

import java.util.List;

import com.imaginea.abm.Agent;
import com.imaginea.abm.AgentAction;
import com.imaginea.abm.Behaviour;
import com.imaginea.abm.action.GridAction;

public class StrategicBehaviour implements Behaviour {

	private final Agent[][] agentMap;

	public StrategicBehaviour(Agent[][] agentMap) {
		this.agentMap = agentMap;
	}

	@Override
	public AgentAction selectAction(List<AgentAction> actions) {
		int minCount = Integer.MAX_VALUE;
		int posI = -1;
		int posJ = -1;

		for (int i = 0; i < agentMap.length; i++) {
			int count = 0;
			int loc = -1;
			for (int j = 0; j < agentMap[i].length; j++) {
				count += agentMap[i][j] == null ? 1 : 0;
				loc = agentMap[i][j] == null ? j : loc;
			}
			if (minCount > count && count > 0) {
				minCount = count;
				posI = i;
				posJ = loc;
			}
		}

		for (int j = 0; j < agentMap[0].length; j++) {
			int count = 0;
			int loc = -1;
			for (int i = 0; i < agentMap.length; i++) {
				count += agentMap[i][j] == null ? 1 : 0;
				loc = agentMap[i][j] == null ? j : loc;
			}
			if (minCount > count && count > 0) {
				minCount = count;
				posJ = j;
				posI = loc;
			}
		}

		int countDiagonal1 = 0;
		int locDiagonal1 = -1;
		for (int i = 0; i < agentMap.length; i++) {
			countDiagonal1 += agentMap[i][i] == null ? 1 : 0;
			locDiagonal1 = agentMap[i][i] == null ? i : locDiagonal1;
		}
		if (minCount > countDiagonal1 && countDiagonal1 > 0) {
			minCount = countDiagonal1;
			posI = locDiagonal1;
			posJ = locDiagonal1;
		}

		int countDiagonal2 = 0;
		int locDiagonal2 = -1;
		for (int i = 0; i < agentMap.length; i++) {
			int j = agentMap.length - 1 - i;
			countDiagonal2 += agentMap[i][j] == null ? 1 : 0;
			locDiagonal2 = agentMap[i][j] == null ? i : locDiagonal2;
		}
		if (minCount > countDiagonal2 && countDiagonal2 > 0) {
			minCount = countDiagonal2;
			posI = locDiagonal2;
			posJ = agentMap.length - 1 - locDiagonal2;
		}

		final int I = posI, J = posJ;

		System.out.println(String.format("[StrategicBehaviour:: min: %s | I: %s | J: %s]", minCount, I, J));

		return actions.stream().filter(a -> {
			GridAction action = (GridAction) a;
			int col = action.getCol();
			int row = action.getRow();
			return col == J && row == I;
		}).findFirst().orElse(actions.get((int) (actions.size() * Math.random())));
	}

	// getter methods
	// ------------------------------------------------------------------------

	public Agent[][] getAgentMap() {
		return agentMap.clone();
	}

}
