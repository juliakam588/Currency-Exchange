package exchange;

import currency.ICurrency;


public interface IExchange {
    double exchangeMoney(ICurrency startingCurrency, ICurrency desiredCurrency, double moneyAmount);
}
