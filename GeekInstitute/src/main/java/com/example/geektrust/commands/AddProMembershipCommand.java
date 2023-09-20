package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.ICartService;

public class AddProMembershipCommand implements ICommand{

    private final ICartService cartService;

    public AddProMembershipCommand(ICartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute(List<String> tokens) {
        cartService.addProMembership();
    }
    
}
