package print;

import main.java.entity.Basket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PrintCheck {

    public void print(Map<Integer, Basket> map, String cardNumber, double totalPrice) throws IOException {

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/check.txt", true))) {

            fileWriter.append("QTY  " + "DESCRIPTION  " + "  PRICE  " + "    COST  ");
            fileWriter.newLine();
            fileWriter.append("____________________________________________");
            fileWriter.newLine();
            fileWriter.append(map.values().toString());
            fileWriter.newLine();
            fileWriter.append("____________________________________________");
            fileWriter.newLine();
            String str = Double.toString(totalPrice);
            fileWriter.append("Total price ").append(str).append("$");
            fileWriter.newLine();
            fileWriter.append("Your discount-card №  ").append(cardNumber);
        }
    }
}
