package main.Materia.Controllers;

import java.util.Stack;
import main.Materia.Models.Node;

public class ArbolRecorridos {

    public void preOrderIterativo(Node root) {
        // Verificar si el árbol está vacío
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        // Pila para manejar los nodos durante el recorrido
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) { 
            Node node = stack.pop();
            System.out.print(node.getValue() + ", ");

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        System.out.println(); 
    }

    public void preOrderRecursivo(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + ", "); 
            preOrderRecursivo(node.getLeft());
            preOrderRecursivo(node.getRight());
        }
    }

    public void posOrderRecursivo(Node node) {
        // Postorden: izquierda -> derecha -> nodo
        if (node != null) {
            posOrderRecursivo(node.getLeft()); // Recorrer subárbol izquierdo
            posOrderRecursivo(node.getRight()); // Recorrer subárbol derecho
            System.out.print(node.getValue() + ", "); // Procesar nodo
        }
    }

    public void inOrderRecursivo(Node node) {
        // Inorden: izquierda -> nodo -> derecha
        if (node != null) {
            inOrderRecursivo(node.getLeft()); // Recorrer subárbol izquierdo
            System.out.print(node.getValue() + ", "); // Procesar nodo
            inOrderRecursivo(node.getRight()); // Recorrer subárbol derecho
        }
    }
}
