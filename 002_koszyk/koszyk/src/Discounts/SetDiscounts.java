package Discounts;

import Interfaces.Discount;

import MyArrayList.DiscountList;

public class SetDiscounts {

    private DiscountList discounts;

    public DiscountList getDiscounts() {
        return this.discounts;
    }

    public void addDiscount(Discount discount) {
        this.discounts.add(discount);
    }

    public int getDiscountsAmount() {
        return this.discounts.getList().length;
    }

    public void removeDiscount(String discountCode) {
        this.discounts.remove(discountCode);
    }

    public static final class Builder {
        private final DiscountList discounts;

        public Builder() {
            this.discounts = new DiscountList();
        }

        public Builder addDiscount(Discount discount) {
            this.discounts.add(discount);
            return this;
        }

        public SetDiscounts build() {
            SetDiscounts discounts = new SetDiscounts();
            discounts.discounts = this.discounts;
            return discounts;
        }
    }
}
