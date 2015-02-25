package com.esiea.projet;

import java.util.LinkedList;


public class Builder {
	
	private static LinkedList<Logger> Loggers = new LinkedList<Logger>();
	
	public static Logger GetLogger(Class<?> classe){
		if(!Loggers.isEmpty())
			for(Logger log : Loggers){
				if(log.GetClass().equals(classe))
					return log;
			}
		
		Logger logger = new Logger(classe);
		Loggers.add(logger);
		
		return logger;
	}

	public static LinkedList<Logger> getLoggers() {
		return Loggers;
	}
}
