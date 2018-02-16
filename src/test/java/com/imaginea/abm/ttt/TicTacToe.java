package com.imaginea.abm.ttt;

import com.imaginea.abm.ttt.agent.AgentFactory;
import com.imaginea.abm.ttt.behaviour.BehaviourFactory;
import com.imaginea.abm.ttt.environment.EnvironmentFactory;
import com.imaginea.abm.ttt.environment.EnvironmentResultFactory;
import com.imaginea.abm.ttt.environment.GridEnvironment;

public class TicTacToe {

	public static void main(String[] args) {
		Environment env = EnvironmentFactory.grid(3, 3);
		EnvironmentCompleteLogic logic = new EnvironmentCompleteLogic() {
			
			private Agent winner = null;
			private Agent loser = null;
			
			@Override
			public boolean done(Environment environment) {
				GridEnvironment gridEnvironment = (GridEnvironment) environment;
				Agent[][] agentMap = gridEnvironment.getAgentMap();
				Agent[] agents = environment.getAgents();
				
				Agent agent1 = agents[0];
				Agent agent2 = agents[1];

				// horizontal check
				for (int i = 0; i < agentMap.length; i++) {
					Agent checkAgent = agentMap[i][0];
					int count = 0;
					for (int j = 0; j < agentMap[i].length; j++) {
						if(checkAgent != null && agentMap[i][j] != null && checkAgent.equals(agentMap[i][j])) {
							count++;
						}
					}
					if(count == agentMap[i].length) {
						winner = checkAgent;
						loser = agent1 == winner ? agent2 : agent1;
						return true;
					}
				}

				// vertical check
				for (int j = 0; j < agentMap[0].length; j++) {
					Agent checkAgent = agentMap[0][j];
					int count = 0;
					for (int i = 0; i < agentMap.length; i++) {
						if(checkAgent != null && agentMap[i][j] != null && checkAgent.equals(agentMap[i][j])) {
							count++;
						}
					}
					if(count == agentMap.length) {
						winner = checkAgent;
						loser = agent1 == winner ? agent2 : agent1;
						return true;
					}
				}

				// check for empty space
				for (int i = 0; i < agentMap.length; i++) {
					for (int j = 0; j < agentMap[i].length; j++) {
						if (agentMap[i][j] == null) {
							return false;
						}
					}
				}
				return true;
			}

			@Override
			public EnvironmentResult result() {
				return EnvironmentResultFactory.twoAgentResult(winner, loser);
			}

		};

		Agent player1 = AgentFactory.agent(BehaviourFactory.random(), env, "Player 1");
		Agent player2 = AgentFactory.agent(BehaviourFactory.random(), env, "Player 2");
		
		env.setAgents(player1, player2);

		while (!logic.done(env)) {
			AgentAction player1move = player1.getNextAction();
			env.perform(player1move);
			if (logic.done(env)) {
				break;
			}
			AgentAction player2move = player2.getNextAction();
			env.perform(player2move);
		}

		EnvironmentResult result = logic.result();

		System.out.println(String.format("result: %s", result));
		System.out.println(env);
		
	}

}
