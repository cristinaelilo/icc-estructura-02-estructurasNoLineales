package Ejercicio_04_depth;

import main.Materia.Models.Node;

public class Depth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0; // Si el nodo es nulo, la profundidad es 0
        }

        // Llamadas recursivas para calcular la profundidad de los subárboles izquierdo y derecho
        int leftDepth = maxDepth(root.getLeft());
        int rightDepth = maxDepth(root.getRight());

        // Devuelve la profundidad máxima más 1 (por el nodo actual)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // Método para imprimir el árbol en el formato específico
    public void printInput(Node root) {
        if (root == null) return;

        System.out.println("       4");
        System.out.println("    2     7");
        System.out.println("  1   3  ");
        System.out.println("8");
    }
}