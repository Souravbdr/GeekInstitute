package com.example.geektrust.services.implementations;

import com.example.geektrust.entities.Coupon;
import com.example.geektrust.entities.CouponName;
import com.example.geektrust.repositories.ICouponRepository;
import com.example.geektrust.services.ICouponService;

public class CouponService implements ICouponService{

    private final ICouponRepository couponRepository;

    public CouponService(ICouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon create(CouponName name, Integer discountPercentage) {
        Coupon coupon = new Coupon(name, discountPercentage);
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon getCoupon(CouponName name) {
       return couponRepository.findById(name).get();
    }
    
}
