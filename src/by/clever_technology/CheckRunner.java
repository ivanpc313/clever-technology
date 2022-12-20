package by.clever_technology;

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
        result.discountFromCard(args, allDiscountCards, myBasket);

        PrintCheck printCheck = new PrintCheck();
        printCheck.print(myBasket, parameters.cardNumber(args));
    }
}



