package com.imaginea.abm.ttt.agent;

import com.imaginea.abm.ttt.Agent;
import com.imaginea.abm.ttt.AgentAction;
import com.imaginea.abm.ttt.Behaviour;
import com.imaginea.abm.ttt.Environment;

public class SampleAgent implements Agent {

	private final Behaviour behaviour;
	private final Environment environment;
	private String agentName;

	public SampleAgent(Behaviour behaviour, Environment environment, String agentName) {
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
