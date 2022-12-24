package main.java.reader;

import main.java.entity.Basket;
import main.java.exception.ProductNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReaderFileAndParameters implements Reader {

    @Override
    public Map<Integer, Integer> readingParameters(String[] args) {

        Map<Integer, Integer> products = new HashMap<>();
        Integer cardNumber = null;
        Integer id;
        Integer quantity;
        int totalQuantity;
        for (String arg : args) {
            String[] parts = arg.split("-");
            if (parts[0].equals("card")) {
                cardNumber = Integer.valueOf(parts[1]);
            } else {
                id = Integer.valueOf(parts[0]);
                quantity = Integer.valueOf(parts[1]);
                Integer subtotal = products.getOrDefault(id, 0);
                totalQuantity = subtotal + quantity;
                products.put(id, totalQuantity);
            }
        }
        return products;
    }

    @Override
    public List<Basket> productReader(String[] args) {
        List<Basket> lines = new ArrayList<>();
        double totalPrice = 0.0;
        Map<Integer, Integer> products = readingParameters(args);
        try (var reader = new BufferedReader(new FileReader("src/resources/products"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(new Basket(line));
            }
            for (Basket pr : lines) {
                pr.setId(pr.itemId());
                pr.setNameProduct(pr.nameOfProducts());
                pr.setPriceProduct(pr.priceProducts());
                for (Map.Entry<Integer, Integer> entry : products.entrySet()) {
                    if (pr.getId() == entry.getKey()) {
                        pr.setPriceQuantity(pr.getPriceProduct(), entry.getValue());
                        pr.setQuantity(entry.getValue());
                        if (entry.getValue() >= 5) {
                            pr.setPriceQuantity(pr.discountPrice());
                            totalPrice = totalPrice + pr.getPriceQuantity();
                            pr.setTotalPrice(totalPrice);
                        } else {
                            totalPrice = totalPrice + pr.getPriceQuantity();
                            pr.setTotalPrice(totalPrice);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public List<String> discountReader() {
        List<String> lines = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader("src/resources/discountCards"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public String cardNumber(String[] args) {
        String cardNumber = null;
        for (String arg : args) {
            String[] parts = arg.split("-");
            if (parts[0].equals("card")) {
                cardNumber = parts[1];
            }
        }
        return cardNumber;
    }
}
