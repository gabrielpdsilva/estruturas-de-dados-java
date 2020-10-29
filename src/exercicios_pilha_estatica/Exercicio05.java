package exercicios_pilha_estatica;

import modelos.PilhaEstatica;

/**
 * Faça uma função para retornar o número de elementos da pilha que possui valor par.
 * @author G.P.
 *
 */

public class Exercicio05 {
	
	public static Object retornaElementosDaPilhaPar(PilhaEstatica pilhaOriginal) {
		
		int quantidadeDeElementos = 0;
		
		Object elementoRemovido;
		
		do {
			elementoRemovido = pilhaOriginal.desempilhar();
			quantidadeDeElementos++;
		} while(!pilhaOriginal.vazia());
		
		if(quantidadeDeElementos % 2 != 0)
			return null;
		
		return quantidadeDeElementos;
	}

}
