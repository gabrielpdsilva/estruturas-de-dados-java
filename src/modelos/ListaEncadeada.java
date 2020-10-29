package modelos;

public class ListaEncadeada { 

	No cabeca;
	int tamanho;
	
	public ListaEncadeada() {
		this.cabeca = null;
		this.tamanho = 0;
	}

	private class No { 

		Object dado; 
		No proximo; 

		No(Object d) { 
			dado = d; 
			proximo = null; 
		} 
	}

	// **************INSERIR NO FINAL************** 

	public void inserirNoFinal(Object dado) {
		
		No novoNo = new No(dado);
		novoNo.proximo = null;
		
		if(vazia())
			this.cabeca = novoNo;
		
		else {
			
			No ultimo = this.cabeca;
			while (ultimo.proximo != null) {
				ultimo = ultimo.proximo; 
			} 

			ultimo.proximo = novoNo; 
		}
		this.tamanho++;
	
	} 
	
	// **************INSERIR NO INICIO************** 
	
	public void inserirNoInicio(Object dado) {
		
		No novoNo = new No(dado);
		if (vazia())
			cabeca = novoNo;
		else
			novoNo.proximo = cabeca;
		cabeca = novoNo;
		this.tamanho++;
	}
	
	public boolean vazia() {
		return tamanho == 0;
	}
	
	
	
	// **************PEGA VALOR DA POSICAO ESPECIFICADA************** 
	
	public Object valorNaPosicao(int indice) {
		
		if(indice > tamanho)
			throw new IllegalArgumentException("Posicao invalida.");
		
		int i = 0;
		No noTemporario = this.cabeca;
		for(i = 0; i < indice; i++) {
			noTemporario = noTemporario.proximo;
		}
		return noTemporario.dado;
		
	}	
	

	// **************EXIBIR LISTA************** 

	public void exibirLista() {
		No noAtual = cabeca;

		System.out.print("\nLinkedList: "); 

		while (noAtual != null) { 
			System.out.print(noAtual.dado + " "); 

			noAtual = noAtual.proximo; 
		} 
		System.out.println("\n");
	}
	
	// **************CONFERE SE EXISTE UM VALOR ESPECIFICO NA LISTA************** 
	public boolean existeOValor(Object valor) {
		
		No noAtual = cabeca;
		
		while(noAtual != null) {
			
			if(noAtual.dado == valor)
				return true;
			
			noAtual = noAtual.proximo;
			
		}
		
		return false;
	}
	
	
	// **************ADICIONA VALOR NA POSICAO ESPECIFICADA************** 
	
	public void inserirValor(int indice, Object valor)	{
		
		if (indice > tamanho || indice < 0)
			throw new IndexOutOfBoundsException("Posicao invalida.");		
		
		if(indice == 0) {
			inserirNoInicio(valor);
			return;
		}
		
		int posicaoAuxiliar;
		No noTemporario = cabeca;
		No novoNo = new No(valor);
		
		if(indice <= tamanho) {
			posicaoAuxiliar = 1;
			while(noTemporario != null && indice > posicaoAuxiliar) {
				noTemporario = noTemporario.proximo;
				posicaoAuxiliar++;
			}
			novoNo.proximo = noTemporario.proximo;
			noTemporario.proximo = novoNo;
		}
		
		this.tamanho++;
	}
	
	

	// **************DELETAR POR VALOR************** 

	public Object deletarPorValor(Object valor) { 
		
		No noAtual = cabeca, anterior = null; 

		// 
		// CASE 1: 
		// se a cabeca tem o valor a ser deletado

		if (noAtual != null && noAtual.dado == valor) { 
			cabeca = noAtual.proximo;

			System.out.println(valor + " encontrado e deletado."); 

			this.tamanho--;
			return valor; 
		} 

		// 
		// CASE 2: 
		// valor esta em outro lugar que nao seja a cabeca
		// 

		while (noAtual != null && noAtual.dado != valor) { 
			anterior = noAtual; 
			noAtual = noAtual.proximo; 
		} 

		if (noAtual != null) { 
			anterior.proximo = noAtual.proximo; 

			System.out.println(valor + " encontrado e deletado.");
			this.tamanho--;
		} 

		// 
		// CASE 3: valor nao foi encontrado
		// 

		if (noAtual == null) { 
			System.out.println(valor + " nao foi encontrado."); 
		} 

		return null;
	}
	
	public int tamanho(){ return tamanho; }

	// **************DELETAR NUMA POSICAO ESPECIFICA************** 

	public Object deletarNaPosicao(int indice) { 
		
		No noAtual = cabeca, anterior = null; 

		// 
		// CASE 1: 
		// se indice = 0, entao eh o proprio no cabeca que sera deletado

		if (indice == 0 && noAtual != null) { 
			cabeca = noAtual.proximo; 

			System.out.println(indice + "o posicao foi deletada.");
			this.tamanho--;

			return 0;

		} 

		// 
		// CASE 2: 
		// indice > 0 e < tamanho da lista
		
		
		int contador = 0; 

		while (noAtual != null) { 

			if (contador == indice) { 
				// Since the currNode is the required position 
				// Unlink currNode from linked list 
				anterior.proximo = noAtual.proximo; 

				System.out.println(" Elemento da posicao " + indice + " deletado.");
				this.tamanho--;
				break; 
			} 
			else { 
				//posicao atual nao eh o indice
				anterior = noAtual; 
				noAtual = noAtual.proximo; 
				contador++; 
			} 
		} 

		//se a posicao do elemento foi encontrada, eh o no atual.
		//Assim, no atual nao pode ser nulo
		//
		// CASE 3: indice maior que tamanho da lista
		// 
		if (noAtual == null) { 
			System.out.println("Elemento da posicao " + indice + " nao foi encontrado."); 
		} 

		return null; 
	}

} 
