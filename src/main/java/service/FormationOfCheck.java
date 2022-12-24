package main.java.service;

import main.java.entity.Basket;

import java.util.List;
import java.util.Map;

public interface FormationOfCheck {

    Map<Integer, Basket> resultMap (Map<Integer,Integer> map, List<Basket> list, String [] args);

    void discountFromCard (String [] args, List<String> list, Map<Integer, Basket> map);


}
