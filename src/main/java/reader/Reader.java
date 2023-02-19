package reader;

import main.java.entity.Basket;

import java.util.List;
import java.util.Map;

public interface Reader {

    Map<Integer, Integer> readingParameters (String [] args);

    List<Basket> productReader(String [] args);

    List <String> discountReader();



}
