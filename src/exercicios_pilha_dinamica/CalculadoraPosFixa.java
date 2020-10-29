package exercicios_pilha_dinamica;

import modelos.PilhaEncadeadaInt;

public class CalculadoraPosFixa {

	public static int calcular(String expressao) {

		PilhaEncadeadaInt pilha = new PilhaEncadeadaInt();

		String[] valores = expressao.split("");
		
		int resultadoOperacao = 0;

		for (String valor : valores) {

			int auxiliar1;
			int auxiliar2;
			
			if (ehNumero(valor)) {

				pilha.empilhar(Integer.parseInt(valor));
				
			} else {

				if (valor.equals("+")) {

					auxiliar1 = pilha.desempilhar();
					auxiliar2 = pilha.desempilhar();
					resultadoOperacao = auxiliar2 + auxiliar1;
					pilha.empilhar(resultadoOperacao);

				} else if (valor.equals("-")) {

					auxiliar1 = pilha.desempilhar();
					auxiliar2 = pilha.desempilhar();
					resultadoOperacao = auxiliar2 - auxiliar1;
					pilha.empilhar(resultadoOperacao);

				} else if (valor.equals("*")) {

					auxiliar1 = pilha.desempilhar();
					auxiliar2 = pilha.desempilhar();
					resultadoOperacao = auxiliar2 * auxiliar1;
					pilha.empilhar(resultadoOperacao);

				} else if (valor.equals("/")) {

					auxiliar1 = pilha.desempilhar();
					auxiliar2 = pilha.desempilhar();
					resultadoOperacao = auxiliar2 / auxiliar1;
					pilha.empilhar(resultadoOperacao);

				}
			}

		}


		return resultadoOperacao;

	}

	public static boolean ehNumero(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {

		//System.out.println(calcular("43+21-/"));
		System.out.println(calcular("85+3-"));
	}

}
