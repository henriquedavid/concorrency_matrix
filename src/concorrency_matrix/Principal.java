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
			Reader r_R = new Reader("C"+dimensao+"x"+dimensao+".txt");
			
			ArrayList<Long> times = new ArrayList<>();
			
			ArrayList<ArrayList<Integer>> l_A = r_A.readFile();
			ArrayList<ArrayList<Integer>> l_B = r_B.readFile();
			
			for(int a = 0; a < 20; a++) {
			
				Long start = System.currentTimeMillis();
			
				if(versao.equals("S")) {
					Sequencial s = new Sequencial(l_A, l_B);
					l_R = s.multiplicarMatrizes();
					//r_R.outFile(l_, dimensao);
				} else if(versao.equals("C")) {
					Integer size_ = Integer.parseInt(dimensao);
					l_R = new ArrayList<ArrayList<Integer>>();
					inicializadorMatrix(size_);
			
					ArrayList<Concorrente> l_conc = new ArrayList<>();
					
			
					for(int i = 0; i < size_; i++) {
						Concorrente li = new Concorrente(i, l_A, l_B, l_R, "thread" + i);
						li.start();
						l_conc.add(li);
					}
			
					try {
						for(Concorrente l : l_conc) {
							l.join();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				
				} else {
					System.out.println("InvalidType: Only support S or C");
				}
				
				Long end = System.currentTimeMillis();
				Long elapsed = end - start;
				times.add(elapsed);
			}
			
			r_R.outFile(l_R, dimensao);
			r_R.outTimes(times, dimensao, versao);
			
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
