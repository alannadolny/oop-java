package MyArrayList;

import Interfaces.Discount;

import java.util.Arrays;

public class DiscountList extends AbstractList<Discount> {

    public DiscountList() {
        super(new Discount[0]);
    }

    public void remove(String code) {
        for (int i = 0; i < this.list.length; i++) {
            if (this.list[i].getDiscountCode().equals(code)) {
                this.list[i] = this.list[this.list.length - 1];
                this.list = Arrays.copyOf(this.list, this.list.length - 1);
                return;
            }
        }
    }
}
