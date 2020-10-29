package exercicios_pilha_estatica;

import modelos.PilhaEstatica;

/**
 * Considere uma pilha que armazene caracteres. Escreva uma função que verifique se uma palavra é um palíndromo.
 * @author G.P.
 *
 */

public class Exercicio07 {
	
	public static boolean ehPalindromo(PilhaEstatica pilhaOriginal) {
		
		PilhaEstatica pilhaInvertida = new PilhaEstatica(pilhaOriginal.tamanho);
		
		String palavraOriginal = "";
		
		String palavraInvertida = "";
		
		do {
			
			//vai montando a palavra com base no topo da pilha
			palavraOriginal += pilhaOriginal.exibirTopo();
			
			//desempilha a pilha original, preenchendo a invertida
			pilhaInvertida.empilhar(pilhaOriginal.desempilhar());
			
		}while(!pilhaOriginal.vazia());
		
		do {
			palavraInvertida += pilhaInvertida.exibirTopo();
			pilhaInvertida.desempilhar();
		}while(!pilhaInvertida.vazia());
		
		//compara se a palavra formada da pilha original
		//eh igual a palavra formada da pilha invertida
		if(palavraOriginal.equals(palavraInvertida))
			return true;
				
		return false;
	}
	
}