package currency;

import java.math.BigDecimal;

public interface ICurrency {
    void setCurrencyName(String name);
    void setCurrencyCode(String code);
    void setCurrencyScaler(double scaler);
    void setExchangeRate(double exchangeRate);

    String getCurrencyName();
    String getCurrencyCode();
    double getCurrencyScaler();
    double getExchangeRate();

}
