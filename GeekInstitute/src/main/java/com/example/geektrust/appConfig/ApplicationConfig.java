package com.example.geektrust.appConfig;

import com.example.geektrust.commands.AddProMembershipCommand;
import com.example.geektrust.commands.AddProgramCommand;
import com.example.geektrust.commands.ApplyCouponCommand;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.PrintBillCommand;
import com.example.geektrust.constants.ApplicationConstants;
import com.example.geektrust.entities.CouponName;
import com.example.geektrust.entities.ProgramName;
import com.example.geektrust.repositories.ICartRepository;
import com.example.geektrust.repositories.ICouponRepository;
import com.example.geektrust.repositories.IProgramRepository;
import com.example.geektrust.repositories.implementations.CartRepository;
import com.example.geektrust.repositories.implementations.CouponRepository;
import com.example.geektrust.repositories.implementations.ProgramRepository;
import com.example.geektrust.services.ICartService;
import com.example.geektrust.services.ICouponService;
import com.example.geektrust.services.IProgramService;
import com.example.geektrust.services.implementations.CartService;
import com.example.geektrust.services.implementations.CouponService;
import com.example.geektrust.services.implementations.ProgramService;

public class ApplicationConfig {
    private final IProgramRepository programRepository = new ProgramRepository();
    private final ICouponRepository couponRepository = new CouponRepository();
    private final ICartRepository cartRepository = new CartRepository();

    private final IProgramService programService = new ProgramService(programRepository);
    private final ICouponService couponService = new CouponService(couponRepository);
    private final ICartService cartService = new CartService(cartRepository, programService, couponService);

    private final AddProgramCommand addProgramCommand = new AddProgramCommand(cartService);
    private final AddProMembershipCommand addProMembershipCommand = new AddProMembershipCommand(cartService);
    private final ApplyCouponCommand applyCouponCommand = new ApplyCouponCommand(cartService);
    private final PrintBillCommand printBillCommand = new PrintBillCommand(cartService);

    private final CommandInvoker commandInvoker = new CommandInvoker();



    public CommandInvoker getCommandInvoker(){
        programService.create(ProgramName.CERTIFICATION, ApplicationConstants.CERTIFICATION_FEES, ApplicationConstants.CERTIFICATION_DISCOUNT);
        programService.create(ProgramName.DEGREE, ApplicationConstants.DEGREE_FESS, ApplicationConstants.DEGREE_DISCOUNT);
        programService.create(ProgramName.DIPLOMA, ApplicationConstants.DIPLOMA_FEES, ApplicationConstants.DIPLOMA_DISCOUNT);
        couponService.create(CouponName.B4G1, ApplicationConstants.B4G1_DISCOUNT);
        couponService.create(CouponName.DEAL_G20, ApplicationConstants.DEAL_G20_DISCOUNT);
        couponService.create(CouponName.DEAL_G5, ApplicationConstants.DEAL_G5_DISCOUNT);
        commandInvoker.register("ADD_PROGRAMME", addProgramCommand);
        commandInvoker.register("APPLY_COUPON", applyCouponCommand);
        commandInvoker.register("ADD_PRO_MEMBERSHIP", addProMembershipCommand);
        commandInvoker.register("PRINT_BILL", printBillCommand);
        return commandInvoker;
    }
    
}
