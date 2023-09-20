package com.example.geektrust.services.implementations;

import com.example.geektrust.constants.ApplicationConstants;
import com.example.geektrust.dto.BillDTO;
import com.example.geektrust.entities.Cart;
import com.example.geektrust.entities.Coupon;
import com.example.geektrust.entities.CouponName;
import com.example.geektrust.entities.Program;
import com.example.geektrust.entities.ProgramName;
import com.example.geektrust.repositories.ICartRepository;
import com.example.geektrust.services.ICartService;
import com.example.geektrust.services.ICouponService;
import com.example.geektrust.services.IProgramService;

public class CartService implements ICartService {

    private final ICartRepository cartRepository;
    private final IProgramService programService;
    private final ICouponService couponService;

    public CartService(ICartRepository cartRepository, IProgramService programService, ICouponService couponService) {
        this.cartRepository = cartRepository;
        this.programService = programService;
        this.couponService = couponService;
    }

    @Override
    public void addProgram(ProgramName category) {
        Cart cart = cartRepository.getCart();
        Program program = programService.getProgram(category);
        cart.setPrograms(program);
        cartRepository.save(cart);
    }

    @Override
    public void applyCoupon(CouponName couponName) {
        Cart cart = cartRepository.getCart();
        Coupon coupon = couponService.getCoupon(couponName);
        cart.setCouponApplied(coupon);
        cartRepository.save(cart);
    }

    @Override
    public void addProMembership() {
        Cart cart = cartRepository.getCart();
        cart.setProMembershipFees(ApplicationConstants.proMembershipfees);
        cartRepository.save(cart);
    }

    @Override
    public BillDTO computeBill() {
        Cart cart = cartRepository.getCart();
        Double couponDiscount = applyCouponConditional(cart, null);
        Double programSubTotal = getProgramSubTotal(cart)[ApplicationConstants.INTZERO];
        Double totalProDiscount = getProgramSubTotal(cart)[ApplicationConstants.INTONE];
        couponDiscount = (couponDiscount == ApplicationConstants.ZERO) ? applyCoupon(cart, programSubTotal) : couponDiscount;
        Double enrollmentFee = (programSubTotal < ApplicationConstants.programFeeBottleNeck) ? ApplicationConstants.enrollmentFees : ApplicationConstants.INTZERO;
        Double total = programSubTotal + enrollmentFee - couponDiscount;
        return new BillDTO(programSubTotal, cart.getFinalAppliedCoupon(), couponDiscount, totalProDiscount,
                cart.getProMembershipFees().doubleValue(), enrollmentFee, total);
    }

    private Double[] getProgramSubTotal(Cart cart) {
        Double subTotal = ApplicationConstants.ZERO;
        boolean isProMember = cart.getProMembershipFees() != ApplicationConstants.INTZERO;
        Double totalProDiscount = ApplicationConstants.ZERO;

        for (Program program : cart.getPrograms()) {
            Double discount = isProMember ? (program.getDiscountPercentage() / ApplicationConstants.HUNDRED) : ApplicationConstants.ZERO;
            totalProDiscount += (program.getFees() * discount);
            subTotal += program.getFees();
        }
        return new Double[] { subTotal-totalProDiscount + cart.getProMembershipFees(), totalProDiscount };
    }
    private Double applyCouponConditional(Cart cart, Double subTotal) {
        if (cart.getPrograms().size() < ApplicationConstants.MIN_SIZE_B4G1) return ApplicationConstants.ZERO;

        Program program = programService.getMinFeesProgram();
        if(!cart.getPrograms().contains(program)){
            cart.getPrograms().add(program);
        }
        cart.setFinalAppliedCoupon(CouponName.B4G1);
        Double discountAmount = program.getFees() - (program.getFees()*program.getDiscountPercentage()/ApplicationConstants.HUNDRED);
        return discountAmount;
    }
    private Double applyCoupon(Cart cart, Double subTotal) {
        if (subTotal !=null && subTotal >= ApplicationConstants.minPurchaseValueG20 && cart.getCouponApplied().containsKey(CouponName.DEAL_G20)) {
            return getDiscountPer(CouponName.DEAL_G20,cart,subTotal);
        } else if (subTotal !=null && cart.getPrograms().size() >= ApplicationConstants.MIN_SIZE_DEALG5 && cart.getCouponApplied().containsKey(CouponName.DEAL_G5)) {
            return getDiscountPer(CouponName.DEAL_G5,cart,subTotal);
        }
        return ApplicationConstants.ZERO;
    }
    private Double getDiscountPer(CouponName couponName, Cart cart, Double subTotal){
        cart.setFinalAppliedCoupon(couponName);
        return subTotal * cart.getCouponApplied().get(couponName).getDiscountPercentage()/ ApplicationConstants.HUNDRED;
    }

}
