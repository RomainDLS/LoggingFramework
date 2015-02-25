package com.esiea.projet;

import java.util.LinkedList;

public class Logger {
	private Class<?> classe;
	private LEVEL level;
	private LinkedList<Cible> cibles;
	private Formater formater;
	
	public Logger(Class<?> classe){
		this.classe = classe;
		this.level = LEVEL.DEBUG;
		this.cibles = new LinkedList<Cible>();
	}
	
	protected Class<?> GetClass(){
		return classe;
	}
	
	protected LEVEL GetLevel(){
		return level;
	}
	
	protected void SetLevel(LEVEL level){
		this.level = level;
	}
	
	protected void SetFormater(Formater formater){
		this.formater = formater;
	}
	
	protected void AddCible(Cible cible){
		this.cibles.add(cible);
	}
	
	public void debug(String message){
		
		if(level.ordinal()==0){
			for(Cible c : cibles){
				if(formater != null){
					formater.SetLevel(LEVEL.DEBUG);	
					c.Send(formater.Format(message));
				}
				else
					c.Send(message);
			}
		}
	}
	
	public void info(String message){
		if(level.ordinal()<=1){
			for(Cible c : cibles){
				if(formater != null){
					formater.SetLevel(LEVEL.INFO);	
					c.Send(formater.Format(message));
				}
				else
					c.Send(message);
			}
		}
	}
	
	public void error(String message){
		for(Cible c : cibles){
			if(formater != null){
				formater.SetLevel(LEVEL.ERROR);
				c.Send(formater.Format(message));
			}
			else
				c.Send(message);
		}
	}
}
