package concorrency_matrix;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		if(args.length < 2) {
			System.out.println("SyntaxError: <program> base_number type_run");
		} else {
			String dimensao = args[0];
			String versao = args[1];
		
			Reader r_A = new Reader("A"+dimensao+"x"+dimensao+".txt");
			Reader r_B = new Reader("B"+dimensao+"x"+dimensao+".txt");
			
			ArrayList<ArrayList<Integer>> l_A = r_A.readFile();
			ArrayList<ArrayList<Integer>> l_B = r_B.readFile();

			Sequencial s = new Sequencial(l_A, l_B);
			System.out.println(s.multiplicarMatrizes());
			
			//System.out.println(l_A);
			//System.out.println(l_B);
			
			
		}

	}

}
