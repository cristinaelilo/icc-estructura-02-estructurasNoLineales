package main.Materia.Models;

public class Node {

    private int value; 
    private Node left; 
    private Node right; 
    private int height;

    // Constructor
    public Node(int value) {
        this.value = value;
        //this.left = null;
        //this.right = null;
        this.height = 1; // Inicializamos la altura como 1 para un nodo hoja
    }

    // Métodos getters y setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    // Método para establecer la altura
    public void setHeight(int height) {
        this.height = height; 
    }
}
