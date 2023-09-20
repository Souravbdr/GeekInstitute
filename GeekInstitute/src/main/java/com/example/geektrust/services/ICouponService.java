package com.example.geektrust.services;

import com.example.geektrust.entities.Coupon;
import com.example.geektrust.entities.CouponName;

public interface ICouponService {
    public Coupon create(CouponName name, Integer discountPercentage);
    public Coupon getCoupon(CouponName name);
}
