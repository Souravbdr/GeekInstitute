package com.example.geektrust.services;

import com.example.geektrust.dto.BillDTO;
import com.example.geektrust.entities.CouponName;
import com.example.geektrust.entities.ProgramName;

public interface ICartService {
    public void addProgram(ProgramName program);
    public void applyCoupon(CouponName coupon);
    public void addProMembership();
    public BillDTO computeBill();
}
