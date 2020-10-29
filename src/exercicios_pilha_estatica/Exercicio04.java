package exercicios_pilha_estatica;

import modelos.PilhaEstatica;

/**
 * Desenvolva uma função para inverter a posição dos elementos de uma pilha P.
 * @author G.P.
 *
 */

public class Exercicio04 {
	
	public static PilhaEstatica inverterPilha(PilhaEstatica pilhaOriginal) {
		
		PilhaEstatica pilhaInvertida = new PilhaEstatica(pilhaOriginal.tamanho);
		
		do {
			
			pilhaInvertida.empilhar(pilhaOriginal.desempilhar());
			
		}while(!pilhaOriginal.vazia());
		
		return pilhaInvertida;
		
	}

}
