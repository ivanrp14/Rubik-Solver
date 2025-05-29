package rubik.s_solver;



import java.awt.Color;
import static rubik.s_solver.RubikCube.Face.FRONT;













public class RubikCube {
    private Color[][][] cube;


    public enum Face {
        FRONT(0),
        LEFT(1),
        RIGHT(2),
        TOP(3),
        DOWN(4),
        BACK(5);

        private final int value;

        Face(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
     }
    
    public RubikCube() {
        cube = new Color[3][3][6];
        initializeCube();
    }

    private void initializeCube() {
        // Inicializar el cubo con colores iniciales en cada cara
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {
                    cube[i][j][k] = getDefaultColorForFace(k);
                }
            }
        }
    }

    private Color getDefaultColorForFace(int faceIndex) {
 
        if (faceIndex == Face.FRONT.getValue()) {
            return Color.RED;
        } else if (faceIndex == Face.BACK.getValue()) {
            return Color.ORANGE;
        } else if (faceIndex == Face.TOP.getValue()) {
            return Color.WHITE;
        } else if (faceIndex == Face.DOWN.getValue()) {
            return Color.YELLOW;
        } else if (faceIndex == Face.LEFT.getValue()) {
            return Color.GREEN;
        } else if (faceIndex == Face.RIGHT.getValue()) {
            return Color.BLUE;
        }
        return null; // Manejo del caso predeterminado
    }
    public void rotateFaceClockwise(Face face, int mov) {
    int faceIndex = face.getValue();

    // Realizar 'mov' rotaciones en sentido horario
    for (int m = 0; m < mov; m++) {
        Color[][] temp = new Color[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[i][j][faceIndex];
            }
        }

        // Rotar la cara seleccionada en sentido horario
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[i][j][faceIndex] = temp[2 - j][i];
            }
        }

        // Actualizar las caras contiguas según la rotación
        if (face == Face.FRONT) {
            rotateAdjacentClockwise(Face.TOP.getValue(), Face.RIGHT.getValue(), Face.DOWN.getValue(), Face.LEFT.getValue());
        } else if (face == Face.BACK) {
            rotateAdjacentClockwise(Face.TOP.getValue(), Face.LEFT.getValue(), Face.DOWN.getValue(), Face.RIGHT.getValue());
        } else if (face == Face.TOP) {
            rotateAdjacentClockwise(Face.BACK.getValue(), Face.RIGHT.getValue(), Face.FRONT.getValue(), Face.LEFT.getValue());
        } else if (face == Face.DOWN) {
            rotateAdjacentClockwise(Face.FRONT.getValue(), Face.RIGHT.getValue(), Face.BACK.getValue(), Face.LEFT.getValue());
        } else if (face == Face.LEFT) {
            rotateAdjacentClockwise(Face.TOP.getValue(), Face.BACK.getValue(), Face.DOWN.getValue(), Face.FRONT.getValue());
        } else if (face == Face.RIGHT) {
            rotateAdjacentClockwise(Face.TOP.getValue(), Face.FRONT.getValue(), Face.DOWN.getValue(), Face.BACK.getValue());
        }
    }
}

private void rotateAdjacentClockwise(int topIndex, int rightIndex, int downIndex, int leftIndex) {
    Color[] temp = new Color[3];
    for (int i = 0; i < 3; i++) {
        temp[i] = cube[0][i][topIndex];
    }

    for (int i = 0; i < 3; i++) {
        cube[0][i][topIndex] = cube[2 - i][0][leftIndex];
        cube[i][0][leftIndex] = cube[2][2 - i][downIndex];
        cube[2][2 - i][downIndex] = cube[i][2][rightIndex];
        cube[i][2][rightIndex] = temp[i];
    }
}
public void printCube() {
    for (int i = 0; i < 3; i++) {
        System.out.println("       " + getColorChar(cube[0][i][Face.TOP.getValue()]) + getColorChar(cube[1][i][Face.TOP.getValue()]) + getColorChar(cube[2][i][Face.TOP.getValue()]));
    }
    
    for (int i = 0; i < 3; i++) {
        System.out.print(getColorChar(cube[0][i][Face.LEFT.getValue()]));
        System.out.print(getColorChar(cube[1][i][Face.LEFT.getValue()]));
        System.out.print(getColorChar(cube[2][i][Face.LEFT.getValue()]));
        
        System.out.print(getColorChar(cube[0][i][Face.FRONT.getValue()]));
        System.out.print(getColorChar(cube[1][i][Face.FRONT.getValue()]));
        System.out.print(getColorChar(cube[2][i][Face.FRONT.getValue()]));
        
        System.out.print(getColorChar(cube[0][i][Face.RIGHT.getValue()]));
        System.out.print(getColorChar(cube[1][i][Face.RIGHT.getValue()]));
        System.out.println(getColorChar(cube[2][i][Face.RIGHT.getValue()]));
        
       
    }
    
    for (int i = 0; i < 3; i++) {
        System.out.println("       " + getColorChar(cube[0][i][Face.DOWN.getValue()]) + getColorChar(cube[1][i][Face.DOWN.getValue()]) + getColorChar(cube[2][i][Face.DOWN.getValue()]));
    }
      System.out.println("\n");
     System.out.println("BACK");
     for (int i = 0; i < 3; i++) {
        System.out.println("       " + getColorChar(cube[0][i][Face.BACK.getValue()]) + getColorChar(cube[1][i][Face.BACK.getValue()]) + getColorChar(cube[2][i][Face.BACK.getValue()]));
    }
}

private String getColorChar(Color color) {
    if (color == Color.RED) return " R ";
    if (color == Color.ORANGE) return " O ";
    if (color == Color.YELLOW) return " Y ";
    if (color == Color.WHITE) return " W ";
    if (color == Color.GREEN) return " G ";
    if (color == Color.BLUE) return " B ";
    return " - ";
}






}