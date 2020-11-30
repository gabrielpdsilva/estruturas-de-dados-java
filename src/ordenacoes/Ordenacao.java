package ordenacoes;

public abstract class Ordenacao {

	// ======================BubbleSort======================

	// bubble sort:
	// https://upload.wikimedia.org/wikipedia/commons/5/54/Sorting_bubblesort_anim.gif

	public static int[] bubbleSort(int[] vetor) {
		int tamanhoVetor = vetor.length;
		int auxiliar;
		for (int i = 0; i < tamanhoVetor; i++) {
			for (int j = (i + 1); j < tamanhoVetor; j++) {
				if (vetor[i] > vetor[j]) {
					auxiliar = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = auxiliar;
				}
			}
		}
		return vetor;
	}
	
	// ======================SelectionSort======================
	
	public static int[] selectionSort(int[] vetor){  
		int tamanhoVetor = vetor.length;
        for (int i = 0; i < tamanhoVetor - 1; i++) {
            int indice = i;  
            for (int j = i + 1; j < tamanhoVetor; j++){  
                if (vetor[j] < vetor[indice]){  
                    indice = j; // procurando o menor indice 
                }  
            }  
            int menorNumero = vetor[indice];   
            vetor[indice] = vetor[i];  
            vetor[i] = menorNumero;  
        }
        return vetor;
    }  

	// ======================QuickSort======================
	
	//https://www.geeksforgeeks.org/java-program-for-quicksort/
	
	public static int[] quickSort(int vetor[], int inicio, int fim) {
		if (inicio < fim) {
			int indiceParticionado = particao(vetor, inicio, fim);

			// Faz o sort antes e
			// depois da particao
			quickSort(vetor, inicio, indiceParticionado - 1);
			quickSort(vetor, indiceParticionado + 1, fim);
		}
		return vetor;
	}

	private static int particao(int vetor[], int inicio, int fim) {
		int pivo = vetor[fim];
		int indiceMenorElemento = (inicio - 1);
		for (int j = inicio; j < fim; j++) {
			//se elemento <= pivo
			if (vetor[j] <= pivo) {
				indiceMenorElemento++;

				// swap arr[i] and arr[j]
				int temp = vetor[indiceMenorElemento];
				vetor[indiceMenorElemento] = vetor[j];
				vetor[j] = temp;
			}
		}

		//troca vetor[i+1] com o vetor[fim] (ou pivo)
		int auxiliar = vetor[indiceMenorElemento + 1];
		vetor[indiceMenorElemento + 1] = vetor[fim];
		vetor[fim] = auxiliar;

		return indiceMenorElemento + 1;
	}

	// ======================CocktailSort======================

	// modo de funcionamento:
	// https://upload.wikimedia.org/wikipedia/commons/e/ef/Sorting_shaker_sort_anim.gif

	public static int[] cocktailSort(int[] vetor) {
		int tamanho, inicio, fim, swap, aux;
		tamanho = vetor.length;
		inicio = 0;
		fim = tamanho - 1;
		swap = 0;

		while (swap == 0 && inicio < fim) {

			swap = 1;

			// indo da esquerda pra direita
			for (int i = inicio; i < fim; i = i + 1) {
				if (vetor[i] > vetor[i + 1]) {
					aux = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = aux;
					swap = 0;
				}
			}
			fim = fim - 1;

			// indo da direita pra esquerda
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

	// ======================MergeSort======================

	// Faz merge de dois subarrays de um vetor[]
	// O primeiro subarray vai de [inicio..meio]
	// O segundo subarray vai de [meio+1..fim]

	// https://www.geeksforgeeks.org/merge-sort/
	// https://pt.wikipedia.org/wiki/Merge_sort

	// funcao responsavel por ordenar o array usando merge()
	public static int[] mergeSort(int vetor[], int indiceInicio, int indiceFim) {
		if (indiceInicio < indiceFim) {
			// encontra o meio
			int meio = (indiceInicio + indiceFim) / 2;

			// ordena a primeira e a segunda metade
			mergeSort(vetor, indiceInicio, meio);
			mergeSort(vetor, meio + 1, indiceFim);

			// Merge the sorted halves
			merge(vetor, indiceInicio, meio, indiceFim);
		}
		return vetor;
	}

	private static void merge(int vetor[], int indiceInicio, int meio, int indiceFim) {

		// Find sizes of two subarrays to be merged
		// encontra o tamanho dos 2 subarrays a sofrerem o merge
		int tamanhoVetorEsquerda = meio - indiceInicio + 1;
		int tamanhoVetorDireita = indiceFim - meio;

		// Criando os arrays temporarios
		int temporarioEsquerda[] = new int[tamanhoVetorEsquerda];
		int temporarioDireita[] = new int[tamanhoVetorDireita];

		// copia os dados para arrays temporarios
		for (int i = 0; i < tamanhoVetorEsquerda; ++i)
			temporarioEsquerda[i] = vetor[indiceInicio + i];
		for (int j = 0; j < tamanhoVetorDireita; ++j)
			temporarioDireita[j] = vetor[meio + 1 + j];

		/* Merge the temp arrays */

		// indice inicial do primeiro e segundo subarrays
		int i = 0, j = 0;

		int k = indiceInicio;

		// juncao das listas ordenadas
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
		// append de dados que nao foram usados na juncao
		while (i < tamanhoVetorEsquerda) {
			vetor[k] = temporarioEsquerda[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		// append de dados que nao foram usados na juncao
		while (j < tamanhoVetorDireita) {
			vetor[k] = temporarioDireita[j];
			j++;
			k++;
		}
	}

	// ======================HeapSort======================

	// https://www.youtube.com/watch?v=QdRL3XLyiVc
	// https://www.youtube.com/watch?v=zSYOMJ1E52A

	public static int[] heapSort(int vetor[]) {
		int i, auxiliar;
		int tamanhoVetor = vetor.length;
		
		//cria heap a partir dos dados
		for (i = (tamanhoVetor - 1) / 2; i >= 0; i--) {
			criaHeap(vetor, i, tamanhoVetor - 1);
		}

		//pega o maior elemento da heap
		// e coloca na sua posicao
		//correspondente no array
		for (i = tamanhoVetor - 1; i >= 1; i--) {
			auxiliar = vetor[0];
			vetor[0] = vetor[i];
			vetor[i] = auxiliar;

			//reconstroi o heap
			criaHeap(vetor, 0, i - 1);
		}

		return vetor;
	}

	//estrutura os elementos em formato de arvore
	private static void criaHeap(int vetor[], int inicio, int fim) {
		int auxiliar = vetor[inicio]; //vetor[inicio] eh o pai

		int filho = inicio * 2 + 1; //calculando o primeiro filho

		while (filho <= fim) {
			if (filho < fim) {
				// Pai tem dois filhos, verifica
				// quem eh o maior
				if (vetor[filho] < vetor[filho + 1]) {
					filho = filho + 1;
				}
			}
			// Confere se filho eh maior
			// que o pai. Se for o caso,
			// o filho vira o pai
			if (auxiliar < vetor[filho]) {
				vetor[inicio] = vetor[filho];
				inicio = filho;
				filho = 2 * inicio + 1;
			} else {
				filho = fim + 1;
			}
		}
		
		// Antigo pai ocupa o lugar
		// do ultimo filho analisado
		vetor[inicio] = auxiliar;
	}

}