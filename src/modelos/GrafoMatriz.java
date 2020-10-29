package modelos;

//Fonte(s):
//https://www.youtube.com/watch?v=NUAZfvjwc_M

public class GrafoMatriz {
	
	private int vertices;
	private int matriz[][];
	private boolean bidimensional;
	private boolean temPeso;
	
	public GrafoMatriz(int vertices, boolean bidimensional, boolean temPeso) {
		this.vertices = vertices;
		this.bidimensional = bidimensional;
		this.temPeso = temPeso;
		this.matriz = new int[vertices][vertices];
	}
	
	public void adicionarAresta(int fonte, int destino, int peso){
		
		if(!temPeso)
			peso = 1;
		
		matriz[fonte][destino] = peso;
		
		if(bidimensional)
			matriz[destino][fonte] = peso;
		
	}
	
public void adicionarAresta(int fonte, int destino){
		
		if(matriz[fonte][destino] == 1)
			return;
		
		matriz[fonte][destino] = 1;
		
		if(bidimensional)
			matriz[destino][fonte] = 1;
		
	}
	
	public void removerAresta(int fonte, int destino){
		
		if(matriz[fonte][destino] == 0)
			return;
		
		matriz[fonte][destino] = 0;
		
		if(bidimensional)
			matriz[destino][fonte] = 0;
	}
	
	public void exibir(){
		for(int fonte = 0; fonte < vertices; fonte++){
			for(int destino = 0; destino < vertices; destino++)
				System.out.print(matriz[fonte][destino] + " ");
		
			System.out.println();
		}
	}
	
	public int totalVertices(){
		return vertices;
	}
	
	public boolean temAresta(int fonte, int destino) {
		if(matriz[fonte][destino] != 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		GrafoMatriz grafo = new GrafoMatriz(3, false, false);
		grafo.adicionarAresta(0, 1);
		grafo.adicionarAresta(1, 2);
		grafo.adicionarAresta(2, 2);
		grafo.exibir();
		System.out.println(grafo.temAresta(2,  2));
		System.out.println(grafo.totalVertices());
	}

}
