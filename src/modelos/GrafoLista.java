package modelos;

import java.util.Iterator;
import java.util.LinkedList;

//Fonte(s):
//https://www.youtube.com/watch?v=Q1sjVuP3bZg
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

public class GrafoLista {

	private int vertices;
	private boolean bidimensional;

	LinkedList<Integer> lista[];

	public GrafoLista(int vertices, boolean bidimensional) {

		this.vertices = vertices;
		this.bidimensional = bidimensional;
		lista = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			lista[i] = new LinkedList<>();
		}
	}

	public void adicionarAresta(int fonte, int destino) {
		if (!lista[fonte].contains(destino))
			lista[fonte].add(destino);

		if (bidimensional)
			lista[destino].add(fonte);
	}

	public void removerAresta(int fonte, int destino) {
		if (lista[fonte].contains(destino))
			lista[fonte].remove(destino);

		if (bidimensional)
			lista[destino].remove(fonte);
	}

	public boolean temAresta(int fonte, int destino) {
		if (lista[fonte].contains(destino))
			return true;
		return false;
	}

	public void exibir() {
		for (int i = 0; i < vertices; i++) {
			if (lista[i].size() > 0) {
				System.out.println("Vertice " + i + " conectado a:");

				for (int j = 0; j < lista[i].size(); j++) {
					System.out.println(lista[i].get(j) + " ");
				}
				System.out.println();
			}
		}
	}

	public void buscaEmLargura(int fonte) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visitado[] = new boolean[vertices];

		LinkedList<Integer> fila = new LinkedList<Integer>();

		// marca o no como visitado e joga na fila
		visitado[fonte] = true;
		fila.add(fonte);

		while (fila.size() != 0) {
			// desenfileira o vertice da fila e printa-o
			fonte = fila.poll();
			System.out.print(fonte + " ");

			// pega todos os vertices adjacentes do vertice desenfileirado s
			// se alguma adjacencia nao for visitada, marque-a
			// como visitada e enfileire-a
			Iterator<Integer> i = lista[fonte].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visitado[n]) {
					visitado[n] = true;
					fila.add(n);
				}
			}
		}
	}

	// funcao usada pelo metodo 'buscaEmProfundidade'
	private void buscaEmLarguraAuxiliar(int inicio, boolean visitado[]) {
		visitado[inicio] = true;
		System.out.print(inicio + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = lista[inicio].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visitado[n])
				buscaEmLarguraAuxiliar(n, visitado);
		}
	}

	public void buscaEmProfundidade(int inicio) {
		
		//por padrao sera tudo setado como false
		boolean visitado[] = new boolean[vertices];

		buscaEmLarguraAuxiliar(inicio, visitado);
	}

	public static void main(String[] args) {
		GrafoLista gf = new GrafoLista(5, true);
		gf.adicionarAresta(0, 1);
		gf.adicionarAresta(1, 2);
		gf.adicionarAresta(3, 4);
		gf.adicionarAresta(3, 0);
		gf.adicionarAresta(0, 4);
		gf.adicionarAresta(4, 2);
		System.out.println(gf.temAresta(1, 0));
		gf.exibir();
		gf.buscaEmLargura(3);
		System.out.println();
		gf.buscaEmProfundidade(3);

	}

}
