package main.java.exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(int id) {
        super(String.format("Card with id %s is not found", id));
    }

}
