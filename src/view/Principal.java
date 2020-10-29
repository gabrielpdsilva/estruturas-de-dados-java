package view;

import ordenacoes.Ordenacao;

public class Principal {
	
	public static void main(String[] args) {
		
		int[] vetor = {4, 2, 10, 5};
		vetor = Ordenacao.cocktail(vetor);
		
		int tamanhoVetor = vetor.length;
		for(int i = 0; i < tamanhoVetor; i++)
			System.out.print(vetor[i] + " ");
	}

}
