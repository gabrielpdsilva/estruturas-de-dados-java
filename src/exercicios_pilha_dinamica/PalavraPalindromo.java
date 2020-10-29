package exercicios_pilha_dinamica;

import modelos.PilhaEncadeada;

/*
 * Verificar se uma palavra eh ou nao palindromo
 * usando pilhas
 */

public class PalavraPalindromo {
	
	public static boolean palindromo(PilhaEncadeada pilha){
		
		String palavraNormal = "";
		String palavraReversa = "";
		
		PilhaEncadeada novaPilha = new PilhaEncadeada();
		
		Object valorRemovido;
		
		while(!pilha.vazia()){
			
			valorRemovido = pilha.desempilhar();
			novaPilha.empilhar(valorRemovido);
			palavraNormal += valorRemovido;
			
		}
		
		while(!novaPilha.vazia()){
			valorRemovido = novaPilha.desempilhar();
			palavraReversa += valorRemovido;
			
		}
		
		System.out.println(palavraNormal);
		System.out.println(palavraReversa);
		
		if(palavraNormal.equals(palavraReversa))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		PilhaEncadeada pilha = new PilhaEncadeada();
		pilha.empilhar('A');
		pilha.empilhar('B');
		pilha.empilhar('B');		
		pilha.empilhar('A');
		
		System.out.println(palindromo(pilha));
		
	}

}
