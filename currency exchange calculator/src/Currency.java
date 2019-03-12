
public class Currency {
	private String code;
	private double exchangeRate;
	/**
	 * 
	 * @param code
	 * @param exchangeRate
	 */
	public Currency(String code, double exchangeRate) {
		this.code = code;
		this.exchangeRate = exchangeRate;
	}
	/**
	 * Gets the currency code. 
	 * This is a instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * No parameters passed.
	 * 
	 * @return returns currency code as a String type
	 */
	public String getCode() {
		return code;
	}
	/**
	 * Gets the exchange rate.  
	 * This is an instance method.
	 * Invoked by showRate() in CurrencyExchangeProgram.
	 * No parameters passed.
	 * 
	 * @return
	 */
	public double getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * Sets a new exchange rate.
	 * This is an instance method.
	 * Not invoked by any code.
	 * 
	 * @param newExchangeRate
	 */
	public void setExchangeRate(double newExchangeRate) {
		exchangeRate = newExchangeRate;
	}
}
