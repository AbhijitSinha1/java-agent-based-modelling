package com.imaginea.abm;

public interface Agent {

	default AgentAction getNextAction() {
		return getBehaviour().selectAction(getEnvironment().getAllowedActions(this));
	}

	Behaviour getBehaviour();

	Environment getEnvironment();
	
}
