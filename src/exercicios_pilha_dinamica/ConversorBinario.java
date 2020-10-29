package exercicios_pilha_dinamica;

import modelos.PilhaEncadeada;

/**
 * A conversão de um valor decimal para o seu correspondente em
 * binário se dá pelas sucessivas divisões dele por 2 até que o
 * quociente seja 0. O representante binário desse número será
 * composto por todos os restos, mas na ordem inversa à que foram
 * calculados. Elabore um algoritmo e um programa capazes de
 * resolver essa questão utilizando o conceito de pilhas. O número
 * deverá ser fornecido pelo usuário.
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
