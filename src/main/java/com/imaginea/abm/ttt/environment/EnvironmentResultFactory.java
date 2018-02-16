package com.imaginea.abm.ttt.environment;

import com.imaginea.abm.ttt.Agent;
import com.imaginea.abm.ttt.EnvironmentResult;

public class EnvironmentResultFactory {

	private EnvironmentResultFactory() {
	}

	public static EnvironmentResult twoAgentResult(Agent winner, Agent loser) {
		return new TwoAgentEnvironmentResult(winner, loser);
	}

}
