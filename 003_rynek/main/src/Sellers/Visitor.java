package Sellers;

import Interfaces.SellerVisitor;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Visitor implements SellerVisitor {
    @Override
    public ArrayList<Float> visit(Seller seller) {
        return (ArrayList<Float>) seller.getToSell().stream().map(el -> (el.getProductCost() + el.getProductMargin()) * (seller.getInflation() * 0.01F) + (el.getProductCost() + el.getProductMargin())).collect(Collectors.toList());
    }
}
