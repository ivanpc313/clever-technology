package main.java.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(int id) {
        super(String.format("Product with id %s is not found", id));
    }
}
