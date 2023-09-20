package com.example.geektrust.repositories.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entities.Coupon;
import com.example.geektrust.entities.CouponName;
import com.example.geektrust.repositories.ICouponRepository;

public class CouponRepository implements ICouponRepository{

    private final Map<CouponName,Coupon> couponMap;

    public CouponRepository() {
        couponMap = new HashMap<>();
    }

    @Override
    public Coupon save(Coupon entity) {
        if(!couponMap.containsKey(entity.getName())){
            entity = new Coupon(entity.getName(),entity.getDiscountPercentage());
        }
        couponMap.put(entity.getName(),entity);
        return entity;
    }

    @Override
    public List<Coupon> findAll() {
        return new ArrayList<>(couponMap.values());
    }

    @Override
    public Optional<Coupon> findById(CouponName id) {
       return Optional.ofNullable(couponMap.get(id));
    }

    
}
