public class Item {

    protected String name;
    protected double price;

    public void setName(String name){ // sets name
        this.name = name;
    }

    public void setPrice(double price){ // sets price
        if (price>0){ //sets price if above 0
            this.price = price;
        }
    }

    public String getName(){ //returns name
        return this.name;
    }

    public double getPrice(){ //returns price
        return this.price;
    }

    public String formattedOutput(){ //returns output
        return this.name+","+this.price;
    }

    Item(String n, double p){ //constructor
        this.name = n;
        this.price = p;
    }

    Item(){ //default constructor
        this.name  = "";
        this.price = 0.00;
    }

}
