package exercicios_pilha_estatica;

import modelos.PilhaEstatica;
import modelos.FilaEstatica;

/**
 * Considere uma pilha P vazia e uma fila F n�o vazia. Utilizando apenas as fun��es da fila e da pilha, escreva uma fun��o que inverta a ordem dos elementos da fila.
 * @author G.P.
 *
 */

public class Exercicio06 {
	
	public static FilaEstatica inverterFila(FilaEstatica fila) {
		
		PilhaEstatica pilha = new PilhaEstatica(fila.tamanhoDaFila);
		
		do {
			pilha.empilhar(fila.desenfileirar());
		}while(!fila.vazia());
		
		do {
			fila.enfileirar(pilha.desempilhar());
		}while(!pilha.vazia());
		
		return fila;	
	}

}