package com.example.geektrust.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.geektrust.constants.ApplicationConstants;

public class Cart {
    private List<Program> programs;
    private Map<CouponName,Coupon> couponApplied;
    private Integer proMembershipFees;
    private CouponName finalAppliedCoupon;
    public Cart() {
        programs = new ArrayList<>();
        couponApplied = new HashMap<>();
        proMembershipFees = ApplicationConstants.INTZERO;
        finalAppliedCoupon = CouponName.NONE;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public Map<CouponName,Coupon> getCouponApplied() {
        return couponApplied;
    }

    public Integer getProMembershipFees() {
        return proMembershipFees;
    }

    public void setPrograms(Program program) {
        programs.add(program);
    }

    public void setCouponApplied(Coupon coupon) {
        couponApplied.put(coupon.getName(), coupon);
    }

    public void setProMembershipFees(Integer proMembershipFees) {
        this.proMembershipFees = proMembershipFees;
    }

    public CouponName getFinalAppliedCoupon() {
        return finalAppliedCoupon;
    }

    public void setFinalAppliedCoupon(CouponName finalAppliedCoupon) {
        this.finalAppliedCoupon = finalAppliedCoupon;
    } 
    
}
