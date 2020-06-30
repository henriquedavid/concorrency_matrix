package concorrency_matrix;

import java.util.ArrayList;

public class Sequencial{

    ArrayList<ArrayList<Integer>> A, B;
    
    public Sequencial(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B){
        this.A = A;
        this.B = B;
    }

    public ArrayList<ArrayList<Integer>> multiplicarMatrizes(){
        
        //Definido desse jeito pois as matrizes são quadradas
        int tamanho = A.size();

        ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < tamanho; i++){
            
            ArrayList<Integer> aux = new ArrayList<>();

            for(int j = 0; j < tamanho; j++){
                
                int soma = 0;
                
                for(int k = 0; k < tamanho; k++){
                    soma += (A.get(i).get(k) * B.get(k).get(j));
                }

                aux.add(soma);

            }

            resultado.add(aux);
        }

        return resultado;
    }


}