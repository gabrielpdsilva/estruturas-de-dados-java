package modelos;

public class FilaEstatica {
	
	public int tamanhoDaFila;
	int inicio;
	int fim;
	int quantidadeDeElementos;
	Object filaDeElementos[];
	
	public FilaEstatica (int tamanhoDaFila) {
		this.tamanhoDaFila = tamanhoDaFila;
		this.inicio = 0;
		this.fim = 0;
		this.quantidadeDeElementos = 0;
		
		this.filaDeElementos = new Object[tamanhoDaFila];
	}

	public boolean vazia() {
		if(quantidadeDeElementos == 0)
			return true;
		else
			return false;
	}

	public boolean cheia() {
		if(quantidadeDeElementos >= tamanhoDaFila)
			return true;
		else
			return false;
	}

	public void enfileirar(Object elemento) {
		if(!cheia()) {
			
			filaDeElementos[fim] = elemento;
			fim++;
			quantidadeDeElementos++;
			
			if(quantidadeDeElementos >= tamanhoDaFila) fim = 0;
			
		} else {
			System.out.println("Fila cheia");
		}
	}

	public Object desenfileirar() {
		
		Object excluido;
		
		if(!vazia()) {
			excluido = filaDeElementos[inicio];
			inicio++;
			
			if(inicio >= tamanhoDaFila)
				inicio = 0;
			
			quantidadeDeElementos--;
			
			return excluido;
			
		} else {
			excluido = null;
			return excluido;
		}
	}

	public void exibir() {
		for(int i = 0; i < quantidadeDeElementos; i++){
			System.out.println("Posicao " + i + " -> " + filaDeElementos[i]);
		}
	}
}