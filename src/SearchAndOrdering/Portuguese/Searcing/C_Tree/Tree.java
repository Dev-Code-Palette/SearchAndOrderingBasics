package SearchAndOrdering.Portuguese.Searcing.C_Tree;

public class Tree {
    private Node root;
    private int nodeQtd;

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

    public boolean insertItem(Item elem) {
        if (searchItem(elem.getKey())) {
            return false;
        } else {
            this.root = insert(elem, this.root);
            this.nodeQtd++;
            return true;
        }
    }

    public Node insert(Item elem, Node node) {
        if (node == null) {
            Node newNode = new Node(elem);
            return newNode;
        } else {
            if (elem.getKey() < node.getInfo().getKey()) {
                node.setLeft(insert(elem, node.getLeft()));
                return node;
            } else {
                node.setRight(insert(elem, node.getRight()));
                return node;
            }
        }
    }

    public boolean searchItem(int key) {
        if (searchItem(key, this.root) != null) {
            return true;
        } else {
            return false;
        }
    }

    private Node searchItem(int key, Node node) {
        if (node != null) {
            if (key < node.getInfo().getKey()) {
                node = searchItem(key, node.getLeft());
            } else {
                if (key > node.getInfo().getKey()) {
                    node = searchItem(key, node.getRight());
                }
            }
        }
        return node;
    }

    public Item[] inOrderSeach() {
        int[] n = new int[1];
        n[0] = 0;
        Item[] vet = new Item[this.nodeQtd];
        return (doInOrderSearch(this.root, vet, n));
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
