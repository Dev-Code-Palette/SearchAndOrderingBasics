package SearchAndOrdering.Portuguese.Searcing.B_BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static SearchAndOrdering.AuxArray.auxArray;
import static SearchAndOrdering.Portuguese.Searcing.B_BinarySearch.BinarySearch.binarySearch;

public class MainBlock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int value;
        char option;

        Item[] sortedArray = createItemsArray(sortArray(auxArray));

        do {
            option = menu(input);

            switch (option) {
                case '1':
                    System.out.println("Array ordenado: " +  printItemsArray(sortedArray));
                    break;
                case '2':
                    System.out.println("Em um array ordenado com 5000 elementos:\n" +
                            "valor 1 está na primeira posíção do array (posição 0))\n" +
                            "value 5000 está na última posição do array (posição 4999)\n" +
                            "value 2500 está na posição do meio do array (posição 2499)");
                    System.out.println("Vamos usar  Pesquisa Binária para encontrar o primeiro, o elemento do meio e o último!");

                    System.out.println("- Array ordenado - pesquisando pelo primeiro elemento (número 1):");
                    timeToSequentialSearch(sortedArray, 1);

                    System.out.println("- Array ordenado - pesquisando pelo último elemento (número 5000):");
                    timeToSequentialSearch(sortedArray, 5000);

                    System.out.println("- Array ordenado - pesquisando pelo elemento do meio (número 2500) - o mais rápido:");
                    timeToSequentialSearch(sortedArray, 2500);

                    break;
                case '3':
                    System.out.println("Encontre um valor no array ordenado usando pequisa binária.\nInforme o valor:");
                    value = input.nextInt();

                    System.out.println("- Array ordenado:");
                    timeToSequentialSearch(sortedArray, value);

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
                "1. Exibir array ordenado\n" +
                "2. Exemplificação da performance da pesquisa binária\n" +
                "3. Pesquise um item no array ordenado\n" +
                "4. Sair";

        System.out.println(msg);

        var chosenOption = input.next().toCharArray();
        return chosenOption[0];
    }

    public static int[] sortArray(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .sorted(Comparator.naturalOrder())
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
        int positionFound = binarySearch(vector, value);
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
        binarySearch(vector, value);
    }
}
