
public class CurrencyExchangeMenu {
	/**
	 * Get user input from the options provided.
	 * This is an instance method
	 * Invoked by getChoice(KeyboardInput) in CurrencyExchangeMenu.
	 * No parameters passed
	 */
	private void showMenu() {
		System.out.println("***Welcome to the currency exchange calculator***");
		System.out.println();
		System.out.println("1) List available currencies");
		System.out.println("2) Add a currency");
		System.out.println("3) Show an exchange rate");
		System.out.println("4) Convert an amount");
		System.out.println();
		System.out.print("Enter your choice: ");		
	}
	/**
	 * Get users input.
	 * This is an instance method.
	 * Invoked by getChoice(KeyboardInput) in CurrencyExchangeMenu
	 * 
	 * @param k user input
	 * @return integer to be retrieved
	 */
	private int getInput(KeyboardInput k) {
        String choiceStr = k.getLine();     
        return Integer.parseInt(choiceStr);
	}
	/**
	 * Check if users input is valid.
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * 
	 * @param k: user input
	 * @return returns users input
	 */
	public int getChoice(KeyboardInput k) {
		showMenu();
		int choice = getInput(k);
		while ((choice < 1) || (choice > 4)) {
			System.out.print("Invalid input. Please enter your choice: ");
			choice = getInput(k);
		}
		return choice;		
	}	
}
