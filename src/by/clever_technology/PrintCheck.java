package by.clever_technology;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PrintCheck {

    public void print(Map<Integer, Basket> map, String cardNumber) throws IOException {

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/resources/check.txt", true))) {

            fileWriter.append("QTY  " + "DESCRIPTION  " + "  PRICE  " + "    COST  " + "   TOTAL");
            fileWriter.newLine();
            fileWriter.append("____________________________________________");
            fileWriter.newLine();
            fileWriter.append(map.values().toString());
            fileWriter.newLine();
            fileWriter.append("____________________________________________");
            fileWriter.newLine();
            fileWriter.append("Your discount-card №  ").append(cardNumber);
        }
    }
}
