package SearchAndOrdering.Portuguese.Searcing.C_Tree;

import java.util.Scanner;

import static SearchAndOrdering.AuxArray.auxArray;

public class MainBlock {

    public static void main(String[] args) {

        Item[] vector;
        Scanner input = new Scanner(System.in);
        int value;
        char option;
        Tree tree = createTree(auxArray);

        do {
            option = menu(input);

            switch (option) {
                case '1':
                    vector = tree.inOrderSeach();
                    String msg = " ";
                    for (int i = 0; i < tree.getNodeQtd(); i++) {
                        msg += "[" + vector[i].getKey() + "] ";
                    }
                    System.out.println("Exibindo árvore -> " + msg);

                    break;
                case '2':
                    System.out.println("Vamos fazer uma pesquisa na árvore para encontrar algguns elementos!");

                    System.out.println("- Procurando valor 1:");
                    timeToSearch(tree, 1);

                    System.out.println("- Procurando valor 2499:");
                    timeToSearch(tree, 2499);

                    System.out.println("- Procurando valor 5000:");
                    timeToSearch(tree, 5000);

                    break;
                case '3':
                    System.out.println("Informe um valor para ser pesquisado na árvore:");
                    value = input.nextInt();

                    System.out.println("- Árvore:");
                    timeToSearch(tree, value);


                    break;
                case '4':
                    System.out.println("Fim!");

                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (option != '4');
        System.exit(0);
    }


    /*
     * Auxiliary Methods
     */

    public static Character menu(Scanner input) {
        String msg = "\n\nEscolha uma opção:\n" +
                "1. Exiba árvore\n" +
                "2. Exemplificação da performance da pesquisa\n" +
                "3. Pesquise um item na árvore\n" +
                "4. Sair";

        System.out.println(msg);

        var chosenOption = input.next().toCharArray();
        return chosenOption[0];
    }

    public static Tree createTree(int[] numbers) {
        Tree tree = new Tree();

        for (int number : numbers) {
            tree.insertItem(new Item(number));
        }

        return tree;
    }

    public static void timeToSearch(Tree tree, int value) {
        doWarmUp(tree, value);
        long startTime = System.nanoTime();;
        boolean found = tree.searchItem(value);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        if(found) {
            System.out.println("   Elemento " + value + " encontrado na árvore.");
            System.out.println("   Demorou " + totalTime + " nano segundos para encontrar.");
        } else {
            System.out.println("   Demorou " + totalTime + " nano segundos para pesquisar na árvore, e o elemento " + value + " não foi encontrado.");
        }
    }

    public static void doWarmUp(Tree tree, int value) {
        tree.searchItem(value);
    }
}
