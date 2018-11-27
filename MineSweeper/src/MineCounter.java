public class MineCounter extends MatrixPopulator {


    String[][] Matrix = new String[10][10];

    final int NumberOfXs = (int) (Math.random() * (8 - 4) + 1) + 4;
    int XCount = 0;

    MineCounter(String MatrixA[][]) {

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

    MineCounter(){
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

    public void Count() { //This sets the value of the of every box index in the matrix that touches an X Value to the number of Xs it touches
        int MineCount = 0; //Used to store how many X values are near an index
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {

                if (y == 0){

                    if(x == 0){ //This is for the top Left Corner
                        if(Matrix[x][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y+1] == "X")
                            MineCount += 1;
                    }

                    else if (x == 9){ //Top right Corner
                        if(Matrix[x][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y+1] == "X")
                            MineCount += 1;
                    }

                    else{ //Everything else on the top Row
                        if(Matrix[x][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y] == "X")
                            MineCount += 1;

                    }
                }

                else if (y == 9){
                    if(x == 0){ //Bottom Left Corner
                        if(Matrix[x][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y-1] == "X")
                            MineCount += 1;
                    }

                    else if (x == 9){ //Bottom Right Corner
                        if(Matrix[x][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y-1] == "X")
                            MineCount += 1;
                    }

                    else{  //Else on the Bottom Row
                        if(Matrix[x][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y] == "X")
                            MineCount += 1;
                    }
                }

                else if (x == 0){
                    if(y == 0){ //Top Left Corner
                        if(Matrix[x][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y+1] == "X")
                            MineCount += 1;
                    }
                    else if(y == 9){ //Bottom Left Corner
                        if(Matrix[x][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y-1] == "X")
                            MineCount += 1;
                    }
                    else{ //Everything Else on the Left Col
                        if(Matrix[x][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x+1][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x][y+1] == "X")
                            MineCount += 1;
                    }
                }

                else if (x == 9) {
                    if(y == 0){ //Topr Right Corner
                        if(Matrix[x][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y+1] == "X")
                            MineCount += 1;
                    }
                    else if(y == 9){ //Bottom Right Corner
                        if(Matrix[x][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y-1] == "X")
                            MineCount += 1;
                    }
                    else{ //Everything else on the Right col
                        if(Matrix[x][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y-1] == "X")
                            MineCount += 1;
                        if(Matrix[x-1][y+1] == "X")
                            MineCount += 1;
                        if(Matrix[x][y+1] == "X")
                            MineCount += 1;
                    }
                }

                else{ //Everything Else
                    if(Matrix[x][y-1] == "X")
                        MineCount += 1;
                    if(Matrix[x-1][y] == "X")
                        MineCount += 1;
                    if(Matrix[x-1][y-1] == "X")
                        MineCount += 1;
                    if(Matrix[x-1][y+1] == "X")
                        MineCount += 1;
                    if(Matrix[x][y+1] == "X")
                        MineCount += 1;
                    if(Matrix[x+1][y] == "X")
                        MineCount += 1;
                    if(Matrix[x+1][y+1] == "X")
                        MineCount += 1;
                    if(Matrix[x+1][y-1] == "X")
                        MineCount += 1;
                }

                if (Matrix[x][y] != "X") { //If the value isnt X
                    if (MineCount > 0) //and if the AMount of Mines next to it is more than Zero
                        Matrix[x][y] = Integer.toString(MineCount); //Change the Value of the Index to the amount of Xs Next to it
                }
                MineCount = 0; //Sets it to Zero so it can run through the rest
            }
        }
    }

}
