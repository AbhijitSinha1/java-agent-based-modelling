package com.imaginea.abm.ttt;

import com.imaginea.abm.Agent;
import com.imaginea.abm.AgentAction;
import com.imaginea.abm.Environment;
import com.imaginea.abm.EnvironmentCompleteLogic;
import com.imaginea.abm.EnvironmentResult;
import com.imaginea.abm.agent.AgentFactory;
import com.imaginea.abm.environment.EnvironmentFactory;
import com.imaginea.abm.environment.GridEnvironment;

public class TicTacToe {

	public static void main(String[] args) {
		Environment env = EnvironmentFactory.grid(3, 3);
		EnvironmentCompleteLogic logic = new TicTacToeCompleteLogic();

		StrategicBehaviour strategicBehaviour1 = new StrategicBehaviour(((GridEnvironment) env).getAgentMap());
		StrategicBehaviour strategicBehaviour2 = new StrategicBehaviour(((GridEnvironment) env).getAgentMap());
		
		Agent player1 = AgentFactory.agent(strategicBehaviour1, env, "Player 1");
		Agent player2 = AgentFactory.agent(strategicBehaviour2, env, "Player 2");

		env.setAgents(player1, player2);
		strategicBehaviour1.setAgent(player1);
		strategicBehaviour1.setOpponent(player2);

		strategicBehaviour2.setAgent(player2);
		strategicBehaviour2.setOpponent(player1);
		
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
