# Ejercicios realizados - Tema 2 (ALED)

Ejercicios resueltos del Tema 2 de Algoritmos y Estructuras de Datos (diseño de algoritmos: recursividad y complejidad). Los enunciados son los de [Ejercicios-Algoritmos](https://github.com/rgarciacarmona/Ejercicios-Algoritmos) (secciones 2 y 3).

Proyecto de Eclipse. Cada ejercicio es una clase con su propio `main` que lo prueba con datos de ejemplo.

## Recursividad (`src/recursividad/`)

| Ejercicio | Clase |
|---|---|
| 2.1. Sistema de archivos: peso total de una carpeta | `Ejercicio1PesoCarpeta` |
| 2.2. Jerarquía de una empresa: presupuesto de un equipo | `Ejercicio2PresupuestoEquipo` |
| 2.3. Árbol de habilidades: coste de la rama completa | `Ejercicio3CosteRama` |
| 2.4. Página web: contar etiquetas | `Ejercicio4ContarEtiquetas` |
| 2.5. Cadena de suministros: ¿hay piezas defectuosas? | `Ejercicio5Defectos` |
| 2.6. Palíndromo recursivo | `Ejercicio6Palindromo` |
| 2.7. Validación de un árbol binario de búsqueda | `Ejercicio7ValidarBST` |
| 2.8. Invertir una lista enlazada | `Ejercicio8InvertirLista` |
| 2.9. ¿Tengo el cambio justo? | `Ejercicio9Cambio` |
| 2.10. Fusión de listas ordenadas | `Ejercicio10FusionListas` |
| 2.11. Asalto con más tocados (repaso, propio): máximo de un array, recursivo. n llamadas, O(n) | `Ejercicio11Maximo` |

Clases de apoyo: `Archivo`, `Carpeta`, `Empleado`, `Habilidad`, `ElementoHTML`, `Pieza`, `Nodo`, `NodoLista`.

## Complejidad (`src/complejidad/`)

Cada clase ejecuta el código del enunciado con un contador para comprobar las respuestas.

| Ejercicio | Clase | Respuesta |
|---|---|---|
| 3.1. Variable contador | `Ejercicio1Contador` | contador = N(N-1)/2. O(N²) |
| 3.2. Método misterioso (I) | `Ejercicio2MetodoMisterioso` | Tras i=2: {2, 4, 5, 6, 1, 3}. Es insertion sort. Peor caso O(n²) (array al revés: el while recorre todo lo anterior); mejor caso O(n) (ya ordenado: el while no entra nunca) |
| 3.3. Bucles anidados (I) | `Ejercicio3BuclesAnidados` | n=5: 15. n + (n-1) + ... + 1 = n(n+1)/2 veces. O(n²) |
| 3.4. Búsqueda binaria modificada | `Ejercicio4BusquedaBinaria` | medio = 4, 7, 5. Si no está ordenado puede no encontrarlo (descarta mitades suponiendo un orden que no hay). O(log n): cada llamada parte el problema por la mitad |
| 3.5. Bucles anidados (II) | `Ejercicio5BuclesLog` | n=10: 40 veces (j = 1, 2, 4, 8). j se duplica, así que el bucle interior da unas log₂ n vueltas. O(n log n) |
| 3.6. Bubble sort optimizado | `Ejercicio6BubbleSort` | Con {1, 2, 3, 4, 5}: 4 comparaciones. `intercambiado` corta el algoritmo si una pasada no cambia nada (ya está ordenado). Mejor caso O(n), peor caso O(n²) |
| 3.7. Complejidad de un árbol N-ario | `Ejercicio7ArbolNArio` | O(N): cada nodo se visita una vez |
| 3.8. Método misterioso (II) | `Ejercicio8MetodoMisterioso` | Calcula la altura del árbol |
| 3.9. Árbol binario degenerado | `Ejercicio9ArbolDegenerado` | Peor caso O(n) (es como una lista); mejor caso O(1) (está en la raíz) |
| 3.10. Complejidad de método recursivo | `Ejercicio10MetodoRaro` | n=3: 15 llamadas (2^(n+1) - 1). O(2^n) |

## Cómo ejecutarlo

- **Eclipse:** File > Import > Existing Projects into Workspace, y Run As > Java Application sobre cualquier clase.
- **Terminal:**
  ```
  javac -d bin src/recursividad/*.java src/complejidad/*.java
  java -cp bin recursividad.Ejercicio9Cambio
  java -cp bin complejidad.Ejercicio10MetodoRaro
  ```
