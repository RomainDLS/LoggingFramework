package com.esiea.projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Configuration {
	
	public static void AjouterCible(Class<?> classe, Cible cible){
		Builder.GetLogger(classe).AddCible(cible);
	}
	
	public static void SetLevel(Class<?> classe, LEVEL level){
		Builder.GetLogger(classe).SetLevel(level);
	}
	
	public static void SetLayout(Class<?> classe, Formater formater){
		formater.SetLogger(Builder.GetLogger(classe));
		Builder.GetLogger(classe).SetFormater(formater);
	}
	
	public static void GetPropertiesFile(String FileName){
		File file = new File(FileName);
		
		try{
			BufferedReader buffer =new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line;
			while ((line=buffer.readLine())!=null){
				LineAnalyze(line);
			}
			buffer.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public static void LineAnalyze(String string){
		String[] list = string.split(" = ");
		String[] Instruction = list[0].split("\\.");
		String Argument[] = list[1].split(" ");
		String ClasseName = "";
		
		for(int i=1;i<Instruction.length-1;i++){
			ClasseName = ClasseName.concat(Instruction[i]);
			if(i!=Instruction.length-2)
				ClasseName = ClasseName.concat(".");
		}
		
		try {
			String config = Instruction[Instruction.length-1];
			
			if(config.equals("level"))
				SetLevel(Class.forName(ClasseName), LEVEL.fromString(Argument[0]));
			
			if(config.equals("formater"))		
				SetLayout(Class.forName(ClasseName), (Formater)Class.forName(Argument[0]).newInstance());
					
			if(config.equals("cibles")){
				try {
					AjouterCible(Class.forName(ClasseName), (Cible)Class.forName(Argument[0]).getConstructor(String.class,String.class).newInstance(Argument[1],Argument[2]));
				} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
						try {
							AjouterCible(Class.forName(ClasseName), (Cible)Class.forName(Argument[0]).getConstructor(String.class).newInstance(Argument[1]));
						} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e1) {
							AjouterCible(Class.forName(ClasseName), (Cible)Class.forName(Argument[0]).newInstance());
						}
					
				}
				
			}
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	
	}
}
