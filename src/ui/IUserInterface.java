package ui;

import currency.ICurrency;
import currency_collector.ICurrencyCollector;
import exchange.IExchange;

public interface IUserInterface {

    void start();

    void exchange();

    void printAllCurrencies(ICurrencyCollector currencyList);

    void setCurrencyCollection(ICurrencyCollector currencyList);

    void setExchange(IExchange exchanger);

    ICurrency stringToCurrency(String code);
}
