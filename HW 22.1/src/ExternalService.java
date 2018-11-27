//Tons of import statements for Hashmaps and file IO

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Scanner;

public class ExternalService implements StockPriceService {

    private Map<String, Double> tickerPrices =new HashMap(); //create map called TickerPrices the index is set to the Ticker
    Scanner sc = null;

    ExternalService(){

        try{
            sc = new Scanner(new FileInputStream("ExternalService.txt")); //checks to see if it can read ExternalService.txt
        }
        catch (FileNotFoundException e){
            System.out.println("File ExternalService.txt not found closing program");
            System.exit(0);
        }

        String tempTicker; //These are temporary tickers used to fill in each index of the map
        double tempPrice;
        while(sc.hasNextLine()){

            tempTicker = sc.next(); //reads ticker
            tempPrice = sc.nextDouble(); //reads double
            //sc.nextLine(); I was having issues with this so imma leave this out until i figure out whats wrong

            tickerPrices.put(tempTicker, tempPrice); //creates index of a map

        }

    }

    public Double priceForTicker(String ticker){

        double returnPrice;//THis is the price that gets returned. I forogt why i made it a variable but im too lazy to change it

        try{
            if(ticker == null) //Instructions said if a ticker isnt found it returns zero.
                throw new IllegalArgumentException(); //So itll throw an exception to be caught and return a zero
            else { //If ticker is found then it returns the price of the ticker from the tickers index in the map
                returnPrice = tickerPrices.get(ticker);
                return returnPrice;
            }

        }

        catch(Exception IllegalArgumentException){
            return 0.0;
        }
    }

    public String nameOfService(){
        return "External";
    }

}
