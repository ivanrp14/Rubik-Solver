/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rubik.s_solver;

/**
 *
 * @author ivanr
 */
public class RubikS_solver {
  
     
    public static void main(String[] args) {
        RubikCube cube = new RubikCube();
        cube.printCube();
        cube.rotateFaceClockwise(RubikCube.Face.FRONT, 1);
        
        cube.printCube();
    }
    
}
