package main.java.service;

import main.java.entity.Basket;
import main.java.exception.CardNotFoundException;
import main.java.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckResult implements FormationOfCheck {

    @Override
    public Map<Integer, Basket> resultMap(Map<Integer, Integer> map, List<Basket> list, String[] args) {

        Map<Integer, Basket> result = new HashMap<>();
        List<Integer> ids = list.stream()
                .map(Basket::getId)
                .collect(Collectors.toList());
        List<Integer> neededIds = map.keySet().stream()
                .filter(ids::contains)
                .collect(Collectors.toList());
        neededIds.forEach(id -> result.put(id, list.stream()
                .filter(lis -> id.equals(lis.getId()))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(id))
        ));
        return result;
    }

    @Override
    public double discountFromCard(String[] args, List<String> list, Map<Integer, Basket> map) {
        Integer cardNumber = null;
        double discountTotalPrice = 0;

        for (String arg : args) {
            String[] parts = arg.split("-");
            if (parts[0].equals("card")) {
                cardNumber = Integer.valueOf(parts[1]);
            }
        }
        List<Integer> numberCards = new ArrayList<>();
        for (String s : list) {
            String[] parts = s.split("-");
            numberCards.add(Integer.valueOf(parts[1]));
        }

        List<Basket> basket = convertToList(map);

        for (Basket numberCard : basket) {
            discountTotalPrice = numberCard.getTotalPrice();
        }

        for (Integer s : numberCards) {
            if (!numberCards.contains(cardNumber) && cardNumber != null) {
                throw new CardNotFoundException(cardNumber);
            }
        }
        if (cardNumber == null) {
            System.out.println("Скидочная карта не предъявлена");
        } else if (numberCards.contains(cardNumber) && cardNumber == 1234) {
            discountTotalPrice = discountTotalPrice - (discountTotalPrice * 0.05);
        } else if (numberCards.contains(cardNumber) && cardNumber == 1432) {
            discountTotalPrice = discountTotalPrice - (discountTotalPrice * 0.04);
        } else if (numberCards.contains(cardNumber) && cardNumber == 1124) {
            discountTotalPrice = discountTotalPrice - (discountTotalPrice * 0.02);
        } else if (numberCards.contains(cardNumber) && cardNumber == 1342) {
            discountTotalPrice = discountTotalPrice - (discountTotalPrice * 0.07);
        }

        return discountTotalPrice;
    }

    public static List<Basket> convertToList(Map<Integer, Basket> map) {
        return new ArrayList<>(map.values());
    }

}
