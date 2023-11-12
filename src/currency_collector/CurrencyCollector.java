package currency_collector;

import currency.Currency;
import currency.ICurrency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyCollector implements ICurrencyCollector {
    private List<ICurrency> currencyList;

    public CurrencyCollector() {
        currencyList = new ArrayList<>();
    }

    @Override
    public void addCurrency(String name, String code, double scaler, double rate) {
        ICurrency currency = new Currency();
        currency.setCurrencyName(name);
        currency.setCurrencyCode(code);
        currency.setCurrencyScaler(scaler);
        currency.setExchangeRate(rate);
        currencyList.add(currency);
    }

    @Override
    public List<ICurrency> getCurrencyList() {
        return this.currencyList;
    }

    @Override
    public ICurrency getCurrencyByCode(ICurrency currency) {
        for (ICurrency c : currencyList) {
            if (currency.equals(c)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String temp = "";
        for (ICurrency c : currencyList) {
            temp += c.getCurrencyCode() + " Scaler = " + c.getCurrencyScaler() + " Exchange Rate = " + c.getExchangeRate() + "\n";
        }
        return temp;
    }

}
