package concorrency_matrix;

import java.util.ArrayList;

/**
 * 
 * @author Abraão Dantas
 * @author Henrique Medeiros
 * 
 * Classe main da nossa aplicação, responsável por receber os argumentos
 * e executar o nosso algoritmos
 */
public class Principal {
	
	//matriz resultado da multiplicação
	static ArrayList<ArrayList<Integer>> l_R;
	
	public static void main(String[] args) {
		
		// Verificação da quantidade de argumentos informados
		if(args.length < 2) {
			System.out.println("SyntaxError: <program> base_number type_run");
		} else {
			// Obtendo dos argumentos
			String dimensao = args[0];
			String versao = args[1];
			
			// Criando os objetos relacionados a leitura das matrizes A e B
			Reader r_A = new Reader("A"+dimensao+"x"+dimensao+".txt");
			Reader r_B = new Reader("B"+dimensao+"x"+dimensao+".txt");
			// Criando os objetos relacionados a escrita da matriz C
			Reader r_R = new Reader("C"+dimensao+"x"+dimensao+".txt");
			
			// Armazenar os tempos
			ArrayList<Long> times = new ArrayList<>();
			
			//Realizando a leitura dos arquivos de entrada de A e B.
			ArrayList<ArrayList<Integer>> l_A = r_A.readFile();
			ArrayList<ArrayList<Integer>> l_B = r_B.readFile();
			
			// Iterando as 20 vezes
			for(int a = 0; a < 20; a++) {
				//Começando o cronometro
				Long start;
				if(Integer.parseInt(dimensao) >= 512) {
					start = System.currentTimeMillis();
				} else {
					start = System.nanoTime();
				}

			
				// Verificando o tipo de execução (sequencial/concorrente)
				if(versao.equals("S")) {
					Sequencial s = new Sequencial(l_A, l_B);
					// Realizando a multiplicação
					l_R = s.multiplicarMatrizes();
					//r_R.outFile(l_, dimensao);
				} else if(versao.equals("C")) {
					Integer size_ = Integer.parseInt(dimensao);
					// Criando e inicializando a matriz C (resultante)
					l_R = new ArrayList<ArrayList<Integer>>();
					inicializadorMatrix(size_);
			
					// Armazenando as threads
					ArrayList<Concorrente> l_conc = new ArrayList<>();
					
			
					// Executando cada thread informando a linha desejada
					for(int i = 0; i < size_; i++) {
						Concorrente li = new Concorrente(i, l_A, l_B, l_R, "thread" + i);
						li.start();
						l_conc.add(li);
					}
			
					// Esperando todas as threads executarem
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
				
				//Finalizando o cronometro e adicionando a lista times.
				Long end;
				if(Integer.parseInt(dimensao) >= 512) {
					end = System.currentTimeMillis();
				} else {
					end = System.nanoTime();
				}
				
				Long elapsed = end - start;
				times.add(elapsed);
			}
			
			// Criando o arquivo de saida e gerando um arquivo com os tempos de execução
			r_R.outFile(l_R, dimensao);
			r_R.outTimes(times, dimensao, versao);
			
		}

	}
	
	// Método para realizar a inicialização da matriz.
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
