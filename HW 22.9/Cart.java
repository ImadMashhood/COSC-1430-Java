public class Cart extends Item {

    private int cartSize; //how many different items can fit in the cart
    private Item items[]; //different items in the cart are stored in this array
    private int itemQuantities []; //the quantities of each different item are stored in this array
    private int itemCount; //store the amount of unique items in the cart
    private double totalPrice; //store the total price of all unique items and their quantities combined
    private int totalQuantity; //stores the amount of total items and their quantities in the variable
    private int searchItem; //stores the location of the search item

    Cart(){ //default constructor
        this.cartSize = 10;
        this.items = new Item[cartSize];
        this.itemQuantities = new int[cartSize];
        this.itemCount = 0;
        this.totalPrice = 0.00;
        this.totalQuantity = 0;
    }

    Cart(int cartSize){//constructor
        this.cartSize = cartSize;
        this.items = new Item[this.cartSize];
        this.itemQuantities = new int[this.cartSize];
        this.itemCount = 0;
        this.totalPrice = 0.00;
        this.totalQuantity = 0;
    }

    public int getItemCount(){ //returns item count
        return this.itemCount;
    }

    public double getTotalPrice(){ //returns total price
        return this.totalPrice;
    }

    public int getTotalQuantity(){ //returns total quantity
        return this.totalQuantity;
    }

    public int getCartSize(){ //returns cart size
        return this.cartSize;
    }

    public void setCartSize(int cartSize){ //changing cart size
        if((cartSize >  this.cartSize || cartSize > this.itemCount) && cartSize > 0){ // if the new cart size is greater than the old one
                                // or the new cart size is larger than the amount of items and its less than zero, change the size
            int tempArr[] = new int[cartSize]; //makes a temp array to hold the quantities to allow the creation of a new array with the new cart size
            Item tempArrItem[] = new Item[cartSize]; //makes a temp array to hold the items to allow the creation of a new array with the new cart size
            for (int i = 0; i < this.cartSize-1; i++){ // makes all values of the temp cart to equal the new cart
                tempArr[i] = this.itemQuantities[i];
                tempArrItem[i] = this.items[i];
            }

            this.itemQuantities = null; //deletes all items in item quantities
            this.items = null; // deletes all items in items

            this.cartSize = cartSize;//changes cart size to new cart size
            this.itemQuantities = new int[cartSize]; //creates a new items quantity array
            this. items = new Item[cartSize]; //creates a new item array

            for (int i = 0; i < cartSize; i++) { // makes all values of the new cart to equal the temp cart
                this.itemQuantities[i] = tempArr[i];
                this.items[i] = tempArrItem[i];
            }
            //deletes temp arrays
            tempArr = null;
            tempArrItem = null;
        }
    }

    public void add (Item item, int addQuantity){
        if(this.itemCount > 0){ //I was having a an 'index out of bound error' so I only searched if an item had already been added
            if (this.itemCount < this.cartSize && addQuantity > 0){ //if the item
                if((search(item) == -1)){ //the search function would return the -1 if no item exists in the items array
                                          //thus it would just add another item into the array simply
                    this.items[this.itemCount] = item; //stores the item in the first open location
                    this.itemQuantities[this.itemCount] = addQuantity; // stores the items quantity in the first open location
                    this.totalQuantity = this.totalQuantity + addQuantity; //adds the added quantity to the total quantity
                    this.totalPrice = (item.getPrice()*addQuantity) + this.totalPrice; //finds the price of the current item
                                                                             //multiplies it about the quantity added and adds it to total price
                    this.itemCount +=1; //increases item count

                }
                else{ //if another item does it exist the search function returns the location in the array and just adds the new quantity not the item
                    this.itemQuantities[search(item)] = this.itemQuantities[search(item)] + addQuantity;  // stores the items quantity in the location of the item
                    this.totalQuantity = this.totalQuantity + addQuantity; //adds the added quantity to the total quantity
                    this.totalPrice = (item.getPrice()*addQuantity) + this.totalPrice; //finds the price of the current item
                                                                             //multiplies it about the quantity added and adds it to total price
                    //does not add an item count because no item was added
                }
            }
        }
        else{ //if first item
            this.items[this.itemCount] = item; //stores the item in the first location
            this.itemQuantities[this.itemCount] = addQuantity; // stores the items quantity in the first location
            this.totalQuantity = this.totalQuantity + addQuantity; //adds the added quantity to the total quantity
            this.totalPrice = item.getPrice()*addQuantity; //finds the price of the current item multiplies it about the quantity added and adds it to total price
            this.itemCount +=1; //increases item count
        }
    }
    public void remove (Item item, int removeQuantity){ //removes item
        if (search(item) == -1){ //if the item doesn't exist or if remove amount is = 0 nothing happens
        }
        else{ //if it found an item that does exist it executes
            if (removeQuantity < this.itemQuantities[search(item)/*location of item*/] && removeQuantity !=0){ //if amount being removed is less than the quantity
                this.itemQuantities[search(item)] = this.itemQuantities[search(item)] -removeQuantity; //removes the quantity from the items quantity
                this.totalPrice = this.totalPrice - (removeQuantity*item.getPrice()); //removes the price from the total price
                this.totalQuantity = this.totalQuantity - removeQuantity; //removes total quantity from remove quantity
            }
            else if(removeQuantity >= this.itemQuantities[search(item)]){ //if the amount needed to be removed is higher or equal to the quantity it removes the item
                int tempArr[] = new int[this.cartSize]; //creates a temp array for quantity to allow the creation of a new array
                Item tempArrItem[] = new Item[this.cartSize]; //creates a temp array for the item to allow the creation of a new array
                for (int  i = 0; i<this.cartSize ;i++){ //it copies all items from the original arrays to the temp
                    if(i == search(item)){ //the original array skips over the location of the item being deleted
                        i+=1; //by adding 1 to i when i equals the location of the item it doesn't copy that to the temp array
                    }
                    else if(i > this.cartSize) { //continues to copy every element
                        tempArrItem[i] = this.items[i];
                        tempArr[i] = this.itemQuantities[i];
                    }
                }

                this.totalPrice = this.totalPrice - (this.itemQuantities[search(item)]*item.getPrice());//removes the price of all quantities of the item
                this.totalQuantity = this.totalQuantity - this.itemQuantities[search(item)]; //removes all quantities from total quantity
                this.itemCount = this.itemCount - 1; //changes item count

                this.itemQuantities = null; //deletes all items in item quantities
                this.items = null; // deletes all items in items

                this.itemQuantities = new int[this.cartSize]; //creates a new items quantity array
                this.items = new Item[this.cartSize]; //creates a new item array

                for (int i = 0; i < cartSize; i++) { //all items in arrays equal the items in temp arrays
                    this.itemQuantities[i] = tempArr[i];
                    this.items[i] = tempArrItem[i];
                }
                //deletes temp arrays
                tempArr = null;
                tempArrItem = null;
            }
        }
    }

    private int search(Item item){ //search function
        if (this.itemCount >= 1){//only searches if more than one element is added to prevent out of bounds errors
            for (int i = 0; i < this.itemCount; i++){
                if(this.items[i] == item)//if it finds a match it stores the location of it in search item
                    this.searchItem = i;//stores
                else //if no location is found it stores -1
                    this.searchItem = -1;
            }
            return this.searchItem; //returns location or returns -1
        }
        else
            return -1;
    }

    public String formattedOutput(){

    }


}
