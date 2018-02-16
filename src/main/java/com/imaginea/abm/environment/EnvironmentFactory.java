package com.imaginea.abm.environment;

import com.imaginea.abm.Environment;

public class EnvironmentFactory {

	private EnvironmentFactory() {
	}

	public static Environment grid(int rows, int cols) {
		return new GridEnvironment(rows, cols);
	}

}
