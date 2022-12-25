package main.java.entity;

public class Basket {

    private int id;
    private String nameProduct;
    private int priceProduct;
    private double priceQuantity;
    private double totalPrice;
    private int quantity;
    private String isSale;

    private final String raw;

    public Basket(String raw) {
        this.raw = raw;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public double getPriceQuantity() {
        return priceQuantity;
    }

    public void setPriceQuantity(int priceProduct, Integer priceQuantity) {
        this.priceQuantity = priceQuantity * priceProduct;
    }

    public void setPriceQuantity(double discount) {
        this.priceQuantity = discount;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getIsSale() {
        return isSale;
    }

    public void setSale(String sale) {
        isSale = sale;
    }

    public double discountPrice() {
        return getPriceQuantity() - (getPriceQuantity() * 0.1);
    }

    private String[] parts() {
        return raw.split(";");
    }

    public int itemId() {
        return Integer.parseInt(parts()[0]);
    }

    public String nameOfProducts() {
        return parts()[1];
    }

    public int priceProducts() {
        return Integer.parseInt(parts()[2]);
    }

    public String is_on_sale() {
        return parts()[3];
    }

    @Override
    public String toString() {
        return "\n" + quantity + "   " + nameProduct + "          "
                + priceProduct + "$        " + priceQuantity + "$   " + "\n";

    }

}

