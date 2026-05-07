package projeto_final_bloco_01;

public abstract class Produto {
    private int id;
    private String nome;
    private int tipo; // 1-Ração, 2-Acessório
    private float preco;

    public Produto(int id, String nome, int tipo, float preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    // Getters e Setters
    // Método visualizar() para polimorfismo
    public void visualizar() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Preço: R$" + preco);
    }
}