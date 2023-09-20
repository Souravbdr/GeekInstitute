package com.example.geektrust.services;

import com.example.geektrust.entities.Program;
import com.example.geektrust.entities.ProgramName;

public interface IProgramService {
    public Program create(ProgramName name, Double fees, Integer discountPercentage);
    public Program getProgram(ProgramName id);
    public Program getMinFeesProgram();
}
