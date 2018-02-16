package com.imaginea.abm.ttt.agent;

import com.imaginea.abm.ttt.Agent;
import com.imaginea.abm.ttt.Behaviour;
import com.imaginea.abm.ttt.Environment;

public class AgentFactory {

	public static Agent agent(Behaviour behaviour, Environment environment, String name) {
		return new SampleAgent(behaviour, environment, name);
	}

}
