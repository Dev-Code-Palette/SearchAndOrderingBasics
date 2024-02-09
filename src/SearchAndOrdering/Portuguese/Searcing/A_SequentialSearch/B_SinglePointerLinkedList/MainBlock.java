package SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.B_SinglePointerLinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static SearchAndOrdering.AuxArray.auxArray;
import static SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.B_SinglePointerLinkedList.SequentialSearch.sequentialSearch;

public class MainBlock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int value;
        char option;
        Boolean isReversed = true;

        SinglePointerLinkedList randomList = createItemsList(auxArray);
        SinglePointerLinkedList sortedList = createItemsList(sortArray(auxArray, !isReversed));
        SinglePointerLinkedList reverseSortedList = createItemsList(sortArray(auxArray, isReversed));

        do {
            option = menu(input);

            switch (option) {
                case '1':
                    System.out.println("Exibindo listas:");
                    System.out.println("Lista ramdomica: " +  printItemsList(randomList));
                    System.out.println("Lista ordenada: " +  printItemsList(sortedList));
                    System.out.println("Lista inversamente ordenada: " +  printItemsList(reverseSortedList));

                    break;
                case '2':
                    System.out.println("Nas listas seguintes com 5000 elementos, o elemento de valor 1 está nas seguintes posições para cada lista:\n" +
                            "Lista ordenada -> valor 1 está na primeira posíção da lista (posição 0)\n" +
                            "Lista inversamente ordenada -> valor 1 está na última posição da lista (posição 4999)\n" +
                            "Lista randomica -> valor 1 está na posição do meio da lista (posição 2500)\n");
                    System.out.println("Vamos usar a pesquisa sequencial para pesquisar do primeiro elemento até o último em busca do valor 1!");

                    System.out.println("- Lista ordenada (o mais lento para ser encontrado o número 1):");
                    timeToSequentialSearch(sortedList, 1);

                    System.out.println("- Lista inversamente ordenada (o mais lento para ser encontrado o número 1):");
                    timeToSequentialSearch(reverseSortedList, 1);

                    System.out.println("- Lista randomica:");
                    timeToSequentialSearch(randomList, 1);

                    break;
                case '3':
                    System.out.println("Encontre um valor nas listas usando pesquisa sequencial para pesquisar do primeiro elemento até o último.\nInforme o valor:");
                    value = input.nextInt();

                    System.out.println("- Lista ordenada:");
                    timeToSequentialSearch(sortedList, value);

                    System.out.println("- Lista inversamente ordenada:");
                    timeToSequentialSearch(reverseSortedList, value);

                    System.out.println("- Lista randomica:");
                    timeToSequentialSearch(randomList, value);

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
                "1. Exiba listas (randômica, ordenada e inversamente ordenada)\n" +
                "2. Exemplificação da performance da pesquisa sequencial\n" +
                "3. Pesquise um item nas listas ramdômica, ordenada e inversamente ordenada\n" +
                "4. Sair";

        System.out.println(msg);

        var chosenOption = input.next().toCharArray();
        return chosenOption[0];
    }

    public static int[] sortArray(int[] array, Boolean isReversed) {
        return Arrays.stream(array)
                .boxed()
                .sorted(isReversed ? Comparator.reverseOrder() : Comparator.naturalOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static SinglePointerLinkedList createItemsList(int[] numbers) {
        SinglePointerLinkedList list = new SinglePointerLinkedList();

        for (int number : numbers) {
            list.insertLastNode(new Item(number));
        }

        return list;
    }

    public static String printItemsList(SinglePointerLinkedList list) {
        String msg = "";
        Node currentNode = list.getFirstNode();
        while (currentNode != null) {
            msg += "[" + currentNode.getInfo().getKey() + "] ";
            currentNode = currentNode.getNextNode();
        }
        return msg;
    }

    public static void timeToSequentialSearch(SinglePointerLinkedList list, int value) {
        doWarmUp(list, value);
        long startTime = System.nanoTime();;
        Node nodeFound = sequentialSearch(list, value);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);

        if(nodeFound == null) {
            System.out.println("   Demorou " + totalTime + " nano segundos para pesquisar na lista, e o elemento " + value + " não foi encontrado.");
        } else{
            System.out.println("   Elemento " + value + " encontrado na lista.");
            System.out.println("   Demorou " + totalTime + " nano segundos para encontrar.");
        }
    }

    public static void doWarmUp(SinglePointerLinkedList list, int value) {
        sequentialSearch(list, value);
    }
}
