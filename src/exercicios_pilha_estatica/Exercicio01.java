package exercicios_pilha_estatica;

import modelos.PilhaEstatica;

/**
 * Desenvolva uma função para testar se uma pilha P1 tem mais elementos que uma pilha P2.
 * @author G.P.
 *
 */

public class Exercicio01 {
	
	public static boolean pilhaUmMaiorQuePilhaDois(PilhaEstatica pilha1, PilhaEstatica pilha2) {
		
		if(pilha1.tamanho > pilha2.tamanho)
			return true;
		
		return false;
	}

}