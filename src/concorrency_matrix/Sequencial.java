package concorrency_matrix;

import java.util.ArrayList;

/**
 * 
 * @author Abraão Dantas
 * @author Henrique Medeiros
 * 
 * Classe com a implementação do algoritmo de multiplicação de matrizes na sua versão sequencial
 */
public class Sequencial{

    ArrayList<ArrayList<Integer>> A, B;
    
    // Construtor recebendo as matrizes A e B
    public Sequencial(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B){
        this.A = A;
        this.B = B;
    }

    // Calculando a multiplicação das matrizes
    public ArrayList<ArrayList<Integer>> multiplicarMatrizes(){
        
        //Definido desse jeito pois as matrizes são quadradas
        int tamanho = A.size();

        ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();

        // Percorrendo as linhas da matriz A
        for(int i = 0; i < tamanho; i++){
            
            ArrayList<Integer> aux = new ArrayList<>();

            // Percorrendo as colunas da matriz B
            for(int j = 0; j < tamanho; j++){
                
                int soma = 0;
                
                // Calculando a multiplicação
                for(int k = 0; k < tamanho; k++){
                    soma += (A.get(i).get(k) * B.get(k).get(j));
                }

                aux.add(soma);

            }
            
            // Adicionando a matriz resultado
            resultado.add(aux);
        }

        return resultado;
    }


}