package com.imaginea.abm.ttt.environment;

import com.imaginea.abm.ttt.Agent;
import com.imaginea.abm.ttt.EnvironmentResult;

public class TwoAgentEnvironmentResult implements EnvironmentResult {

	private final Agent winner;
	private final Agent loser;

	public TwoAgentEnvironmentResult(Agent winner, Agent loser) {
		this.winner = winner;
		this.loser = loser;
	}

	// getter
	// ------------------------------------------------------------------------
	
	public Agent getWinner() {
		return winner;
	}

	public Agent getLoser() {
		return loser;
	}

	// toString
	// ------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return String.format("[TwoAgentEnvironmentResult:: winner: %s | loser: %s]", winner, loser);
	}
	
}
