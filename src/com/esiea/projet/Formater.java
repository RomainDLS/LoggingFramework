package com.esiea.projet;

public abstract class Formater {
	
	protected Logger logger;
	protected LEVEL level;
	
	public void SetLevel(LEVEL level){
		this.level = level;
	}

	public void SetLogger(Logger logger){
		this.logger = logger;
	}

	abstract String Format(String message);

}
