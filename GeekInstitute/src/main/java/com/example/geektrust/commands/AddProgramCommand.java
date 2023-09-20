package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.constants.ApplicationConstants;
import com.example.geektrust.entities.ProgramName;
import com.example.geektrust.services.ICartService;

public class AddProgramCommand implements ICommand{

    private final ICartService cartService;

    public AddProgramCommand(ICartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void execute(List<String> tokens) {
        int count=0;
        while(count++<Integer.parseInt(tokens.get(ApplicationConstants.MIN_SIZE_DEALG5))){
            cartService.addProgram(ProgramName.valueOf(tokens.get(ApplicationConstants.DIPLOMA_DISCOUNT)));
        }
    }
    
}
