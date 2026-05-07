package projeto_final_bloco_01;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao;

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
            System.out.print("Entre com a opção desejada: ");

            opcao = leia.nextInt();

            if (opcao == 0) {
                System.out.println("\nAmante dos Petz - Cuidando com carinho!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1 -> System.out.println("Cadastrar Produto\n");
                case 2 -> System.out.println("Listar todos os Produtos\n");
                case 3 -> System.out.println("Buscar Produto por ID\n");
                case 4 -> System.out.println("Atualizar Produto\n");
                case 5 -> System.out.println("Apagar Produto\n");
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