package exercicios_pilha_estatica;

import javax.swing.JOptionPane;

import modelos.PilhaEstatica;

/**
 * Leia cem n�meros e construa uma pilha apenas com os n�meros pares.
 * @author G.P.
 *
 */

public class Exercicio08 {
	
	public static void main(String[] args) {

		PilhaEstatica pilha = new PilhaEstatica(100);

		int valorDigitado;
		
		for(int i = 0; i < 100; i++) {
			
			try {
				
				valorDigitado = Integer.parseInt(JOptionPane.showInputDialog("Digite: "));
				
				if(valorDigitado % 2 == 0)
					pilha.empilhar(valorDigitado);
			
			} catch (NumberFormatException e) {
				System.out.println("Voc� n�o digitou um valor v�lido!");
				
			}	
		}
	}
	
}