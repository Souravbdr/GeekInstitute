package com.example.geektrust.dto;

import java.text.DecimalFormat;

import com.example.geektrust.constants.ApplicationConstants;
import com.example.geektrust.entities.CouponName;

public class BillDTO {
    private Double programSubTotal;
    private CouponName couponName;
    private Double couponDiscount;
    private Double totalProDiscount;
    private Double proMembershipFee;
    private Double enrollmentFee;
    private Double total;

    public BillDTO(Double programSubTotal, CouponName couponName, Double couponDiscount, Double totalProDiscount,
            Double proMembershipFee, Double enrollmentFee, Double total) {
        this.programSubTotal = programSubTotal;
        this.couponName = couponName;
        this.couponDiscount = couponDiscount;
        this.totalProDiscount = totalProDiscount;
        this.proMembershipFee = proMembershipFee;
        this.enrollmentFee = enrollmentFee;
        this.total = total;
    }

    public Double getProgramSubTotal() {
        return programSubTotal;
    }

    public CouponName getCouponName() {
        return couponName;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public Double getTotalProDiscount() {
        return totalProDiscount;
    }

    public Double getProMembershipFee() {
        return proMembershipFee;
    }

    public Double getEnrollmentFee() {
        return enrollmentFee;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setMinimumFractionDigits(ApplicationConstants.CERTIFICATION_DISCOUNT);
        String formattedValue1 = decimalFormat.format(programSubTotal);
        String formattedValue2 = decimalFormat.format(couponDiscount);
        String formattedValue3 = decimalFormat.format(totalProDiscount);
        String formattedValue4 = decimalFormat.format(proMembershipFee);
        String formattedValue5 = decimalFormat.format(enrollmentFee);
        String formattedValue6 = decimalFormat.format(total);
        
        return "SUB_TOTAL " + formattedValue1 
            + "\nCOUPON_DISCOUNT " + couponName + " "+ formattedValue2 
            + "\nTOTAL_PRO_DISCOUNT " + formattedValue3 
            + "\nPRO_MEMBERSHIP_FEE " + formattedValue4
            + "\nENROLLMENT_FEE " + formattedValue5 
            + "\nTOTAL " + formattedValue6;
    }

    

    
}
