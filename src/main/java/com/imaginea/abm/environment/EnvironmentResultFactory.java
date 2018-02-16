package com.imaginea.abm.environment;

import com.imaginea.abm.Agent;
import com.imaginea.abm.EnvironmentResult;

public class EnvironmentResultFactory {

	private EnvironmentResultFactory() {
	}

	public static EnvironmentResult twoAgentResult(Agent winner, Agent loser) {
		return new TwoAgentEnvironmentResult(winner, loser);
	}

}
