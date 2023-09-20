package com.example.geektrust.repositories.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entities.Program;
import com.example.geektrust.entities.ProgramName;
import com.example.geektrust.repositories.IProgramRepository;

public class ProgramRepository implements IProgramRepository {

    private final Map<ProgramName,Program> programMap;

    public ProgramRepository() {
        programMap = new HashMap<>();
    }

    @Override
    public Program save(Program entity) {
        if(!programMap.containsKey(entity.getName())){
            entity = new Program(entity.getName(),entity.getFees(),entity.getDiscountPercentage());
        }
        programMap.put(entity.getName(),entity);
        return entity;
    }

    @Override
    public List<Program> findAll() {
        return new ArrayList<>(programMap.values());
    }

    @Override
    public Optional<Program> findById(ProgramName Id) {
       return Optional.ofNullable(programMap.get(Id));
    }
    
}
