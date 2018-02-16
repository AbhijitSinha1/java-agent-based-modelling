# java-agent-based-modelling
Repository intended to understand agent based modelling techniques

## Introduction to agent based modelling
[wikipedia](https://en.wikipedia.org/wiki/Agent-based_model): An agent-based model (ABM) is a class of computational models for simulating the actions and interactions of autonomous agents (both individual or collective entities such as organizations or groups) with a view to assessing their effects on the system as a whole.

## Introduction to the project
This project is written with the intention of understanding the agent based modelling techniques. We aim to model any scenario by making use of the following classes:
* [`Agent`](src/main/java/com/imaginea/abm/ttt/Agent.java): This is a basic class which will be performing certain tasks. We could create multiple instances of these agents and provide various goals to each of the agents
* [`Environment`](src/main/java/com/imaginea/abm/ttt/Environment.java): This is the universe in which the `Agent`s will be performing its tasks. The `Environment` itself might respond to the tasks performed by the `Agent`.
* [`Behaviour`](src/main/java/com/imaginea/abm/ttt/Behaviour.java): Every `Agent` will be provided with a certain `Behaviour` according to which it will act during the simulation.
* [`AgentAction`](src/main/java/com/imaginea/abm/ttt/AgentAction.java): This is the action which the `Agent` will perform as per its coded `Behaviour`.

## How to run the code
There is a sample [`TicTacToe`](src/test/java/com/imaginea/abm/ttt/TicTacToe.java) code in the test folder. It has a main method and can be run as a normal java application. The application initiates 2 player `Agent`s and a `GridEnvironment` where the players move in a randomized `Behaviour`. When the code is run, the two players take turn to play TicTacToe and at the end, the winner and loser is printed on the console along with the final board position.

## Future work
The code has been written with the hope that it should be able to incorporate many more scenarios where agents are involved. We need to add more test applications to verify if the code structure can handle other agent based modelling scenarios. And if we find situations where the current structure needs updating, we would have to work on that.
