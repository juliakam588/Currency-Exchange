package exchange;
import currency.ICurrency;

public class Exchange implements IExchange {


    @Override
    public double exchangeMoney(ICurrency startingCurrency, ICurrency desiredCurrency, double moneyAmount) {
        double startingCurrencyToPln = moneyAmount / startingCurrency.getCurrencyScaler() * startingCurrency.getExchangeRate();
        double plnToDesiredCurrency = startingCurrencyToPln * desiredCurrency.getCurrencyScaler() / desiredCurrency.getExchangeRate();
        return plnToDesiredCurrency;
    }
}
