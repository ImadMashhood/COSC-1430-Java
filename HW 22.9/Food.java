public class Food extends Item {

    private double weight;
    private String weightUnit;

    public void setWeightUnit(String weightUnit){ //sets weight unit
        this.weightUnit = weightUnit;
    }

    public void setWeight(double weight){ //sets weight
        if (weight < 0){ //if weight is less than zero weight is zero
            this.weight = 0;
        }
        else{
            this.weight = weight;
        }
    }

    public String getWeightUnit(){ //returns weight unit
        return this.weightUnit;
    }

    public double getWeight(){ //returns weight
        return this.weight;
    }

    public String formattedOutput(){ //returns output
        return this.name+","+this.price+","+this.weight+","+this.weightUnit;
    }

    Food(String name, double price, double weight, String weightUnit){ //constructor
        this.name = name;
        this.price = price;
        this.weightUnit = weightUnit;
        if (weight < 0){ //if weight is less than zero weight is zero
            this.weight = 0;
        }
        else{
            this.weight = weight;
        }

    }

    Food(){ //default constructor
        this.name = "";
        this.price = 0.00;
        this.weightUnit = "";
        this.weight = 0;
    }

}
