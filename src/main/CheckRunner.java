package main;

import main.java.entity.Basket;
import main.java.print.PrintCheck;
import main.java.reader.ReaderFileAndParameters;
import main.java.service.CheckResult;

import java.io.IOException;
import java.util.*;

public class CheckRunner {

    public static void main(String[] args) throws IOException {

        ReaderFileAndParameters parameters = new ReaderFileAndParameters();
        Map<Integer, Integer> paramsFromArg = parameters.readingParameters(args);
        List<Basket> allProductsFromFile = parameters.productReader(args);
        List<String> allDiscountCards = parameters.discountReader();

        CheckResult result = new CheckResult();
        Map<Integer, Basket> myBasket = result.resultMap(paramsFromArg, allProductsFromFile, args);
        double totalPrice = result.discountFromCard(args, allDiscountCards, myBasket);

        PrintCheck printCheck = new PrintCheck();
        printCheck.print(myBasket, parameters.cardNumber(args), totalPrice);
    }
}



