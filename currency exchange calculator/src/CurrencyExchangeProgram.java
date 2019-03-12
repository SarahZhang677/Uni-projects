/** 
 * 
 * @author 	Ulrich Speidel
 * @version 1.0
 * @since	2016-02-19
 *
 */
import java.io.*;
public class CurrencyExchangeProgram {
	private Currencies currencies; // this private instance variable holds an object of class Currencies
	private KeyboardInput keyboardInput; // this private instance variable holds an object of class keyboardInput 

	/**
	 * This instance method is the central method of our program. It sets
	 * up all we need for keyboard input later, and contains the central
	 * loop to which execution returns. It takes no parameters. 
	 */
	public void run() {
		
		openFile(); //calling a method in the same class to open the forex file
		keyboardInput = new KeyboardInput(); // we will use this object to obtain keyboard input

		while (true) { // endless while-loop
			// display the menu and get the user's choice
			CurrencyExchangeMenu menu = new CurrencyExchangeMenu(); // ...using the 
			int menuChoice = menu.getChoice(keyboardInput);
			
			// now process
			switch (menuChoice) {
			case 1:
				listCurrencies(); // output a list of all currencies added to the system
				break;
			case 2: 
				addCurrency(); // add a currency to the system
				break;
			case 3:
				showRate(); // show the exchange rate for a given currency
				break;
			case 4:
				convertAmount(); // convert an amount between two currencies
				break;
			}
		}
	}
	
	/**
	 * This private instance method outputs a list of all currencies stored in the
	 * private instance variable currencies. The method takes no parameters. 
	 */
	private void listCurrencies() {
		
		// Test whether we already have currencies
		if (currencies == null) {
			// No, so complain and return
			System.out.println("There are currently no currencies in the system.");
			System.out.println("Please add at least one currency.");
			System.out.println();
			return;
		}
		// Reset the index into the currencies list
		currencies.reset();
		Currency currency;
		// Output all currencies
		while ((currency = currencies.next()) != null) {
			System.out.println(currency.getCode());			
		}
		System.out.println();
	}
	
	/**
	 * This private instance method adds a currency to the private instance variable currencies. 
	 * The method takes no parameters. 
	 */
	private void addCurrency() {
		String currencyCode = gettingAndCheckingInput();
		if (currencyCode == "null") {
			return;
		}
        System.out.println();
        System.out.print("Enter the exchange rate (value of 1 " +currencyCode+ " in NZD): ");
        String exchangeRateStr = keyboardInput.getLine();
        double exchangeRate = Double.parseDouble(exchangeRateStr);
        if (exchangeRate <= 0) {
        	System.out.println("Negative exchange rates not permitted. Returning to menu.");
        	System.out.println();
        	return;
        }
        System.out.println();
        if (currencies == null) {
        	currencies = new Currencies();
        }
        currencies.addCurrency(currencyCode, exchangeRate);
        System.out.println("Currency " +currencyCode+ " with exchange rate " + exchangeRate + " added");
        System.out.println();
	}
	
	private String gettingAndCheckingInput() {
		System.out.println("Enter a three letter currency code (e.g., AUB, JPY, USD, EUR):");
		String currencyCode = keyboardInput.getLine();
        if (currencyCode.length() != 3) {
        	System.out.println("\"" + currencyCode + "\" is not a THREE letter code. Returning to menu.");
        	System.out.println();
        	return "null";
        }
       
        return currencyCode;
	}
	/**
	 * Gets and checks currency code is viable and displays its exchange rate based on currency code.
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * No parameters passed
	 */
	/**
	 * 
	 */
	private void showRate() {
		
		String currencyCode = gettingAndCheckingInput();
		if (currencyCode == "null") {
			return;
		}
		
        // currencies list is empty giving error, thus made an if statement to check if there is currency codes in the list.
        // if there is currency code(s), code moves on , if there isn't it suggest user to enter currencies and returns to main menu.
        if(currencies == null) {
        	System.out.println("There are currently no currencies in the system. ");
        	System.out.println("Please add atleast on currency.");
        	System.out.println();
        	return;
        }
        Currency currency = currencies.getCurrencyByCode(currencyCode);
        //currency variable stores null and code before didn't check if it was null and you can't get exchange rate of null. 
        //Checks if currency variable stores null and informs the user and returns them back to the main menu if its true. Else it continues with code.
        if (currency ==  null) {
        	System.out.println("\"" + currencyCode + "\" is not on the system. Returning to menu.");
        	System.out.println();
        	return;
        }
       
        
        System.out.println("Currency " +currencyCode+ " has exchange rate " + currency.getExchangeRate() + ".");
        System.out.println();
        

	}
	/**
	 * Checks selected currency is in system and converts currency inputed amount.
	 * This is a instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * No parameters passed.
	 */
	private void convertAmount() {
		System.out.println("Select the currency to convert FROM.");
		String currencyCodeFrom = gettingAndCheckingInput();
		if (currencyCodeFrom == "null") {
			return;
		}


		System.out.println("Select the currency to convert TO.");
		String currencyCodeTo = gettingAndCheckingInput();
		if (currencyCodeTo == "null") {
			return;
		}
	
        Currency currencyFrom = currencies.getCurrencyByCode(currencyCodeFrom);
        if (currencyFrom == null) {
        	System.out.println("\"" + currencyCodeFrom + "\" is not on the system. Returning to menu.");
        	return;
        }
        System.out.println();
        Currency currencyTo = currencies.getCurrencyByCode(currencyCodeTo);
        if (currencyTo == null) {
        	System.out.println("\"" + currencyCodeTo + "\" is not on the system. Returning to menu.");
        	return;
        }
        System.out.println();
        System.out.print("How many " + currencyCodeFrom + " would you like to convert to " + currencyCodeTo + "? Amount: ");
        String amountStr = keyboardInput.getLine();
        Amount amount = new Amount(currencyFrom, Double.parseDouble(amountStr));
        System.out.println();
        System.out.printf("%.2f %s = %.2f %s",  amount.getAmount(), amount.getCurrency().getCode(), 
            amount.getAmountIn(currencyTo), currencyTo.getCode());
        System.out.println(); 
        System.out.println(); 
	}
	
	public void openFile(){
		String fileName = "bin/forex.txt";//Holds the name of the file to be opened.
		String line = null; // sets string to null.
		
		try { // run this code unless a catch is activated.
			FileReader fileReader = new FileReader(fileName); //creates a FileReader object and passes it the file to read from. 
			BufferedReader bufferedReader = new BufferedReader(fileReader);// reads the fileReader object fast.
			
			while((line = bufferedReader.readLine()) != null){ //reads line by line till the end of the file.
				
				String[] individual =  line.split("\\s{1}"); // splits string array at the first whitespace.
				String currencyCode = individual[0]; // makes the first part of the individual split a string and stores it in currencyCode.
				double currency = Double.parseDouble(individual[1]);//makes the second part of the individual split a double and stores its in currency.
				if (currencies == null) { // checks if currencies is empty.
				  currencies = new Currencies();//creates a new currencies object.
				 }
				
				currencies.addCurrency(currencyCode,currency);// makes a call to the Currencies class, addCurrency method and passes 2 parameters through, a String and a double.
				
				
			}
			bufferedReader.close();//closes bufferedreader to prevent memory leak.
		}
		catch(FileNotFoundException ex) { //if file not found/does not exist, this catch block prints 'Unable to open file' and continues with the program.  
			System.out.println("Unable to open file");
			
		}
		catch(IOException ex) { //catches any input or output errors and prints 'Error reading file'. 
			System.out.println("Error reading file");
		}
	}
}
