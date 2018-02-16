package com.imaginea.abm.ttt;

import com.imaginea.abm.Agent;
import com.imaginea.abm.Environment;
import com.imaginea.abm.EnvironmentCompleteLogic;
import com.imaginea.abm.EnvironmentResult;
import com.imaginea.abm.environment.EnvironmentResultFactory;
import com.imaginea.abm.environment.GridEnvironment;

public class TicTacToeCompleteLogic implements EnvironmentCompleteLogic {

	private Agent winner = null;
	private Agent loser = null;

	@Override
	public boolean done(Environment environment) {
		GridEnvironment gridEnvironment = (GridEnvironment) environment;
		Agent[][] agentMap = gridEnvironment.getAgentMap();
		Agent[] agents = environment.getAgents();

		Agent agent1 = agents[0];
		Agent agent2 = agents[1];

		// horizontal check
		for (int i = 0; i < agentMap.length; i++) {
			Agent checkAgent = agentMap[i][0];
			int count = 0;
			for (int j = 0; j < agentMap[i].length; j++) {
				if (checkAgent != null && agentMap[i][j] != null && checkAgent.equals(agentMap[i][j])) {
					count++;
				}
			}
			if (count == agentMap[i].length) {
				winner = checkAgent;
				loser = agent1 == winner ? agent2 : agent1;
				return true;
			}
		}

		// vertical check
		for (int j = 0; j < agentMap[0].length; j++) {
			Agent checkAgent = agentMap[0][j];
			int count = 0;
			for (int i = 0; i < agentMap.length; i++) {
				if (checkAgent != null && agentMap[i][j] != null && checkAgent.equals(agentMap[i][j])) {
					count++;
				}
			}
			if (count == agentMap.length) {
				winner = checkAgent;
				loser = agent1 == winner ? agent2 : agent1;
				return true;
			}
		}

		// diagonal check
		Agent checkAgentDiagonal1 = agentMap[0][0];
		int countDiagonal1 = 0;
		for (int j = 0; j < agentMap.length; j++) {
			if (checkAgentDiagonal1 != null && agentMap[j][j] != null && checkAgentDiagonal1.equals(agentMap[j][j])) {
				countDiagonal1++;
			}
		}
		if (countDiagonal1 == agentMap.length) {
			winner = checkAgentDiagonal1;
			loser = agent1 == winner ? agent2 : agent1;
			return true;
		}

		// other diagonal check
		Agent checkAgentDiagonal2 = agentMap[agentMap.length - 1][0];
		int countDiagonal2 = 0;
		for (int i = 0; i < agentMap.length; i++) {
			int j = agentMap.length - 1 - i;
			if (checkAgentDiagonal2 != null && agentMap[i][j] != null && checkAgentDiagonal2.equals(agentMap[i][j])) {
				countDiagonal2++;
			}
		}
		if (countDiagonal2 == agentMap.length) {
			winner = checkAgentDiagonal2;
			loser = agent1 == winner ? agent2 : agent1;
			return true;
		}

		// check for empty space
		for (int i = 0; i < agentMap.length; i++) {
			for (int j = 0; j < agentMap[i].length; j++) {
				if (agentMap[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public EnvironmentResult result() {
		return EnvironmentResultFactory.twoAgentResult(winner, loser);
	}
}
