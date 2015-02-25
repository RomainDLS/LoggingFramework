package com.esiea.projet;

public enum LEVEL {
	DEBUG, INFO, ERROR;
	
	
	public static LEVEL fromString(String text) {
	    if (text != null) {
	      for (LEVEL b : LEVEL.values()) {
	        if (text.equalsIgnoreCase(b.name())) {
	          return b;
	        }
	      }
	    }
	    return null;
	  }

}
