package concorrency_matrix;

import java.util.ArrayList;

public class Principal {
	
	static ArrayList<ArrayList<Integer>> l_R;
	
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

			/*Sequencial s = new Sequencial(l_A, l_B);
			System.out.println(s.multiplicarMatrizes());*/
			l_R = new ArrayList<ArrayList<Integer>>();
			inicializadorMatrix(Integer.parseInt(dimensao));
			
			Concorrente l1 = new Concorrente(0, l_A, l_B, l_R, "thread0");
			Concorrente l2 = new Concorrente(1, l_A, l_B, l_R, "thread1");
			
			l1.start();
			l2.start();
			
			try {
				l1.join();
				l2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(l_R);
			//System.out.println(l_B);
			
			
		}

	}
	
	public static void inicializadorMatrix(int dimensao) {
		for(int i = 0; i < dimensao; i++) {
			ArrayList<Integer> aux = new ArrayList(dimensao);
			for(int j = 0; j < dimensao; j++) {
				aux.add(0);
			}
			l_R.add(aux);
		}
	}

}
