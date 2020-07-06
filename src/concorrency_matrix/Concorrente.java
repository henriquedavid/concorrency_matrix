package concorrency_matrix;

import java.util.ArrayList;

public class Concorrente extends Thread{

    int x;
    ArrayList<ArrayList<Integer>> matrixA;
    ArrayList<ArrayList<Integer>> matrixB;
    ArrayList<ArrayList<Integer>> matrixR;

    
    public Concorrente(int x, ArrayList<ArrayList<Integer>> matrixA,
			ArrayList<ArrayList<Integer>> matrixB, ArrayList<ArrayList<Integer>> matrixR, String name) {
		super(name);
		this.x = x;
		this.matrixA = matrixA;
		this.matrixB = matrixB;
		this.matrixR = matrixR;
	}

	@Override
    public void run() {
		
		int tamanho = matrixA.size();
		
		// Percorrendo as colunas da matriz B
		for(int j = 0; j < tamanho; j++) {
			
			int soma = 0;
			
			// Realizando o cálculo da multiplicação das matrizes
			for(int k = 0; k < tamanho; k++){
	            soma += (matrixA.get(x).get(k) * matrixB.get(k).get(j));
	        }
			
			// Atualizando o valor na matriz resultante.
			matrixR.get(x).set(j, soma);
		}
    }
}