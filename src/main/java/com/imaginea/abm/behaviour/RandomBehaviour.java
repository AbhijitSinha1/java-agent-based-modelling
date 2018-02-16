package com.imaginea.abm.behaviour;

import java.util.List;

import com.imaginea.abm.AgentAction;
import com.imaginea.abm.Behaviour;

public class RandomBehaviour implements Behaviour {
	protected RandomBehaviour() {
	}

	@Override
	public AgentAction selectAction(List<AgentAction> actions) {
		if(actions == null || actions.size() == 0) {
			return null;
		}
		int index = (int)(actions.size() * Math.random());
		return actions.get(index);
	}
}
