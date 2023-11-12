package currency;
public class Currency implements ICurrency {
    private String currencyName;
    private String currencyCode;
    private double currencyScaler;
    private double exchangeRate;

    @Override
    public void setCurrencyName(String name) {
        this.currencyName = name;
    }

    @Override
    public void setCurrencyCode(String code) {
        this.currencyCode = code;
    }

    @Override
    public void setCurrencyScaler(double scaler) {
        this.currencyScaler = scaler;
    }

    @Override
    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String getCurrencyName() {
        return currencyName;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public double getCurrencyScaler() {
        return currencyScaler;
    }

    @Override
    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Currency currency = (Currency) obj;
        return this.currencyCode.equals(currency.getCurrencyCode());
    }
}
