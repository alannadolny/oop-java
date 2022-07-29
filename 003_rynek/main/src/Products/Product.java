package Products;

public class Product {
    private int quantity;
    private final String name;
    private float price;
    private final float productMargin;
    private final float productCost;

    public Product(String name, int quantity, float productMargin, float productCost) {
        this.name = name;
        this.quantity = quantity;
        this.productMargin = productMargin;
        this.productCost = productCost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setPrice(float price) {
        this.price = price;
    }


    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getProductMargin() {
        return productMargin;
    }

    public float getProductCost() {
        return productCost;
    }
}

