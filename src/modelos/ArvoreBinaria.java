/* Criado por: profa. Divani Barbosa Gavinier
   Curriculo Lattes: http://lattes.cnpq.br/8503400830635447
   divanibarbosa@gmail.com
*/

//Codigo retirado originalmente do github com a devida permissao:
//https://gist.github.com/divanibarbosa/819e7cfcf1b9bae48c4e0f5bd74fb658

package modelos;

public class ArvoreBinaria {
	
	private No root; // raiz
	
	private class No {
		public int dado;
		public No direita;
		public No esquerda;
		
	}

	public ArvoreBinaria() {
		root = null;
	} // inicializa arvore

	public void inserir(int v) {
		No novo = new No(); // cria um novo Nó
		novo.dado = v; // atribui o valor recebido ao item de dados do Nó
		novo.direita = null;
		novo.esquerda = null;

		if (root == null)
			root = novo;
		else { // se nao for a raiz
			No atual = root;
			No anterior;
			while (true) {
				anterior = atual;
				if (v <= atual.dado) { // ir para esquerda
					atual = atual.esquerda;
					if (atual == null) {
						anterior.esquerda = novo;
						return;
					}
				} // fim da condição ir a esquerda
				else { // ir para direita
					atual = atual.direita;
					if (atual == null) {
						anterior.direita = novo;
						return;
					}
				} // fim da condição ir a direita
			} // fim do laço while
		} // fim do else não raiz

	}

	public No buscar(int chave) {
		if (root == null)
			return null; // se arvore vazia
		No atual = root; // começa a procurar desde raiz
		while (atual.dado != chave) { // enquanto nao encontrou
			if (chave < atual.dado)
				atual = atual.esquerda; // caminha para esquerda
			else
				atual = atual.direita; // caminha para direita
			if (atual == null)
				return null; // encontrou uma folha -> sai
		} // fim laço while
		return atual; // terminou o laço while e chegou aqui é pq encontrou item
	}

	public boolean remover(int valor) {
		if (root == null)
			return false; // se arvore vazia

		No atual = root;
		No pai = root;
		boolean filho_esq = true;

		// ****** Buscando o valor **********
		while (atual.dado != valor) { // enquanto nao encontrou
			pai = atual;
			if (valor < atual.dado) { // caminha para esquerda
				atual = atual.esquerda;
				filho_esq = true; // é filho a esquerda? sim
			} else { // caminha para direita
				atual = atual.direita;
				filho_esq = false; // é filho a esquerda? NAO
			}
			if (atual == null)
				return false; // encontrou uma folha -> sai
		} // fim laço while de busca do valor

		// **************************************************************
		// se chegou aqui quer dizer que encontrou o valor (v)
		// "atual": contem a referencia ao No a ser eliminado
		// "pai": contem a referencia para o pai do No a ser eliminado
		// "filho_esq": é verdadeiro se atual é filho a esquerda do pai
		// **************************************************************

		// Se nao possui nenhum filho (é uma folha), elimine-o
		if (atual.esquerda == null && atual.direita == null) {
			if (atual == root)
				root = null; // se raiz
			else if (filho_esq)
				pai.esquerda = null; // se for filho a esquerda do pai
			else
				pai.direita = null; // se for filho a direita do pai
		}

		// Se é pai e nao possui um filho a direita, substitui pela subarvore a
		// direita
		else if (atual.direita == null) {
			if (atual == root)
				root = atual.esquerda; // se raiz
			else if (filho_esq)
				pai.esquerda = atual.esquerda; // se for filho a esquerda do pai
			else
				pai.direita = atual.esquerda; // se for filho a direita do pai
		}

		// Se é pai e nao possui um filho a esquerda, substitui pela subarvore a
		// esquerda
		else if (atual.esquerda == null) {
			if (atual == root)
				root = atual.direita; // se raiz
			else if (filho_esq)
				pai.esquerda = atual.direita; // se for filho a esquerda do pai
			else
				pai.direita = atual.direita; // se for filho a direita do pai
		}

		// Se possui mais de um filho, se for um avô ou outro grau maior de
		// parentesco
		else {
			No sucessor = no_sucessor(atual);
			// Usando sucessor que seria o Nó mais a esquerda da subarvore a
			// direita do No que deseja-se remover
			if (atual == root)
				root = sucessor; // se raiz
			else if (filho_esq)
				pai.esquerda = sucessor; // se for filho a esquerda do pai
			else
				pai.direita = sucessor; // se for filho a direita do pai
			sucessor.esquerda = atual.esquerda; // acertando o ponteiro a esquerda do
										// sucessor agora que ele assumiu
										// a posição correta na arvore
		}

		return true;
	}

	// O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi
	// passado como parametro do metodo
	public No no_sucessor(No apaga) { // O parametro é a referencia para o No
										// que deseja-se apagar
		No paiDoSucessor = apaga;
		No sucessor = apaga;
		No atual = apaga.direita; // vai para a subarvore a direita

		while (atual != null) { // enquanto nao chegar no Nó mais a esquerda
			paiDoSucessor = sucessor;
			sucessor = atual;
			atual = atual.esquerda; // caminha para a esquerda
		}
		// *********************************************************************************
		// quando sair do while "sucessor" será o Nó mais a esquerda da
		// subarvore a direita
		// "paidosucessor" será o o pai de sucessor e "apaga" o Nó que deverá
		// ser eliminado
		// *********************************************************************************
		if (sucessor != apaga.direita) { // se sucessor nao é o filho a direita do
										// Nó que deverá ser eliminado
			paiDoSucessor.esquerda = sucessor.direita; // pai herda os filhos do sucessor
												// que sempre serão a direita
			// lembrando que o sucessor nunca poderá ter filhos a esquerda,
			// pois, ele sempre será o
			// Nó mais a esquerda da subarvore a direita do Nó apaga.
			// lembrando também que sucessor sempre será o filho a esquerda do
			// pai

			sucessor.direita = apaga.direita; // guardando a referencia a direita do
										// sucessor para
										// quando ele assumir a posição correta
										// na arvore
		}
		return sucessor;
	}

	public void caminhar() {
		System.out.print("\n Exibindo em ordem: ");
		inOrder(root);
		System.out.print("\n Exibindo em pos-ordem: ");
		posOrder(root);
		System.out.print("\n Exibindo em pre-ordem: ");
		preOrder(root);
		System.out.print("\n Altura da arvore: " + altura(root));
		System.out.print("\n Quantidade de folhas: " + folhas(root));
		System.out.print("\n Quantidade de Nós: " + contarNos(root));
		if (root != null) { // se arvore nao esta vazia
			System.out.print("\n Valor minimo: " + min().dado);
			System.out.println("\n Valor maximo: " + max().dado);
		}
	}

	public void inOrder(No atual) {
		if (atual != null) {
			inOrder(atual.esquerda);
			System.out.print(atual.dado + " ");
			inOrder(atual.direita);
		}
	}

	public void preOrder(No atual) {
		if (atual != null) {
			System.out.print(atual.dado + " ");
			preOrder(atual.esquerda);
			preOrder(atual.direita);
		}
	}

	public void posOrder(No atual) {
		if (atual != null) {
			posOrder(atual.esquerda);
			posOrder(atual.direita);
			System.out.print(atual.dado + " ");
		}
	}

	public int altura(No atual) {
		if (atual == null || (atual.esquerda == null && atual.direita == null))
			return 0;
		else {
			if (altura(atual.esquerda) > altura(atual.direita))
				return (1 + altura(atual.esquerda));
			else
				return (1 + altura(atual.direita));
		}
	}

	public int folhas(No atual) {
		if (atual == null)
			return 0;
		if (atual.esquerda == null && atual.direita == null)
			return 1;
		return folhas(atual.esquerda) + folhas(atual.direita);
	}

	public int contarNos(No atual) {
		if (atual == null)
			return 0;
		else
			return (1 + contarNos(atual.esquerda) + contarNos(atual.direita));
	}

	public No min() {
		No atual = root;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.esquerda;
		}
		return anterior;
	}

	public No max() {
		No atual = root;
		No anterior = null;
		while (atual != null) {
			anterior = atual;
			atual = atual.direita;
		}
		return anterior;
	}

}