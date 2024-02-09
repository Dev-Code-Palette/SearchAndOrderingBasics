package SearchAndOrdering.Portuguese.Sorting.A_SelectionSort;

public class Item {

    private int key;

    /**
     * Construtor da classe. Toda vez que um Item for criado/instanciado,
     * deve ser informado a key/chave a ser armazenada no Item
     */
    public Item(int key) {
        this.key = key;
    }

    //Gettes and Setter for key
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}


