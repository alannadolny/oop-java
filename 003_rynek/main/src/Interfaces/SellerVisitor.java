package Interfaces;

import Sellers.Seller;

import java.util.ArrayList;

public interface SellerVisitor {

    ArrayList<Float> visit(Seller seller);

}
