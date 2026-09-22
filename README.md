# Rubik-Solver

Modelo en Java de un cubo de Rubik, con representación de caras y un giro de ejemplo por consola.

El `main` de `RubikS_solver` crea un cubo, lo imprime, gira la cara frontal una vez y lo vuelve a imprimir. No recorre un algoritmo de resolución completo: el modelo y el giro viven en `RubikCube`.

## Stack

- Java
- Proyecto NetBeans (`build.xml`, `nbproject`, `manifest.mf`)

## Estructura

```
src/rubik/s_solver/RubikCube.java      # caras y rotateFaceClockwise
src/rubik/s_solver/RubikS_solver.java  # main de demostración
```

## Cómo ejecutarlo

Abre el proyecto en NetBeans y ejecuta `rubik.s_solver.RubikS_solver`.

```bash
javac -d out src/rubik/s_solver/*.java
java -cp out rubik.s_solver.RubikS_solver
```

La salida es texto en la consola (`printCube`).
