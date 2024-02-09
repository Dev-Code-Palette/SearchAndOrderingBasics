package SearchAndOrdering.English.Searcing.C_Tree;

public class Tree {
    private Node root;
    private int nodeQtd;

    /**
     * Class constructor. When a Tree is instanced, it will begin
     * with no Nodes.
     * To add or remove an Item, it will be used one of the following methods on this class
     */
    public Tree() {
        this.nodeQtd = 0;
        this.root = null;
    }

    public boolean isEmpty() {
        return (this.root == null);
    }

    public Node getRoot() {
        return this.root;
    }

    public int getNodeQtd() {
        return this.nodeQtd;
    }

    //Insert Item on this Tree
    public boolean insertItem(Item elem) {
        if (searchItem(elem.getKey())) {
            return false; //If an item is already on the Tree, it can't be added again
        } else {
            this.root = insert(elem, this.root); //Function to recursively add the item on this Tree
            this.nodeQtd++; //There is 1 more new Node on this Tree
            return true;
        }
    }

    public Node insert(Item elem, Node node) {
        if (node == null) {
            Node newNode = new Node(elem); //Creating the new Node to be inserted in this Tree
            return newNode; //Returning the newNode that is being added to the Tree
        } else {
            if (elem.getKey() < node.getInfo().getKey()) {
                node.setLeft(insert(elem, node.getLeft())); //If the value to be inserted is less than the current Node, then we recursively call this function passing the left Node
                return node;
            } else {
                node.setRight(insert(elem, node.getRight())); //If the value to be inserted is bigger than the current Node, then we recursively call this function passing the right Node
                return node;
            }
        }
    }

    //Search an Item in this Tree
    public boolean searchItem(int key) {
        if (searchItem(key, this.root) != null) { //Function to recursively search an item in this Tree
            return true; //If the item was found in this tree
        } else {
            return false; //If the item was NOT found in this tree
        }
    }

    private Node searchItem(int key, Node node) {
        if (node != null) {
            if (key < node.getInfo().getKey()) {
                node = searchItem(key, node.getLeft()); //If the value being searched is less than the current Node, then we recursively call this function passing the left Node
            } else {
                if (key > node.getInfo().getKey()) {
                    node = searchItem(key, node.getRight()); //If the value being searched is bigger than the current Node, then we recursively call this function passing the left Node
                }
            }
        }
        return node; //Return the Node of the Item that was found, or null (if the item being searched was not found)
    }

    public Item[] inOrderSeach() {
        int[] n = new int[1];
        n[0] = 0;
        Item[] vet = new Item[this.nodeQtd];
        return (doInOrderSearch(this.root, vet, n)); //Recursively do an inorder search
    }
    private Item[] doInOrderSearch(Node arv, Item[] vet, int[] n) {
        if (arv != null) {
            vet = doInOrderSearch(arv.getLeft(), vet, n);
            vet[n[0]] = arv.getInfo();
            n[0]++;
            vet = doInOrderSearch(arv.getRight(), vet, n);
        }
        return vet;
    }

}
