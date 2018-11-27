public class MatrixPopulator {

    String[][] Matrix = new String[10][10];// Makes a Matrix of Strings

    final int NumberOfXs = (int) (Math.random() * (8 - 4) + 1) + 4; //Sets a Random number of Mines
    int XCount = 0; // Used for Making Putting in the value of X in the matrix

    MatrixPopulator(String MatrixA[][]) { //Constructor

        this.Matrix = MatrixA; //Copies the Array

        int XVal; //XValue of a Mine
        int YVal; //YValue of a Mine
        while (XCount <= NumberOfXs) {
            XVal = (int) (Math.random() * (10)); //Sets mines in random places in the Matrix
            YVal = (int) (Math.random() * (10));
            Matrix[XVal][YVal] = "X"; //Changes the " " to an X
            XCount += 1;
        }
    }

    MatrixPopulator(){
        String [][] Matrix = new String[10][10]; //Makes a 10x10 Matrix populated with " "
        for(int x=0; x < Matrix.length; x++) {
            for (int y = 0; y < Matrix[x].length; y++) {
                Matrix[x][y] = " ";
            }
        }
        int XVal; //XValue of a Mine
        int YVal; //YValue of a Mine
        while (XCount <= NumberOfXs) {
            XVal = (int) (Math.random() * (10)); //Sets mines in random places in the Matrix
            YVal = (int) (Math.random() * (10));
            Matrix[XVal][YVal] = "X"; //Changes the " " to an X
            XCount += 1;
        }
    }
}