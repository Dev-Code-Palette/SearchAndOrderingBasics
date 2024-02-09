package SearchAndOrdering.English.Searcing.D_SelfBalancingTree;

public class Item {

    private int key;
    /* Here, other atributes can be declared, according to your necessity */

    /**
     * Class constructor, everytime a new Item is created,
     * it has to be informed what key is to be stored in the Item
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


