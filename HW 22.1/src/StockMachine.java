//imported map stuff to be safe
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Scanner;

public class StockMachine{

    private StockPriceService[] stockPriceServices; //Stores the map in each index
    private String[] tickerSymbols; //stores the actual tickers
    private final int NUMOFSERVICES = 3; //Num of services used, used to determine size of stockPriceServices array
    int numOfTickers; //Num of tickers per file

    public StockMachine(String fileName){

        Scanner sc = null;

        String tempTicker; //Forogt what this was for but too scared to delete it

        stockPriceServices = new StockPriceService [NUMOFSERVICES]; //creates an array for the maps for each service

        stockPriceServices[0] = new UHStockService(); //stores first index with the UH Map
        stockPriceServices[1] = new NLPService(); //stores first index with the NLP Map
        stockPriceServices[2] = new ExternalService(); //stores first index with the External Map

        try{
            sc = new Scanner(new FileInputStream(fileName)); //Checks to see if file exists closes program if not
        }
        catch (FileNotFoundException e){
            System.out.println("File "+fileName+" not found closing program");
            System.exit(0);
        }

        numOfTickers = sc.nextInt(); //Stores the numbers of tickers in this variable
        tickerSymbols = new String[numOfTickers]; //Stores the tickers in the file in this array
        int i = 0; //i coudlve done a for loop but i was too lazy to change it
        while (i < numOfTickers) {
            sc.nextLine();//stores every ticker in array
            tickerSymbols[i]=sc.next();
            i+=1;
        }
    }

    public String getServiceWithLowestAvg(){

        double UH = average(stockPriceServices[0]); //runs the average function on each service
        double NLP = average(stockPriceServices[1]);
        double Ext = average(stockPriceServices[2]);

        int x = 0; //used to determine which service has the lowest avg

        if(UH < NLP && UH < Ext && UH > 0) //sets x to the index value of the lowest avg
            x = 0;
        else if (NLP < UH && NLP < Ext && NLP > 0)
            x = 1;
        else if (Ext < UH && Ext  < NLP && Ext > 0)
            x = 2;

        return stockPriceServices[x].nameOfService(); //returns the name of the service with lowest index value
        }

    public String getServiceWithHighestAvg(){
        double UH = average(stockPriceServices[0]); //runs the average function on each service
        double NLP = average(stockPriceServices[1]);
        double Ext = average(stockPriceServices[2]);

        int x = 0; //used to determine which service has the highest avg

        if(UH > NLP && UH > Ext) //sets x to the index value of the Highest avg
            x = 0;
        else if (NLP > UH && NLP >  Ext)
            x = 1;
        else if (Ext > UH && Ext  > NLP)
            x = 2;

        return stockPriceServices[x].nameOfService(); //returns the name of the service with highest index value

    }

    public double average(StockPriceService service){

        int amntOfNegatives = 0;
        double avg = 0;

        for(int a = 0; a<numOfTickers; a++){
            if(service.priceForTicker(tickerSymbols[a]) < 0) //skips over numbers that arent positive
                amntOfNegatives +=1; //was gonna remove this but i realized i need soemthing in this if statemnt and im too lazy to delte the else and turn it to an if
            else
                avg = service.priceForTicker(tickerSymbols[a]) + avg; //adds all numbers that are positive

        }
        avg = avg/numOfTickers; //averages them
        return avg; //returned avg
    }

    public String getBestPriceFor(String ticker){
        double[] compare = new double[3]; //made an array to store the price for each service in this
        for(int i = 0; i < 3; i++){
            compare[i] = stockPriceServices[i].priceForTicker(ticker); //populates array with the prices
            if(compare[i] < 0) //now i was having an issue with numbers being negative
                compare[i] = 2147483647; //so i just turned those numbers into the highest value for integers because i was too lazy to fix the entire array
        }
        int x = 0; //used to determine which price is the best price

        if(compare[0] < compare[1] && compare[0] < compare[2] && compare[0] > 0) //compares all prices and picks the lowest price above zero
            x = 0;
        else if (compare[1] < compare[0] && compare[1] < compare[2] && compare[1] > 0)
            x = 1;
        else if (compare[2] < compare[0] && compare[2] < compare[1] && compare[2] > 0)
            x = 2;
        return Double.toString(stockPriceServices[x].priceForTicker(ticker)); //returns the price as a string because the hw required this function be a string for what ever reason
    }
}