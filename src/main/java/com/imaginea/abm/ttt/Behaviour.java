package com.imaginea.abm.ttt;

import java.util.List;

public interface Behaviour {

	AgentAction selectAction(List<AgentAction> actions);

}
