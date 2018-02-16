package com.imaginea.abm.ttt.environment;

import com.imaginea.abm.ttt.Environment;

public class EnvironmentFactory {

	private EnvironmentFactory() {
	}

	public static Environment grid(int rows, int cols) {
		return new GridEnvironment(rows, cols);
	}

}
