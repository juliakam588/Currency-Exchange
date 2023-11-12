package ui;

import currency.Currency;
import currency.ICurrency;
import currency_collector.ICurrencyCollector;
import exchange.IExchange;


import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface implements IUserInterface {
    private IExchange exchanger;
    private ICurrencyCollector currencyCollection;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {
        int choice;
        while (true) {
            System.out.println("1 - Available currencies");
            System.out.println("2 - Currency exchange");
            System.out.println("3 - Stop");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printAllCurrencies(currencyCollection);
                    break;
                case 2:
                    exchange();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error!");
            }
        }
    }

    @Override
    public void exchange() {
        ICurrency startingCurrency = chooseCurrency("Input the code of currency you want to exchange: ");
        if (startingCurrency == null) {
            currencyCodeError();
        } else {

            ICurrency desiredCurrency = chooseCurrency("Input the code of currency you want to exchange it to: ");
            if (desiredCurrency == null) {
                currencyCodeError();
            } else {
                double amount = parseDoubleWithMsg("Money amount to exchange: ");
                System.out.println("Money after exchange: " + exchanger.exchangeMoney(startingCurrency, desiredCurrency, amount) + " " + desiredCurrency.getCurrencyCode());
            }
        }
    }

    @Override
    public void printAllCurrencies(ICurrencyCollector currencyList) {
        System.out.println(currencyList.toString());
    }

    @Override
    public void setCurrencyCollection(ICurrencyCollector currencyList) {
        this.currencyCollection = currencyList;
    }

    @Override
    public void setExchange(IExchange exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public ICurrency stringToCurrency(String code) {
        Currency tempCur = new Currency();
        tempCur.setCurrencyCode(code);
        return currencyCollection.getCurrencyByCode(tempCur);
    }

    private String parseStringWithMsg(String label) {
        System.out.println(label);
        String temp;
        try {
            temp = scanner.next();
        } catch (Exception exception) {
            System.err.print("Input correct data!\n");
            temp = parseStringWithMsg(label);
        }
        return temp.toUpperCase();
    }

    private double parseDoubleWithMsg(String label) {
        System.out.println(label);
        Double temp;
        try {
            temp = scanner.nextDouble();
            if (temp < 0) {
                throw new Exception();
            }
        } catch (InputMismatchException exception) {
            System.err.print("Input correct data!\n");
            scanner = new Scanner(System.in);
            temp = parseDoubleWithMsg(label);
        } catch (Exception exception) {
            System.err.print("The amount of money has to be a positive number!\n");
            temp = parseDoubleWithMsg(label);
        }
        return temp;
    }

    public ICurrency chooseCurrency(String label) {
        return stringToCurrency(parseStringWithMsg(label));
    }


    public void currencyCodeError() {
        System.err.println("Invalid currency code!");
        exchange();
    }
}
