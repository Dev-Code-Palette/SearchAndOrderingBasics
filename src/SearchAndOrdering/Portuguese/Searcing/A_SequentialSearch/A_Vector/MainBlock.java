package SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.A_Vector;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static SearchAndOrdering.AuxArray.auxArray;
import static SearchAndOrdering.Portuguese.Searcing.A_SequentialSearch.A_Vector.SequentialSearch.sequentialSearch;


public class MainBlock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int value;
        char option;
        Boolean isReversed = true;

        Item[] randomArray = createItemsArray(auxArray);
        Item[] sortedArray = createItemsArray(sortArray(auxArray, !isReversed));
        Item[] reverseSortedArray = createItemsArray(sortArray(auxArray, isReversed));

        do {
            option = menu(input);

            switch (option) {
                case '1':
                    System.out.println("Exibindo arrays:");
                    System.out.println("Array ramdomico: " +  printItemsArray(randomArray));
                    System.out.println("Array ordenado: " +  printItemsArray(sortedArray));
                    System.out.println("Array inversamente ordenado: " +  printItemsArray(reverseSortedArray));
                    break;
                case '2':
                    System.out.println("Nos arrays seguintes com 5000 elementos, o elemento de valor 1 está nas seguintes posições para cada array:\n" +
                            "Array ordenado -> valor 1 está na primeira posíção do array (posição 0)\n" +
                            "Array inversamente ordenado -> valor 1 está na última posição do array (posição 4999)\n" +
                            "Array randomico -> valor 1 está na posição do meio do array (posição 2500)\n");
                    System.out.println("Vamos usar a pesquisa sequencial para pesquisar do último elemento até o primeiro em busca do valor 1!");

                    System.out.println("- Array ordenado (o mais lento para ser encontrado o número 1):");
                    timeToSequentialSearch(sortedArray, 1);

                    System.out.println("- Array inversamente ordenado (o mais rápido para ser encontrado o número 1):");
                    timeToSequentialSearch(reverseSortedArray, 1);

                    System.out.println("- Array randomico:");
                    timeToSequentialSearch(randomArray, 1);

                    break;
                case '3':
                    System.out.println("Encontre um valor nos arrays usando pesquisa sequencial para pesquisar do último elemento até o primeiro.\nInforme o valor:");
                    value = input.nextInt();

                    System.out.println("- Array ordenado:");
                    timeToSequentialSearch(sortedArray, value);

                    System.out.println("- Array inversamente ordenado:");
                    timeToSequentialSearch(reverseSortedArray, value);

                    System.out.println("- Array randomico:");
                    timeToSequentialSearch(randomArray, value);

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
                "1. Exiba arrays (randômico, ordenado e inversamente ordenado)\n" +
                "2. Exemplificação da performance da pesquisa sequencial\n" +
                "3. Pesquise um item nos arrays ramdômico, ordenado e inversamente ordenado\n" +
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

    public static Item[] createItemsArray(int[] numbers) {
        Item[] vector = new Item[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            vector[i] = new Item(numbers[i]);
        }

        return vector;
    }

    public static String printItemsArray(Item[] vector) {
        String msg = "";
        int i;
        for (i = 0; i < vector.length; i++) {
            msg += "[" + vector[i].getKey() + "] ";
        }
        return msg;
    }

    public static void timeToSequentialSearch(Item[] vector, int value) {
        doWarmUp(vector, value);

        long startTime = System.nanoTime();;
        int positionFound = sequentialSearch(vector, value);
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime);
        if(positionFound == -1) {
            System.out.println("   Demorou " + totalTime + " nano segundos para pesquisar no array, e o elemento " + value + " não foi encontrado.");
        } else{
            System.out.println("   Elemento " + value + " encontrado na posição " + positionFound + " do array.");
            System.out.println("   Demorou " + totalTime + " nano segundos para encontrar.");
        }
    }

    public static void doWarmUp(Item[] vector, int value) {
        sequentialSearch(vector, value);
    }
}
