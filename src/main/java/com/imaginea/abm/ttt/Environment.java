package com.imaginea.abm.ttt;

import java.util.List;

public interface Environment {

	void perform(AgentAction agentAction);

	void setAgents(Agent... agents);

	Agent[] getAgents();

	List<AgentAction> getAllowedActions(Agent agent);
}
