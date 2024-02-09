package SearchAndOrdering.Portuguese.Searcing.D_SelfBalancingTree;

public class Item {

    private int key;
    /* Here, other atributes can be declared, according to your necessity */

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


