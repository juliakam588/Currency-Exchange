import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import currency.ICurrency;
import currency.Currency;
import currency_collector.ICurrencyCollector;

public class XMLParser {

    private byte[] data;

    public void setData(byte[] data) {
        this.data = data;
    }

    public void parseData(ICurrencyCollector currencyCollector) {
        List<String> currencyList = new ArrayList<>();
        String fileContent = new String(data);

        String regexOpenTag = "<nazwa_waluty>|<przelicznik>|<kod_waluty>|<kurs_sredni>";
        String regexClosingTag = "</nazwa_waluty>|</przelicznik>|</kod_waluty>|</kurs_sredni>";

        Pattern pattern = Pattern.compile(regexOpenTag);

        String[] currenciesArray = Arrays.stream(fileContent.split("\n"))
                .filter(pattern.asPredicate())
                .map(String::trim)
                .map(line -> line.split(regexOpenTag + "|" + regexClosingTag)[1])
                .toArray(String[]::new);

        currencyList.addAll(List.of(currenciesArray));

        parseCurrencies(currencyList, currencyCollector);

    }

    private void parseCurrencies(List<String> currencyList, ICurrencyCollector currencyCollector) {
        String code, name;
        double scaler, rate;
        for (int i = 0; i < currencyList.size(); i += 4) {
            name = currencyList.get(i);
            code = currencyList.get(i + 2);
            scaler = Double.parseDouble(currencyList.get(i + 1).replace(',', '.'));
            rate = Double.parseDouble(currencyList.get(i + 3).replace(',', '.'));

            currencyCollector.addCurrency(name, code, scaler, rate);
        }
        currencyCollector.addCurrency("polski złoty", "PLN", 1, 1);
    }


}
