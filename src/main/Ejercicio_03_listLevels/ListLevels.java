package main.Ejercicio_03_listLevels;

import main.Materia.Models.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListLevels {

    // Método para obtener los niveles del árbol en listas enlazadas
    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> result = new ArrayList<>();
        if (root == null) return result; // Si el árbol está vacío, regresamos una lista vacía

        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Agregamos la raíz al inicio de la cola

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Cantidad de nodos en el nivel actual
            List<Node> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll(); // Sacamos el nodo actual de la cola
                currentLevel.add(currentNode); // Agregamos el nodo a la lista del nivel actual

                // Agregamos los hijos del nodo actual a la cola usando getters
                if (currentNode.getLeft() != null) queue.add(currentNode.getLeft());
                if (currentNode.getRight() != null) queue.add(currentNode.getRight());
            }

            result.add(currentLevel); // Agregamos la lista del nivel actual al resultado
        }

        return result;
    }
}
