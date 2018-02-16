package com.imaginea.abm.ttt.behaviour;

import com.imaginea.abm.ttt.Behaviour;

public class BehaviourFactory {

	public static Behaviour random() {
		return new RandomBehaviour();
	}

}
