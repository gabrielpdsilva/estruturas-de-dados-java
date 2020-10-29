package modelos;

public class PilhaEstatica {
	
	public int tamanho;
	int topo;
	Object vetorDeElementos[];
	
	public PilhaEstatica(int tamanho) {
		topo = -1;
		this.tamanho = tamanho;
		vetorDeElementos = new Object[tamanho];
	}

	public boolean vazia() {
		if(topo < 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean cheia() {
		if(topo >= (tamanho-1)) {
			return true;
		} else {
			return false;
		}
			
	}

	public void empilhar(Object elemento) {
		if(!cheia()){
			topo++;
			vetorDeElementos[topo] = elemento;
		} else {
			System.out.println("Pilha cheia");
		}
	}

	public Object desempilhar() {
		
		Object valorDesempilhado;
		
		if(vazia()) {
			
			System.out.println("Pilha vazia");
			valorDesempilhado = null;
			
			return valorDesempilhado;
			
		} else{
			
			valorDesempilhado = vetorDeElementos[topo];
			topo--;
			
			return valorDesempilhado;
		}
	}

	public void exibir(){
		for(int i = topo; i >= 0; i--) {
			System.out.println("Elemento " + vetorDeElementos[i] + ", posição: " + i);
		}
	}
	
	public Object exibirTopo() {
        if(vazia())
            return null;
        
        return vetorDeElementos[topo];
    }

}