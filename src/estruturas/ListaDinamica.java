package estruturas;

public class ListaDinamica {
    private int[] elementos;
    private int tamanho;
    private int capacidade;
    
    public ListaDinamica() {
        this.capacidade = 10;
        this.elementos = new int[capacidade];
        this.tamanho = 0;
    }
    
    public void adicionar(int valor) {
        if (tamanho == capacidade) {
            redimensionar();
        }
        elementos[tamanho] = valor;
        tamanho++;
    }
    
    private void redimensionar() {
        capacidade = capacidade * 2;
        int[] novoArray = new int[capacidade];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[i];
        }
        elementos = novoArray;
    }
    
    public int obter(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return elementos[indice];
    }
    
    public int getTamanho() {
        return tamanho;
    }
    
    public int[] toArray() {
        int[] resultado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            resultado[i] = elementos[i];
        }
        return resultado;
    }
}
