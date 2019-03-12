
public class Currencies {
	private int currencyIndex;
	private Currency[] currencies;
	/**
	 * Stores currency codes. 
	 * This is an instance method.
	 * Invoked by addCurrency() in CurrencyExchangeProgram.
	 * No parameters passed. 
	 */
	public Currencies() {
		currencies = null;
		currencyIndex = 0;
	}
	/**
	 * Adds a new currency code.
	 * This is an instance method.
	 * Invoked by addCurrency(String, double) in Currencies.
	 * 
	 * @param newCurrency: currency code to be added 
	 */
	public void addCurrency(Currency newCurrency) {
		if (currencies == null) {
			currencies = new Currency[1];
			currencies[0] = newCurrency;
		}
		else
		{
			Currency[] tmpCurrencies = new Currency[currencies.length + 1];
			for (int i=0; i < currencies.length; i++) {
				tmpCurrencies[i] = currencies[i];
			}
			tmpCurrencies[currencies.length] = newCurrency;
			currencies = tmpCurrencies;
		}
	}
	/**
	 * Instantiates to Currency class. 
	 * This is an instance method
	 * Invoked by addCurrency() in CurrencyExchangeProgram.
	 * 
	 * @param code: currency code to be added
	 * @param exchangeRate: exchange rate of that currency code
	 */
	public void addCurrency(String code, double exchangeRate) {
		Currency newCurrency = new Currency(code,exchangeRate);
		addCurrency(newCurrency);
	}
	/**
	 * Returns a Currency object based on its currency code.
	 * This is an instance method.
	 * Invoked by showRate() in CurrencyExchangeProgram.
	 * 
	 * @param	code: the currency code of the Currency object to retrieve
	 * @return	the Currency object retrieved, or null if its not found 
	 */
	public Currency getCurrencyByCode(String code) {
		for (int i=0; i < currencies.length; i++) {
			if (currencies[i].getCode().equals(code)) return currencies[i];
		}
		return null;
	}
	/**
	 * Deletes currency code.
	 * This is an instance method.
	 * Not invoked by any code.
	 * 
	 * @param code: currency code to be removed 
	 */
	public void deleteCurrencyByCode(String code) {
		if (currencies == null) return;
		for (int i=0; i < currencies.length; i++) {
			if (currencies[i].getCode().equals(code)) {
				if (currencies.length == 1) {
					currencies = null;
					return;
				}
				else
				{
					Currency[] tmpCurrencies = new Currency[currencies.length-1];
					for (int j=0; j<i; j++) {
						tmpCurrencies[j] = currencies[j];
					}
					for (int j=i; j<tmpCurrencies.length; j++) {
						tmpCurrencies[j] = currencies[j+1];
					}
					currencies = tmpCurrencies;
				}
			}
		}
	}
	/**
	 * Resets the currencyIndex to zero.
	 * This is an instance method.
	 * Invoked by listCurrencies() in CurrencyExchangeProgram.
	 * No parameters passed
	 */
	public void reset() {
		currencyIndex = 0;
	}
	/**
	 * Gets the next the currency code in the system.
	 * This is an instance method.
	 * Invoked by listCurrencies() in CurrencyExchangeProgram.
	 * No parameters passed.
	 * 
	 * @return return null if currencyIndex equals currency array, or returns Currency object
	 */
	public Currency next() {
		if (currencyIndex == currencies.length) return null;
		Currency c = currencies[currencyIndex];
		currencyIndex++;
		return c;
	}
	
}
