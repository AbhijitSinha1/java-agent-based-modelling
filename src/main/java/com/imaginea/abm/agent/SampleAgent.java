package com.imaginea.abm.agent;

import com.imaginea.abm.Agent;
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

	// getter methods
	// ------------------------------------------------------------------------

	@Override
	public Behaviour getBehaviour() {
		return behaviour;
	}

	@Override
	public Environment getEnvironment() {
		return environment;
	}

	// toString
	// ------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return String.format("[SampleAgent:: name: %s]", agentName);
	}
	
	@Override
	public int hashCode() {
		return agentName.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof SampleAgent)) {
			return false;
		}
		SampleAgent agent = (SampleAgent) obj;
		return agent.agentName.equals(agentName) && agent.getEnvironment().equals(environment) && agent.getBehaviour().equals(behaviour);
	}
}
