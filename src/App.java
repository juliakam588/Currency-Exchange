import currency_collector.CurrencyCollector;
import currency_collector.ICurrencyCollector;
import exchange.Exchange;
import exchange.IExchange;
import ui.IUserInterface;
import ui.UserInterface;

import java.io.IOException;

public class App {
    private static App instance = null;
    private ICurrencyCollector list;
    private IUserInterface ui;
    private IExchange exchanger;
    private RemoteProvider remoteProvider;
    private byte[] data;
    private XMLParser xmlP;

    private App() {}
    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    public void init() {
        list = new CurrencyCollector();
        ui = new UserInterface();
        exchanger = new Exchange();
        remoteProvider = new RemoteProvider();
        xmlP = new XMLParser();

        try {
            data = remoteProvider.getData("https://www.nbp.pl/kursy/xml/lasta.xml");
            xmlP.setData(data);
            xmlP.parseData(list);
            ui.setCurrencyCollection(list);
            ui.setExchange(exchanger);
            ui.start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
