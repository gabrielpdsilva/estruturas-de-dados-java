package exercicios_pilha_estatica;

import modelos.PilhaEstatica;

/**
 * Descreva a saída da seguinte seqüência sobre a pilha:
 * empilha(5), empilha(3), desempilha(), empilha(2), empilha(8), desempilha(),
 * desempilha(), empilha(9), empilha(1), desempilha(), empilha(7), empilha(6),
 * desempilha(), desempilha(), empilha(4), desempilha(), desempilha().
 * @author G.P.
 *
 */

public class Exercicio09 {
	
	public static void main(String[] args) {
		
		PilhaEstatica pilha = new PilhaEstatica(10);
		
		pilha.empilhar(5);
		pilha.empilhar(3);
		pilha.desempilhar();
		pilha.empilhar(2);
		pilha.empilhar(8);
		pilha.desempilhar();
		
		pilha.desempilhar();
		pilha.empilhar(9);
		pilha.empilhar(1);
		pilha.desempilhar();
		pilha.empilhar(7);
		pilha.empilhar(6);
		
		pilha.desempilhar();
		pilha.desempilhar();
		pilha.empilhar(4);
		pilha.desempilhar();
		pilha.desempilhar();
		
		pilha.exibir();
	}

}