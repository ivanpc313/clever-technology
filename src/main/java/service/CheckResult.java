package main.java.service;

import main.java.entity.Basket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckResult implements FormationOfCheck {

    @Override
    public Map<Integer, Basket> resultMap(Map<Integer, Integer> map, List<Basket> list, String [] args) {

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
                                .orElseThrow(() -> new RuntimeException("Products with id = " + id + " not found"))
                ));
        return result;
    }

    @Override
    public void discountFromCard(String[] args, List<String> list, Map<Integer, Basket> map) {
        Integer cardNumber = null;
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
        if (numberCards.contains(cardNumber)) { //скидка с учетом скидочной карты не реализована

        }
    }

}
