package com.imaginea.abm;

import java.util.List;

public interface Behaviour {

	AgentAction selectAction(List<AgentAction> actions);

}
