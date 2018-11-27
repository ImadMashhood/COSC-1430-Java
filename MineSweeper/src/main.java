import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
public class main {
    public static void main (String []args){

        String [][] mat = new String[10][10]; //This is the matrix of everything under neath the button
        for(int x=0; x < mat.length; x++) {
            for (int y = 0; y < mat[x].length; y++) {
                mat[x][y] = " ";
            }
        }
        String [][] BlankMat = new String[10][10]; //This is to be used in the gui as blank matrices for the buttons
        for(int x=0; x < BlankMat.length; x++) {
            for (int y = 0; y < BlankMat[x].length; y++) {
                BlankMat[x][y] = " ";
            }
        }

        MineCounter a = new MineCounter(mat);//These 2 do all the calculations

        a.Count();

        for(int x=0; x < mat.length; x++) { //This prints everything in console for you to see if it worked
            for (int y = 0; y < mat[x].length; y++) {
                System.out.print(mat[x][y]+ " ");
            }
            System.out.println(" ");
        }

        Board brd = new Board(mat, BlankMat); //This runs the Gui. ALL THE GUI IS EXPERIMENTAL so like you can change anything you want
                                              // in terms of GUI
        brd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        brd.pack();
        brd.setVisible(true);
    }
}
