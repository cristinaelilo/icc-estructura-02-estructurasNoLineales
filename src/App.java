import java.util.List;

import Ejercicio_01_insert.InsertBSTTest;
import Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLevels.ListLevels;
import Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolAVL;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorridos;
import main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        //runArbolBinario();
        //runArbolRecorridos();
        //runArbolAVL();

        runInsertBSTTest();
        runInvertBinaryTree();
        //runEjercicio3();
        runDepth();

    }

    private static void runInsertBSTTest() {
        InsertBSTTest bst = new InsertBSTTest();
        Node root = null;

        System.out.println("Ejercicio 1:");

        // Valores de ejemplo
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        System.out.print("Input: ");
        System.out.println(java.util.Arrays.toString(values));

        for (int value : values) {
            root = bst.insert(root, value);
        }

        // Imprimir el árbol en formato alineado
        System.out.println("Output:");
        bst.printTreeAligned(root);
    }

    private static void runInvertBinaryTree() {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        InsertBSTTest bst = new InsertBSTTest();
        Node root = null;

        System.out.println("\nEjercicio 2:");

        // Construimos el árbol con los valores
        int[] values = {4, 2, 7, 1, 3, 6, 9}; 
        for (int value : values) {
            root = bst.insert(root, value);
        }

        System.out.println("Input (Árbol original):");
        bst.printTreeAligned(root);

        // Invertimos el árbol
        root = invertBinaryTree.invertTree(root);

        System.out.println("\nOutput (Árbol invertido):");
        bst.printTreeAligned(root);
    }

    private static void runEjercicio3() {
        // Construir el árbol del ejemplo
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));

        System.out.println("\nEjercicio 3:");

        // Imprimir el árbol como "Input"
        System.out.println("Input:");
        printTreeLevels(root);

        // Crear instancia de ListLevels y obtener los niveles
        ListLevels levels = new ListLevels();
        List<List<Node>> result = levels.listLevels(root);

        // Imprimir el resultado en el formato deseado
        System.out.println("\nOutput:");
        for (int i = 0; i < result.size(); i++) {
            List<Node> level = result.get(i);
            for (int j = 0; j < level.size(); j++) {
                System.out.print(level.get(j).getValue());
                if (j < level.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    private static void runDepth() {
        // Ejemplo del árbol
        Node root = new Node(4);
        root.setLeft(new Node(2));
        root.setRight(new Node(7));
        root.getLeft().setLeft(new Node(1));
        root.getLeft().setRight(new Node(3));
        root.getLeft().getLeft().setLeft(new Node(8)); 

        Depth depth = new Depth();

        System.out.println("\nEjercicio 4:");

        // Imprimir el input
        System.out.println("Input:");
        depth.printInput(root);

        // Calcular la profundidad máxima
        int result = depth.maxDepth(root);

        // Imprimir el output
        System.out.println("\nOutput:");
        System.out.println(result);
    }

    

    private static void runArbolAVL() {
        ArbolAVL arbolAvl = new ArbolAVL();
        int[] values = {10, 20, 15, 24, 9, 8, 21, 23, 50, 25};

        // Insertar cada valor al árbol
        for (int valor : values) {
            arbolAvl.insert(valor);
        }

        // Imprimir el árbol binario
        arbolAvl.printTree();
    }

    // Método para imprimir el árbol como en la entrada
    private static void printTreeLevels(Node root) {
        if (root == null) return;

        ListLevels levels = new ListLevels();
        List<List<Node>> result = levels.listLevels(root);

        for (int i = 0; i < result.size(); i++) {
            List<Node> level = result.get(i);

            // Imprimir nodos en la misma línea
            for (int j = 0; j < level.size(); j++) {
                System.out.print(level.get(j).getValue());
                if (j < level.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println(); // Salto de línea al final de cada nivel
        }
    }

    public static void runArbolBinario() {
        ArbolBinario arbolBinario = new ArbolBinario();
        int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        // Insertar cada valor al árbol
        for (int valor : valores) {
            arbolBinario.insert(valor);
        }

        // Imprimir el árbol binario
        arbolBinario.printTree();
    }

    public static void runArbolRecorridos() {
        ArbolBinario arbolBinario = new ArbolBinario(); // Usar ArbolBinario para insertar valores
        int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};
    
        // Insertar valores al árbol binario
        for (int valor : valores) {
            arbolBinario.insert(valor);
        }
    
        // Crear instancia de ArbolRecorridos
        ArbolRecorridos arbolRecorridos = new ArbolRecorridos();
    
        // Realizar recorridos en el árbol
        System.out.println("Recorrido en preOrden (iterativo):");
        arbolRecorridos.preOrderIterativo(arbolBinario.getRoot());

        // Recorrido en preorden recursivo
        System.out.println("Recorrido en preOrden (recursivo):");
        arbolRecorridos.preOrderRecursivo(arbolBinario.getRoot());
        System.out.println(); 

        System.out.println("Recorrido en posOrder:");
        arbolRecorridos.posOrderRecursivo(arbolBinario.getRoot());
        System.out.println();
        
        System.out.println("Recorrido en inOrden:");
        arbolRecorridos.inOrderRecursivo(arbolBinario.getRoot());
        System.out.println(); 
    }  
}
