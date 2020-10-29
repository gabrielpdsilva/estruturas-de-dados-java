package exercicios_pilha_estatica;

import modelos.PilhaEstatica;

/**
 * Desenvolva uma função para testar se duas pilhas P1 e P2 são iguais.
 * @author G.P.
 *
 */

public class Exercicio02 {
	
	public static boolean pilhasIguais(PilhaEstatica pilha1, PilhaEstatica pilha2) {
		
		if(pilha1.tamanho != pilha2.tamanho) return false;
		
		Object valorRemovidoPilha1;
		
		Object valorRemovidoPilha2;
		
		do {
			
			valorRemovidoPilha1 = pilha1.desempilhar();
			valorRemovidoPilha2 = pilha2.desempilhar();
			
			if(valorRemovidoPilha1 != valorRemovidoPilha2) return false;
			
		}while(!pilha1.vazia());
		
		return true;
	}

}