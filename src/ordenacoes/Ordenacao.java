package ordenacoes;

public abstract class Ordenacao {
	
	//======================BubbleSort======================
	
	//bubble sort:
	//https://upload.wikimedia.org/wikipedia/commons/5/54/Sorting_bubblesort_anim.gif
	
	public static int[] bubbleSort(int[] vetor){
		int tamanhoVetor = vetor.length;
		int auxiliar;
		for(int i = 0; i < tamanhoVetor; i++){
			for(int j = (i+1); j < tamanhoVetor; j++){
				if(vetor[i] > vetor[j]){
					auxiliar = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = auxiliar;
				}
			}
		}
		return vetor;
	}
	
	//======================Cocktail======================
	
	//modo de funcionamento:
	//https://upload.wikimedia.org/wikipedia/commons/e/ef/Sorting_shaker_sort_anim.gif
	
	public static int[] cocktail(int[] vetor) {
		int tamanho, inicio, fim, swap, aux;
		tamanho = vetor.length;
		inicio = 0;
		fim = tamanho - 1;
		swap = 0;
		
		while (swap == 0 && inicio < fim) {
			
			swap = 1;
			
			//indo da esquerda pra direita
			for (int i = inicio; i < fim; i = i + 1) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
					swap = 0;
				}
			}
			fim = fim - 1;

			//indo da direita pra esquerda
			for (int i = fim; i > inicio; i = i - 1) {
				if (vetor[i] < vetor[i - 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i - 1];
					vetor[i - 1] = aux;
					swap = 0;
				}
			}
			inicio = inicio + 1;
		}
		return vetor;
	}
	
	//======================MergeSort======================
	
	//Faz merge de dois subarrays de um vetor[]
	//O primeiro subarray vai de [inicio..meio]
	//O segundo subarray vai de [meio+1..fim]
	
	//https://www.geeksforgeeks.org/merge-sort/
	//https://pt.wikipedia.org/wiki/Merge_sort
		
	private static void merge(int vetor[], int indiceInicio, int meio, int indiceFim) {
		
		// Find sizes of two subarrays to be merged
		//encontra o tamanho dos 2 subarrays a sofrerem o merge
		int tamanhoVetorEsquerda = meio - indiceInicio + 1;
		int tamanhoVetorDireita = indiceFim - meio;

		//Criando os arrays temporarios
		int temporarioEsquerda[] = new int[tamanhoVetorEsquerda];
		int temporarioDireita[] = new int[tamanhoVetorDireita];

		//copia os dados para arrays temporarios
		for (int i = 0; i < tamanhoVetorEsquerda; ++i)
			temporarioEsquerda[i] = vetor[indiceInicio + i];
		for (int j = 0; j < tamanhoVetorDireita; ++j)
			temporarioDireita[j] = vetor[meio + 1 + j];

		/* Merge the temp arrays */

		//indice inicial do primeiro e segundo subarrays
		int i = 0, j = 0;

		int k = indiceInicio;

		//juncao das listas ordenadas
		while (i < tamanhoVetorEsquerda && j < tamanhoVetorDireita) {
			if (temporarioEsquerda[i] <= temporarioDireita[j]) {
				vetor[k] = temporarioEsquerda[i];
				i++;
			} else {
				vetor[k] = temporarioDireita[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		//append de dados que nao foram usados na juncao
		while (i < tamanhoVetorEsquerda) {
			vetor[k] = temporarioEsquerda[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		//append de dados que nao foram usados na juncao
		while (j < tamanhoVetorDireita) {
			vetor[k] = temporarioDireita[j];
			j++;
			k++;
		}
	}

	//funcao responsavel por ordenar o array usando merge()
	public static void ordenarMerge(int vetor[], int indiceInicio, int indiceFim) {
		if (indiceInicio < indiceFim) {
			//encontra o meio
			int meio = (indiceInicio + indiceFim) / 2;

			//ordena a primeira e a segunda metade
			ordenarMerge(vetor, indiceInicio, meio);
			ordenarMerge(vetor, meio + 1, indiceFim);

			// Merge the sorted halves
			merge(vetor, indiceInicio, meio, indiceFim);
		}
	}

}
