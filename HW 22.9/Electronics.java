public class Electronics extends Item { //inherits item

    private String model;
    private int year;

    public void setModel(String model){ //sets model
        this.model = model;
    }

    public void setYear(int year){ //sets year
        if (year < 0){
        }
        else{
            this.year = year;
        }
    }

    public String getModel(){ //returns model
        return this.model;
    }

    public int getYear(){ //returns year
        return this.year;
    }

    public String formattedOutput(){ //returns output
        return this.name+","+this.price+","+this.model+","+this.year;
    }

    Electronics(String n, double p, String m, int y){ //constructor
        this.name  = n;
        this.price = p;
        this.model = m;
        if (y < 0){ //if inputted year is less than zero year is zero
            this.year = 0;
        }
        else{
            this.year = y;
        }
    }

    Electronics(){ //default constructor
        this.name  = "";
        this.price = 0.00;
        this.model = "";
        this.year = 0;
    }

}
