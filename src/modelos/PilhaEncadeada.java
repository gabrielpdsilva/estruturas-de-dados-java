package modelos;

import java.util.EmptyStackException;

//site excelente sobre pilha encadeada
//https://www.javaguides.net/2018/09/stack-implementation-using-linked-list-in-java.html

public class PilhaEncadeada {
	
	private class No {
		
		Object dado;
		No proximo;
		
		No(Object d) {
			dado = d;
		}

	}
	
	No topo;
	public int tamanho;
	
	public PilhaEncadeada() {
		this.topo = null;
		this.tamanho = 0;
	}
	
	public void empilhar(Object dado) {
		
		No no = new No(dado);
		no.proximo = topo;
		this.topo = no;
		tamanho++;
		
	}
	
	public Object desempilhar() throws EmptyStackException {
		
		if(vazia())
			throw new EmptyStackException();
		
		Object valorDesempilhado = topo.dado;
		topo = topo.proximo;
		tamanho--;

		return valorDesempilhado;
	}
	
	public Object exibirTopo() throws EmptyStackException {
		
		if(vazia())
			throw new EmptyStackException();
		
		return topo.dado;
	}
	
	public boolean vazia() {
		return (tamanho == 0);
	}
	
	public void exibir() {
		
		No noAuxiliar = topo; //no pra ficar percorrendo ate o fim da pilha
		while(noAuxiliar != null) {
			System.out.println(noAuxiliar.dado);
			noAuxiliar = noAuxiliar.proximo;
		}
		
	}

}