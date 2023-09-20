package com.example.geektrust.entities;

public class Coupon {
    
    private CouponName name;
    private Integer discountPercentage;
    
    public Coupon(CouponName name, Integer discountPercentage) {
        this.name = name;
        this.discountPercentage = discountPercentage;
    }

    public CouponName getName() {
        return name;
    }
    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

}
