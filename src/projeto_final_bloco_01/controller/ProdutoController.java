package projeto_final_bloco_01.controller;

import java.util.ArrayList;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    int idContador = 0;

    @Override
    public void procurarPorId(int id) {
        var produto = buscarNaCollection(id);

        if (produto != null)
            produto.visualizar();
        else
            System.out.println("\nO produto ID: " + id + " não foi encontrado!");
    }

    @Override
    public void listarTodos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("\nA lista está vazia!");
        } else {
            for (var produto : listaProdutos) {
                produto.visualizar();
            }
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        listaProdutos.add(produto);
        System.out.println("\nProduto " + produto.getNome() + " cadastrado com sucesso!");
    }

    @Override
    public void atualizar(Produto produto) {
        var buscaProduto = buscarNaCollection(produto.getId());

        if (buscaProduto != null) {
            listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
            System.out.println("\nO Produto ID: " + produto.getId() + " foi atualizado!");
        } else {
            System.out.println("\nO Produto ID: " + produto.getId() + " não foi encontrado!");
        }
    }

    @Override
    public void deletar(int id) {
        var produto = buscarNaCollection(id);

        if (produto != null) {
            if (listaProdutos.remove(produto))
                System.out.println("\nO Produto ID: " + id + " foi deletado!");
        } else {
            // Aqui simulamos o tratamento de erro
            System.err.println("\nErro: Não foi possível deletar. O ID: " + id + " não existe!");
        }
    }

    // Métodos Auxiliares
    public int gerarId() {
        return ++idContador;
    }

    public Produto buscarNaCollection(int id) {
        for (var produto : listaProdutos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
}