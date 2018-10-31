public class Dress extends Item {

    private String size;
    private String fabric;

    public void setSize(String s){ // sets size
        this.size = s;
    }

    public void setFabric(String f){ //sets fabric
        this.fabric = f;
    }

    public String getSize(){ //returns size
        return this.size;
    }

    public String getFabric(){ // returns fabric
        return this.fabric;
    }

    public String formattedOutput(){ // returns output
        return this.name+","+this.price+","+this.size+","+this.fabric;
    }

    Dress( String n, double p, String s, String f){//constructor
        this.name  = n;
        this.price = p;
        this.size  = s;
        this.fabric  = f;
    }

    Dress(){ //default constructor
        this.name  = "";
        this.price = 0.00;
        this.size  = "";
        this.fabric  = "";
    }

}
