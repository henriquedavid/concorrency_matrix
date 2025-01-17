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

/**
 * 
 * @author Abraão Dantas
 * @author Henrique Medeiros
 * 
 * Classe responsável por fazer a leitura e escrita nos arquivos usados
 * por nossa aplicação
 */
public class Reader {
	
	public String file_name;
	
	public Reader(String file) {
		this.file_name = file;
	}
	
	// Realizando a leitura de cada matriz informada.
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
	
	// Escrevendo uma matriz de saída
	public void outFile(ArrayList<ArrayList<Integer>> result, String dimension){
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("results/" + file_name, false));
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
	
	// Escrevendo um arquivo de saída com os tempos das 20 execuções e analises dos arquivos
	public void outTimes(ArrayList<Long> lista, String dimension, String tipo) {
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("results/"+ "times_"+dimension+"x"+dimension+".txt", true));
			
			Long media = (long) 0;
			Long max = lista.get(0);
			Long min = lista.get(0);
			
			w.append("\nTipo: " + tipo + " - Resultados:\n");
			
			// Calculando o máximo, mínimo e a média; assim como adicionando o dado no arquivo de saída
			for(Long e: lista) {
				if(e > max)
					max = e;
				if(e < min)
					min = e;
				w.append(e.toString() + "\n");
				media += e;
			}
			
			media /= lista.size();
			w.append("-----------------\n");
			w.append("Media: " + media + "\n");
			w.append("Max: " + max + "\n");
			w.append("Min: " + min + "\n");
			
			Double somatorio = 0.0;
			// Calculando o somatorio
			for(Long e : lista) {
				somatorio += Math.pow((e - media),2);
			}
			
			// Calculando o desvio
			Double desvio = Math.sqrt(somatorio/20);
			 
			w.append("Desvio: " + desvio + "\n");
			
			w.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
