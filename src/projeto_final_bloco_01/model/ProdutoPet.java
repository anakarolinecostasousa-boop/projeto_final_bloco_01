package projeto_final_bloco_01.model;

public class ProdutoPet extends Produto {

    public ProdutoPet(int id, String nome, int tipo, float preco) {
        super(id, nome, tipo, preco);
    }
    
    @Override
    public void visualizar() {
        super.visualizar();
        // Aqui você poderia adicionar informações específicas da classe filha se houver
    }
}