package Products;

public class Product implements Comparable<Product> {
    private final int price;
    private final String code;
    private final String name;
    private double discountPrice;

    public Product(int price, String code, String name) {
        this.price = price;
        this.code = code;
        this.name = name;
        this.discountPrice = price;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return this.name;
    }

    public double getDiscountPrice() {
        return this.discountPrice;
    }

    public int getPrice() {
        return this.price;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.discountPrice - o.discountPrice);
    }
}
