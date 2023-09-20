package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.dto.BillDTO;
import com.example.geektrust.services.ICartService;

public class PrintBillCommand implements ICommand {
    private final ICartService cartService;

    public PrintBillCommand(ICartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute(List<String> tokens) {
        BillDTO billDTO = cartService.computeBill();
        System.out.println(billDTO);
    }

}
