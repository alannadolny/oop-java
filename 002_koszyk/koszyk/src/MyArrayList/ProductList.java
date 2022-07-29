package MyArrayList;

import Products.Product;

import java.util.Arrays;

public class ProductList extends AbstractList<Product> {

    public ProductList() {
        super(new Product[0]);
    }

    public ProductList(Product[] list) {
        super(list);
    }

    public void remove(Product product) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].getCode().equals(product.getCode()) &&
                    this.list[i].getPrice() == product.getPrice() &&
                    this.list[i].getName().equals(product.getName())) {
                this.list[i] = this.list[this.list.length - 1];
                this.list = Arrays.copyOf(this.list, this.list.length - 1);
                return;
            }
        }
    }

    public Product find(String code) {
        Product toReturn = null;
        for (Product product : this.list) {
            if (product.getCode().equals(code)) {
                toReturn = product;
            }
        }
        return toReturn;
    }

    public void reverse() {
        ProductList temp = new ProductList();
        for (int i = this.list.length - 1; i >= 0; i--) {
            temp.add(this.list[i]);
        }
        this.list = temp.getList();
    }

    public void set(int index, Product prod) {
        this.list[index] = prod;
    }

}
