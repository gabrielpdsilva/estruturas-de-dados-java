package exercicios_pilha_dinamica;

import modelos.PilhaEncadeada;

/**
 * A convers�o de um valor decimal para o seu correspondente em
 * bin�rio se d� pelas sucessivas divis�es dele por 2 at� que o
 * quociente seja 0. O representante bin�rio desse n�mero ser�
 * composto por todos os restos, mas na ordem inversa � que foram
 * calculados. Elabore um algoritmo e um programa capazes de
 * resolver essa quest�o utilizando o conceito de pilhas. O n�mero
 * dever� ser fornecido pelo usu�rio.
 * @author G.P.
 *
 */

public class ConversorBinario {
	
	public static String decimalParaBinario(int valorDigitado) {
		
		PilhaEncadeada pilha = new PilhaEncadeada();
		
		int resultadoDaDivisao;
		
		String valorEmBinario = "";
		
		while(valorDigitado > 0) {
			
			resultadoDaDivisao = valorDigitado % 2;
			pilha.empilhar(resultadoDaDivisao);
			valorDigitado = valorDigitado / 2;
			
		}
		
		while(!pilha.vazia())
			valorEmBinario += pilha.desempilhar();
		
		return valorEmBinario;
		
	}

}
