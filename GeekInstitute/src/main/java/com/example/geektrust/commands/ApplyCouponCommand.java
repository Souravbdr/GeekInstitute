package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.constants.ApplicationConstants;
import com.example.geektrust.entities.CouponName;
import com.example.geektrust.services.ICartService;

public class ApplyCouponCommand implements ICommand{
    private final ICartService cartService;

    public ApplyCouponCommand(ICartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute(List<String> tokens) {
        cartService.applyCoupon(CouponName.valueOf(tokens.get(ApplicationConstants.DIPLOMA_DISCOUNT)));
    }


    
}
