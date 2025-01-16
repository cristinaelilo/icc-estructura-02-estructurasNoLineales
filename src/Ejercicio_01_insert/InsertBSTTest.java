package Ejercicio_01_insert;

import java.util.LinkedList;
import java.util.Queue;

import main.Materia.Models.Node;

public class InsertBSTTest {
    public Node insert(Node root, int value) {
        // Si el árbol está vacío, crea un nuevo nodo y retórnalo
        if (root == null) {
            return new Node(value);
        }

        // Inserta en el subárbol izquierdo si el valor es menor
        if (value < root.getValue()) {
            root.setLeft(insert(root.getLeft(), value));
        } 
        // Inserta en el subárbol derecho si el valor es mayor
        else if (value > root.getValue()) {
            root.setRight(insert(root.getRight(), value));
        }

        // Retorna la raíz actualizada
        return root;
    }

    // Método para imprimir el árbol en formato alineado
    public void printTreeAligned(Node root) {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
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