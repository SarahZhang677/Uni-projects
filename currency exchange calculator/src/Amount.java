
public class Amount {
	
	private Currency currency;
	private double amount;
	/**
	 * Sets currency and amount to the parameters passed.
	 * This is an instance method.
	 * Invoked by convertAmount() in Currency Exchange program.
	 * 
	 * @param currency currency user is converting from
	 * @param amount amount to be converted/ exchanged
	 */
	public Amount(Currency currency, double amount) {
		this.setCurrency(currency);
		this.setAmount(amount);
	}
	/**
	 * Gets the Currency object. 
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * No parameters passed
	 * 
	 * @return returns the Currency object
	 */
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * Sets and stores the currency from the parameter passed.
	 * This is an instance method.
	 * Invoked by Amount(Currency, double) in Amount.
	 * 
	 * @param currency:  currency you want to convert from
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	/**
	 * Returns the amount user wants to exchange.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExhangeProgram
	 * No parameters passed.
	 * 
	 * @return returns amount, type double
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * Sets and stores the amount from the parameter passed.
	 * This is an instance method.
	 * Invoked by Amount(Currency, double) in Amount.
	 * 
	 * @param amount: amount you want to convert
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * Calculate and convert currency amount.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * 
	 * @param otherCurrency: currency you want to convert to
	 * @return returns converted currency amount, type double
	 */
	public double getAmountIn(Currency otherCurrency) {
		return amount * currency.getExchangeRate() / otherCurrency.getExchangeRate();
	}
	
	public Amount getAmountIn(Currency otherCurrency, String code){
		
		double calculations = amount * currency.getExchangeRate() / otherCurrency.getExchangeRate();	
		Amount amount = new Amount(otherCurrency, calculations);
		return amount; 
		
	}
}
