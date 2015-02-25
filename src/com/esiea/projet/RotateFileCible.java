package com.esiea.projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class RotateFileCible extends Cible {
	private String Path;
	private File file;
	private int FileSize;
	private int NbOfFile;

	public RotateFileCible(String Path, String FileSize) {
		this.Path = Path;
		file = new File(Path);
		this.FileSize = Integer.valueOf(FileSize);
		NbOfFile = 0;
	}
	
	public String GetPath(){
		return Path;
	}
	
	public void SetPath(String Path){
		this.Path = Path;
	}

	public void SetFileSize(int FileSize){
		this.FileSize = FileSize;
	}
	
	public int GetNbLines(){
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(file);
			LineNumberReader l = new LineNumberReader(new BufferedReader(new InputStreamReader(fis)));
		    try {
				while ((l.readLine())!=null){
					count = l.getLineNumber();
				}
			} catch (IOException e) {
						e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return count - 1;
	}
	
	@Override
	void Send(String message) {
		try {
			FileWriter fw = new FileWriter(file,true);
			if(GetNbLines()<FileSize)
				fw.write("\n" + message);
			else{
				file = new File(Path.split("\\.")[0] + NbOfFile++ + "."+ Path.split("\\.")[1]);
				Send(message);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
