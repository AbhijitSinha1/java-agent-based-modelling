package com.imaginea.abm;

import java.util.List;

public interface Environment {

	void perform(AgentAction agentAction);

	void setAgents(Agent... agents);

	Agent[] getAgents();

	List<AgentAction> getAllowedActions(Agent agent);
}
