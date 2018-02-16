package com.imaginea.abm.action;

import com.imaginea.abm.Agent;
import com.imaginea.abm.AgentAction;

public class GridAction implements AgentAction {

	private final Agent agent;
	private final int col;
	private final int row;

	public GridAction(Agent agent, int row, int col) {
		this.agent = agent;
		this.row = row;
		this.col = col;
	}

	public Agent getAgent() {
		return this.agent;
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	// toString
	// --------------------------------------------------------------
	
	@Override
	public String toString() {
		return String.format("[GridAction:: agent: %s | row: %s | col: %s]", agent, row, col);
	}
	
}
