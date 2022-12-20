package by.clever_technology;

import java.util.List;
import java.util.Map;

public interface Reader {

    Map<Integer, Integer> readingParameters (String [] args);

    List<Basket> productReader(String [] args);

    List <String> discountReader();



}
