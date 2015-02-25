package com.esiea.projet;

public class ConsoleCible extends Cible {

	public ConsoleCible() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void Send(String message) {
		System.out.println(message);
	}

}
