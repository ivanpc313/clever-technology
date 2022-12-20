package by.clever_technology;

import java.util.List;
import java.util.Map;

public interface FormationOfCheck {

    Map<Integer, Basket> resultMap (Map<Integer,Integer> map, List<Basket> list, String [] args);

    void discountFromCard (String [] args, List<String> list, Map<Integer, Basket> map);


}
