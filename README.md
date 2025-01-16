# Proyecto: Árboles Binarios

## Descripción de la Versión Actual

Esta versión del proyecto incluye implementaciones de ejercicios prácticos sobre árboles binarios en Java. Cada ejercicio aborda un concepto fundamental relacionado con la manipulación de árboles, permitiendome comprender mejor cómo funcionan estas estructuras de datos. A continuación, se presenta una descripción detallada de cada ejercicio y cómo su código contribuye a la funcionalidad general del proyecto.

## Estructura del Proyecto

El proyecto está organizado en varios paquetes, cada uno conteniendo una clase que representa un ejercicio específico. Los ejercicios son los siguientes:

- **Ejercicio 1: Inserción en un Árbol Binario de Búsqueda**
- **Ejercicio 2: Inversión de un Árbol Binario**
- **Ejercicio 4: Cálculo de la Profundidad Máxima de un Árbol**

## Clases y Funcionalidades

### Ejercicio 1: Inserción en un Árbol Binario de Búsqueda

- **Clase:** `InsertBSTTest`
- **Descripción:** Esta clase permite insertar valores en un árbol binario de búsqueda (BST) y visualizar el árbol resultante en un formato alineado. Utiliza recursión para insertar nodos en la posición correcta según las reglas del BST, es decir, los valores de los nodos izquierdos sean menores que los de sus nodos padres, y los valores de los nodos derechos sean mayores que los de sus nodos padres.

**Métodos Clave:**
- `insert(Node root, int value)`: Inserta un nuevo valor en el árbol. Si el árbol está vacío, crea un nuevo nodo; si no, decide si insertar en el subárbol izquierdo o derecho.
- `printTreeAligned(Node root)`: Imprime el árbol en un formato alineado para facilitar su visualización.
  
### Ejercicio 2: Inversión de un Árbol Binario

- **Clase:** `InvertBinaryTree`
- **Descripción:** Esta clase proporciona la funcionalidad para invertir un árbol binario, intercambiando los subárboles izquierdo y derecho. La inversión se realiza mediante una función recursiva que procesa cada nodo del árbol.

**Métodos Clave:**
- `invertTree(Node root)`: Invierte el árbol binario comenzando desde la raíz. Si el nodo es nulo, retorna nulo; de lo contrario, intercambia los subárboles izquierdo y derecho.
- `printTreeAligned(Node root)`: Imprime el árbol en formato alineado, similar al método del Ejercicio 1.

### Ejercicio 4: Cálculo de la Profundidad Máxima de un Árbol

- **Clase:** `Depth`
- **Descripción:** Esta clase calcula la profundidad máxima (altura) de un árbol binario. Utiliza recursión para determinar la profundidad máxima entre los subárboles izquierdo y derecho.

**Métodos Clave:**
- `maxDepth(Node root)`: Retorna la profundidad máxima del árbol. Si el nodo es nulo, retorna 0; si no, calcula la profundidad máxima sumando uno al máximo entre las profundidades de los subárboles.
- `printInput(Node root)`: Imprime una representación visual del árbol para facilitar la comprensión antes de calcular su profundidad.

## Clase Principal: App

La clase `App` actúa como el punto de entrada del programa, donde se ejecutan los diferentes ejercicios. Cada método correspondiente a un ejercicio crea un árbol, realiza las operaciones necesarias y muestra los resultados.

