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
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
    
    // Método visualizar() para polimorfismo
	public void visualizar() {
        String tipoStr = (this.tipo == 1) ? "Ração" : "Acessório";
        System.out.println("*****************************************************");
        System.out.println("Dados do Produto:");
        System.out.println("*****************************************************");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Tipo: " + tipoStr);
        System.out.println("Preço: R$ " + this.preco);
    }

}