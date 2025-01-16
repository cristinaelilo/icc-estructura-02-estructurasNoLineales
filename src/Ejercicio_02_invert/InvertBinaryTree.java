package Ejercicio_02_invert;

import main.Materia.Models.Node;

public class InvertBinaryTree {
    // Método para invertir el árbol binario
    public Node invertTree(Node root) {
        if (root == null) {
            return null; // Si el nodo está vacío, no hay nada que invertir
        }

        // Intercambiamos los subárboles izquierdo y derecho
        Node temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        // Llamamos recursivamente en los subárboles izquierdo y derecho
        invertTree(root.getLeft());
        invertTree(root.getRight());

        return root; // Retornamos la raíz invertida
    }

    // Método para imprimir el árbol alineado (mismo que antes)
    public void printTreeAligned(Node root) {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        int maxHeight = getTreeHeight(root);
        int currentLevel = 0;

        while (!queue.isEmpty() && currentLevel <= maxHeight) {
            int levelSize = queue.size(); // Número de nodos en el nivel actual
            int spacesBefore = (int) Math.pow(2, maxHeight - currentLevel) - 1; // Espacios antes del primer nodo
            printSpaces(spacesBefore);

            while (levelSize > 0) {
                Node current = queue.poll();

                if (current != null) {
                    System.out.print(current.getValue());
                    queue.add(current.getLeft());
                    queue.add(current.getRight());
                } else {
                    System.out.print(" ");
                    queue.add(null); // Agregamos nulls para mantener el espaciado
                    queue.add(null);
                }

                levelSize--;

                if (levelSize > 0) {
                    int spacesBetween = (int) Math.pow(2, maxHeight - currentLevel + 1) - 1;
                    printSpaces(spacesBetween);
                }
            }

            System.out.println(); // Nueva línea para el siguiente nivel
            currentLevel++;
        }
    }

    // Método auxiliar para calcular la altura del árbol
    private int getTreeHeight(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(getTreeHeight(root.getLeft()), getTreeHeight(root.getRight()));
    }

    // Método auxiliar para imprimir espacios
    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}
