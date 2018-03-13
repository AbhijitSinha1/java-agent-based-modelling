package com.imaginea.abm.ttt;

import com.imaginea.abm.Agent;
import com.imaginea.abm.AgentAction;
import com.imaginea.abm.Environment;
import com.imaginea.abm.EnvironmentCompleteLogic;
import com.imaginea.abm.agent.AgentFactory;
import com.imaginea.abm.behaviour.BehaviourFactory;
import com.imaginea.abm.environment.EnvironmentFactory;
import com.imaginea.abm.environment.GridEnvironment;
import com.imaginea.abm.environment.TwoAgentEnvironmentResult;

public class TicTacToe {

	public static void main(String[] args) {
		double player1Wins = simulate(10000);
		System.out.println(String.format("player 1 wins: %s %% of times", (player1Wins * 100)));
	}

	private static double simulate(int count) {
		int win = 0;
		for (int i = 0; i < count; i++) {
			win += simulate();
		}
		System.out.println(String.format("win: %s, count: %s", win, count));
		return win / (double) count;
	}

	private static int simulate() {
		EnvironmentCompleteLogic logic = new TicTacToeCompleteLogic();
		Environment env = EnvironmentFactory.grid(3, 3);

		StrategicBehaviour strategicBehaviour1 = new StrategicBehaviour(((GridEnvironment) env).getAgentMap());
		StrategicBehaviour strategicBehaviour2 = new StrategicBehaviour(((GridEnvironment) env).getAgentMap());

		Agent player1 = AgentFactory.agent(strategicBehaviour1, env, "Player 1");
		Agent player2 = AgentFactory.agent(BehaviourFactory.random(), env, "Player 2");

		strategicBehaviour1.setAgent(player1);
		strategicBehaviour1.setOpponent(player2);

		strategicBehaviour2.setAgent(player2);
		strategicBehaviour2.setOpponent(player1);

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

		TwoAgentEnvironmentResult result = (TwoAgentEnvironmentResult) logic.result();
//		System.out.println(String.format("result: %s", result));
		return (result.getWinner() != null && result.getWinner().equals(player1)) ? 1 : 0;
	}

}
