package com.esiea.projet;


public class Test {

	public static void main(String[] args) {
		
	//	Configuration.SetLevel(com.esiea.projet.Test.class, LEVEL.ERROR);
	//	Configuration.AjouterCible(Test.class, new ConsoleCible());
	//	Configuration.AjouterCible(Test.class, new FileCible("log.txt"));
	//	Configuration.AjouterCible(Test.class, new RotateFileCible("rlog.txt",10));
	//	Configuration.SetLayout(Test.class, new FormaterDefault());
		
		Logger logger = Builder.GetLogger(Test.class);
		
		Configuration.GetPropertiesFile("Properties.txt");

		logger.debug("test1");
		logger.info("test2");
		logger.error("test3");
		logger.debug("test1");
		logger.info("test2");
		logger.error("test3");
	}
}
