package com.esiea.projet;

import java.util.Calendar;

public class FormaterDefault extends Formater {
	
	public FormaterDefault() {}

	
	@Override
	public String Format(String message){
		String time = Calendar.getInstance().getTime().toString();
		return time + " [NAME=" + logger.GetClass().getName() + ", LEVEL=" + level + ", MESSAGE="+ message + "]";
	}

}
