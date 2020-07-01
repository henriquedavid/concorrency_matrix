package concorrency_matrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {
	
	public String file_name;
	
	public Reader(String file) {
		this.file_name = file;
	}
	
	public ArrayList<ArrayList<Integer>> readFile(){
		try {
		File file  = new File("./inputs/Matrizes/"+this.file_name);
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s;
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		s = br.readLine();
		while((s = br.readLine()) != null) {
			ArrayList<Integer> new_list = new ArrayList<Integer>();
			String[] l = s.split(" ");
			for(String o : l) {
				new_list.add(Integer.parseInt(o));
			}
			list.add(new_list);
		}
		
		br.close();
		
		return list;
		} catch(FileNotFoundException fl) {
			fl.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void outFile(ArrayList<ArrayList<Integer>> result, String dimension){
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(file_name, true));
			
			w.write(dimension + " " + dimension + "\n");
			for(ArrayList<Integer> i : result) {
				for(Integer o : i) {
					w.append(o.toString() + " ");
				}
				w.append("\n");
			}
			w.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
