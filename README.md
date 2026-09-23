# Rubik-Solver

A Java model of a Rubik's cube, with face representation and a sample turn printed to the console.

The `main` method in `RubikS_solver` creates a cube, prints it, turns the front face once, and prints it again. It does not run a full solving algorithm: the model and the turn live in `RubikCube`.

## Stack

- Java
- NetBeans project (`build.xml`, `nbproject`, `manifest.mf`)

## Layout

```
src/rubik/s_solver/RubikCube.java      # faces and rotateFaceClockwise
src/rubik/s_solver/RubikS_solver.java  # demo main
```

## How to run

Open the project in NetBeans and run `rubik.s_solver.RubikS_solver`.

```bash
javac -d out src/rubik/s_solver/*.java
java -cp out rubik.s_solver.RubikS_solver
```

Output is text on the console (`printCube`).
