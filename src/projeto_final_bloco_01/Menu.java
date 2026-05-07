package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        ProdutoController produtos = new ProdutoController();

        int opcao, id, tipo;
        String nome;
        float preco;

        while (true) {
            System.out.println("*****************************************************");
            System.out.println("            PET SHOP AMANTE DOS PETZ                 ");
            System.out.println("*****************************************************");
            System.out.println("            1 - Cadastrar Produto                    ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Buscar Produto por ID                ");
            System.out.println("            4 - Atualizar Dados do Produto           ");
            System.out.println("            5 - Apagar Produto                       ");
            System.out.println("            0 - Sair                                 ");
            System.out.println("*****************************************************");
            
            try {
                System.out.print("Entre com a opção desejada: ");
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("\nErro: Digite apenas números inteiros!");
                leia.nextLine(); // Limpa o buffer do scanner
                opcao = -1; // Força o switch a cair no default
            }

            if (opcao == 0) {
                System.out.println("\nAmante dos Petz - O cuidado que seu pet merece!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrar Produto\n");
                    try {
                        System.out.println("Digite o Nome do Produto: ");
                        leia.skip("\\R?");
                        nome = leia.nextLine();

                        System.out.println("Digite o Tipo (1-Ração ou 2-Acessório): ");
                        tipo = leia.nextInt();

                        System.out.println("Digite o Preço: ");
                        preco = leia.nextFloat();

                        produtos.cadastrar(new ProdutoPet(produtos.gerarId(), nome, tipo, preco));
                    } catch (InputMismatchException e) {
                        System.err.println("\nErro: Dados inválidos. Use números para Tipo e Preço.");
                        leia.nextLine();
                    }
                }
                case 2 -> {
                    System.out.println("Listar todos os Produtos\n");
                    produtos.listarTodos();
                }
                case 3 -> {
                    System.out.println("Consultar dados do Produto - por ID\n");
                    try {
                        System.out.println("Digite o ID do produto: ");
                        id = leia.nextInt();
                        produtos.procurarPorId(id);
                    } catch (InputMismatchException e) {
                        System.err.println("\nErro: O ID deve ser um número inteiro!");
                        leia.nextLine();
                    }
                }
                case 4 -> {
                    System.out.println("Atualizar dados do Produto\n");
                    try {
                        System.out.println("Digite o ID do produto: ");
                        id = leia.nextInt();

                        var buscaProduto = produtos.buscarNaCollection(id);

                        if (buscaProduto != null) {
                            System.out.println("Digite o Novo Nome: ");
                            leia.skip("\\R?");
                            nome = leia.nextLine();

                            System.out.println("Digite o Novo Tipo (1-Ração ou 2-Acessório): ");
                            tipo = leia.nextInt();

                            System.out.println("Digite o Novo Preço: ");
                            preco = leia.nextFloat();

                            produtos.atualizar(new ProdutoPet(id, nome, tipo, preco));
                        } else {
                            System.out.println("\nProduto não encontrado!");
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("\nErro: Entrada de dados inválida!");
                        leia.nextLine();
                    }
                }
                case 5 -> {
                    System.out.println("Apagar o Produto\n");
                    try {
                        System.out.println("Digite o ID do produto: ");
                        id = leia.nextInt();
                        produtos.deletar(id);
                    } catch (InputMismatchException e) {
                        System.err.println("\nErro: O ID deve ser um número!");
                        leia.nextLine();
                    }
                }
                case -1 -> { /* Apenas ignora e volta ao menu se houver erro de digitação */ }
                default -> System.out.println("\nOpção Inválida!\n");
            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Ana Karoline Costa de Sousa");
        System.out.println("GitHub: github.com/anakarolinecostasousa-boop");
        System.out.println("*********************************************************");
    }
}