package com.imaginea.abm.behaviour;

import com.imaginea.abm.Behaviour;

public class BehaviourFactory {

	private BehaviourFactory() {
	}

	public static Behaviour random() {
		return new RandomBehaviour();
	}

}
