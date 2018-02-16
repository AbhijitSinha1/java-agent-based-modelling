package com.imaginea.abm.agent;

import com.imaginea.abm.Agent;
import com.imaginea.abm.AgentAction;
import com.imaginea.abm.Behaviour;
import com.imaginea.abm.Environment;

public class SampleAgent implements Agent {

	private final Behaviour behaviour;
	private final Environment environment;
	private String agentName;

	protected SampleAgent(Behaviour behaviour, Environment environment, String agentName) {
		this.behaviour = behaviour;
		this.environment = environment;
		this.agentName = agentName;
	}

	@Override
	public AgentAction getNextAction() {
		return behaviour.selectAction(environment.getAllowedActions(this));
	}

	// getter methods
	// ------------------------------------------------------------------------
	
	public Behaviour getBehaviour() {
		return behaviour;
	}

	public Environment getEnvironment() {
		return environment;
	}

	// toString
	// ------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return String.format("[SampleAgent:: name: %s]", agentName);
	}
	
}
