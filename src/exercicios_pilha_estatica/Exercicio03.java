package exercicios_pilha_estatica;

import modelos.PilhaEstatica;

/**
 * Desenvolva uma operação para transferir elementos de uma pilha P1 para uma pilha P2 (cópia).
 * @author G.P.
 *
 */

public class Exercicio03 {
	
	public static PilhaEstatica transferirElementos(PilhaEstatica pilhaOriginal) {
		
		PilhaEstatica pilhaAuxiliar = new PilhaEstatica(pilhaOriginal.tamanho);
		
		do {
			
			pilhaAuxiliar.empilhar(pilhaOriginal.desempilhar());
			
		}while(!pilhaOriginal.vazia());
		
		
		PilhaEstatica novaPilha = new PilhaEstatica(pilhaAuxiliar.tamanho);
		
		do {
			
			novaPilha.empilhar(pilhaAuxiliar.desempilhar());
			
		}while(!pilhaAuxiliar.vazia());
		
		return novaPilha;
	}

}