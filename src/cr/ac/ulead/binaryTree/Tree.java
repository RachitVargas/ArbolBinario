package cr.ac.ulead.binaryTree;

import java.util.Stack;

public class Tree {

    private Node root; // first node of tree

    public Tree() {
        root = null;
    }


    public void insert(Persona newData) {
        Node newNode = new Node(newData);
        newNode.data = newData;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if ((newData.getLocalDate()).equals(current.data.getLocalDate())) {
                    if (Integer.parseInt(String.valueOf(newData.getCedula().
                            compareTo(current.data.getApellido()))) < 0) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = newNode;
                            return;
                        }
                    } else {

                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = newNode;
                            return;
                        }
                    }
                } else if (newData.getLocalDate().compareTo(current.data.getLocalDate()) > 0) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }

                } else if (newData.getLocalDate().compareTo(current.data.getLocalDate()) < 0) {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }


    public void traverse(int traverseType) {
        switch (traverseType) {
            case 4:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 3:
                System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 5:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data.getNombre() + " ");
            inOrder(localRoot.rightChild);
        }
    }


    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data.getNombre() + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data.getNombre() + " ");
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data.getNombre());
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("......................................................");
    }
}
