package com.example.geektrust.entities;

public class Program {
    private ProgramName name;
    private Double fees;
    private Integer discountPercentage;

    public Program(ProgramName name, Double fees, Integer discountPercentage) {
        this.name = name;
        this.fees = fees;
        this.discountPercentage = discountPercentage;
    }

    public ProgramName getName() {
        return name;
    }

    public Double getFees() {
        return fees;
    }

    public Integer getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Program other = (Program) obj;
        if (name != other.name)
            return false;
        return true;
    }
    
}
