import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
public class Board extends JFrame {

    //HashMap<String,JToggleButton> buttons = new HashMap<String,JToggleButton>();

    public int Rows = 10;
    public int Col = 10;
    String[][] BlankMatrix = new String[10][10];
    String[][] Matrix = new String[10][10];

    Container pane = getContentPane();

    public Board(String MatrixA[][], String MatrixB[][]) {
        this.BlankMatrix = MatrixB;
        this.Matrix = MatrixA;
        int count = 1;
        pane.setLayout(new GridLayout(Rows, Col));

        for (int i = 0; i<10; i++){
            for (int a = 0; a<10; a++){
                JToggleButton button = new JToggleButton(MatrixB[i][a]);
                pane.add(button);

                //buttons.put((Integer.toString(count)), button);
            }
        }


    }
}
