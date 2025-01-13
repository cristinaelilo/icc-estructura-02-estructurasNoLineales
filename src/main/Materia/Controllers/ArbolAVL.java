package main.Materia.Controllers;

import main.Materia.Models.Node;

public class ArbolAVL {

    private Node root;

    public void insert(int value) {
        System.out.println("\n* Nodo a insertar: " + value);
        root = insert(root, value);
        printTree(); // Mostrar el árbol tras insertar cada nodo.
    }

    private Node insert(Node nodo, int value) {
        if (nodo == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado: " + value + ", Balance: 0");
            return newNode;
        }

        if (value < nodo.getValue()) {
            nodo.setLeft(insert(nodo.getLeft(), value));
        } else if (value > nodo.getValue()) {
            nodo.setRight(insert(nodo.getRight(), value));
        } else {
            return nodo;
        }

        nodo.setHeight(1 + Math.max(height(nodo.getLeft()), height(nodo.getRight())));

        int balance = getBalance(nodo);

        System.out.println("- Nodo actual: " + nodo.getValue());
        System.out.println("  Altura del nodo: " + nodo.getHeight());
        System.out.println("  Equilibrio del nodo: " + balance);

        // Caso izquierda - izquierda
        if (balance > 1 && value < nodo.getLeft().getValue()) {
            System.out.println("  Rotación derecha en nodo: " + nodo.getValue() + ", Balance: " + balance);
            Node nuevaRaiz = rightRotate(nodo);
            printTree(nuevaRaiz); // Imprimir árbol tras la rotación
            return nuevaRaiz;
        }

        // Caso derecha - derecha
        if (balance < -1 && value > nodo.getRight().getValue()) {
            System.out.println("  Rotación izquierda en nodo: " + nodo.getValue() + ", Balance: " + balance);
            Node nuevaRaiz = leftRotate(nodo);
            printTree(nuevaRaiz); // Imprimir árbol tras la rotación
            return nuevaRaiz;
        }

        // Caso izquierda - derecha
        if (balance > 1 && value > nodo.getLeft().getValue()) {
            System.out.println("  Izquierda-Derecha en nodo " + nodo.getValue());
            nodo.setLeft(leftRotate(nodo.getLeft()));
            Node nuevaRaiz = rightRotate(nodo);
            printTree(nuevaRaiz); // Imprimir árbol tras la rotación
            return nuevaRaiz;
        }

        // Caso derecha - izquierda
        if (balance < -1 && value < nodo.getRight().getValue()) {
            System.out.println("  Derecha-Izquierda en nodo " + nodo.getValue());
            nodo.setRight(rightRotate(nodo.getRight()));
            Node nuevaRaiz = leftRotate(nodo);
            printTree(nuevaRaiz); // Imprimir árbol tras la rotación
            return nuevaRaiz;
        }

        return nodo;
    }

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();

        System.out.println("Rotación Der en nodo: " + y.getValue() + ", Balance: " + getBalance(y));

        x.setRight(y);
        y.setLeft(temp);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())));

        System.out.println("Nueva raíz después de rotación der: " + x.getValue());

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = y.getLeft();

        System.out.println("Rotación Izq en nodo: " + x.getValue() + ", Balance: " + getBalance(x));

        y.setLeft(x);
        x.setRight(temp);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())));

        System.out.println("Nueva raíz después de rotación izq: " + y.getValue());

        return y;
    }

    private int height(Node node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public void printTree() {
        System.out.println("\nEstado del árbol desde la raíz actual:");
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "|   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "    ") + "└── null");
                }

                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "|   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "|   " : "    ") + "└── null");
                }
            }
        }
    }

    private void printTree(Node node) {
        System.out.println("\nEstado del árbol tras rotación:");
        printTree(node, "", true);
    }
}
