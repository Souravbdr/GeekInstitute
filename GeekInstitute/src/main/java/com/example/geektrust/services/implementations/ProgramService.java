package com.example.geektrust.services.implementations;

import java.util.Collections;
import java.util.List;

import com.example.geektrust.entities.Program;
import com.example.geektrust.entities.ProgramName;
import com.example.geektrust.repositories.IProgramRepository;
import com.example.geektrust.services.IProgramService;

public class ProgramService implements IProgramService {

    private final IProgramRepository programRepository;

    public ProgramService(IProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    @Override
    public Program create(ProgramName name, Double fees, Integer discountPercentage) {
        Program program = new Program(name, fees, discountPercentage);
        return programRepository.save(program);
    }

    @Override
    public Program getProgram(ProgramName id) {
        return programRepository.findById(id).get();
    }

    @Override
    public Program getMinFeesProgram() {
        List<Program> programs = programRepository.findAll();
        return Collections.min(programs, (a,b)-> Double.compare(a.getFees(),b.getFees()));
    }
    
}
