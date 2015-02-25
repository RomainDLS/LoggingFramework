package com.esiea.projet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCible extends Cible {
	private String Path;
	private File file;

	public FileCible(String Path) {
		this.Path = Path;
		file = new File(Path);
	}
	
	public void SetPath(String Path){
		this.Path = Path;
		file = new File(Path);
	}
	
	public String GetPath(){
		return Path;
	}

	@Override
	void Send(String message) {
		try {
			FileWriter fw = new FileWriter(file,true);
			fw.write("\n" + message);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
