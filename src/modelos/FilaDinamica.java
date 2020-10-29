/**
 * Queue Implementation using Linked List
 * @author Ramesh Fadatare
 *
 */

//creditos:
//https://www.javaguides.net/2018/09/queue-implementation-using-linked-list-in-java.html

package modelos;

public class FilaDinamica{
	
    private int tamanho;
    private No inicio, fim;
    
    private class No { 

		int dado; 
		No proximo;

		No(int d) { 
			dado = d; 
			proximo = null; 
		} 
	}
 
    public FilaDinamica(){
         tamanho = 0;
         inicio = fim = null;
    }

    //  Adds the specified data to the rear of the queue.
    public void enfileirar (int dado){
         No no = new No(dado);
         if (vazia())
              inicio = no;
         else
              fim.proximo = no;
         fim = no;
         tamanho++;
    }

    //  Removes the data at the front of the queue and returns a
    //  reference to it. Throws an Exception if the
    //  queue is empty.

    public int desenfileirar() throws Exception{
        if (vazia())
              throw new Exception("Fila vazia.");
        int result = inicio.dado;
        inicio = inicio.proximo;
        tamanho--;
        if (vazia())
             fim = null;
        return result;
    }

    //pega o primeiro valor da fila. Detalhe:
    //esse metodo nao remove o valor da fila
    public int primeiro() throws Exception{
        if (vazia())
            throw new Exception("Fila vazia."); 

        return inicio.dado;
    }

    public boolean vazia(){
         return (tamanho == 0);
    }

    public int tamanho(){
        return tamanho;
    }
    
    public void exibirFila() {
		No noAtual = inicio;

		System.out.print("\nFila: "); 

		while (noAtual != null) { 
			System.out.print(noAtual.dado + " "); 

			noAtual = noAtual.proximo; 
		} 
		System.out.println("\n");
	}
 
}