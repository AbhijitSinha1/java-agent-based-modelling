package com.imaginea.abm.agent;

import com.imaginea.abm.Agent;
import com.imaginea.abm.Behaviour;
import com.imaginea.abm.Environment;

public class AgentFactory {

	private AgentFactory() {
	}

	public static Agent agent(Behaviour behaviour, Environment environment, String name) {
		return new SampleAgent(behaviour, environment, name);
	}

}
