package currency_collector;

import currency.ICurrency;

import java.util.List;

public interface ICurrencyCollector {


    void addCurrency(String name, String code, double scaler, double rate);

    List<ICurrency> getCurrencyList();
    ICurrency getCurrencyByCode(ICurrency currency);


}
