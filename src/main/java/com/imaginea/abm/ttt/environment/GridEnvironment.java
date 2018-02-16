package com.imaginea.abm.ttt.environment;

import java.util.ArrayList;
import java.util.List;

import com.imaginea.abm.ttt.Agent;
import com.imaginea.abm.ttt.AgentAction;
import com.imaginea.abm.ttt.Environment;
import com.imaginea.abm.ttt.action.GridAction;

public class GridEnvironment implements Environment {

	private Agent[][] agentMap;
	private Agent[] agents;

	protected GridEnvironment(int rows, int cols) {
		agentMap = new Agent[rows][cols];
	}

	@Override
	public void perform(AgentAction agentAction) {
		GridAction gridAction = (GridAction) agentAction;
		Agent agent = gridAction.getAgent();
		int posRow = gridAction.getRow();
		int posCol = gridAction.getCol();

		this.agentMap[posRow][posCol] = agent;
	}

	// getter method
	// ------------------------------------------------------------------------

	public Agent[][] getAgentMap() {
		return agentMap.clone();
	}

	@Override
	public void setAgents(Agent... agents) {
		this.agents = agents;
	}

	@Override
	public Agent[] getAgents() {
		return agents.clone();
	}

	@Override
	public List<AgentAction> getAllowedActions(Agent agent) {
		List<AgentAction> allowedActions = new ArrayList<>();
		for (int i = 0; i < agentMap.length; i++) {
			for (int j = 0; j < agentMap[i].length; j++) {
				if (agentMap[i][j] == null) {
					allowedActions.add(new GridAction(agent, i, j));
				}
			}
		}
		return allowedActions;
	}

	// toString
	// ------------------------------------------------------------------------

	@Override
	public String toString() {
		StringBuilder gridString = new StringBuilder();
		for (int i = 0; i < agentMap.length; i++) {
			for (int j = 0; j < agentMap[i].length; j++) {
				gridString.append(String.format("%s\t", agentMap[i][j] == null ? (null + "\t\t\t") : agentMap[i][j]));
			}
			gridString.append("\n");
		}
		return String.format("[GridEnvironment::\n%s]", gridString.toString());
	}
}
