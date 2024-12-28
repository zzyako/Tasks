package com.zzyako.task3att.service;

import com.zzyako.task3att.entity.SwimmerEntity;
import com.zzyako.task3att.repository.SwimmerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class SwimmerService {

    private final SwimmerRepository swimmerRepository;


    public SwimmerService(SwimmerRepository swimmerRepository) {
        this.swimmerRepository = swimmerRepository;
    }


    @Transactional
    public SwimmerEntity updateSwimmer(UUID swimmer_id, String swimmerName, String time) {
        Optional<SwimmerEntity> swimmerOpt = swimmerRepository.findById(swimmer_id);

        SwimmerEntity swimmer = swimmerOpt.orElse(null);

        swimmer.setSwimmer(swimmerName);
        swimmer.setTime(time);

        return swimmerRepository.save(swimmer);
    }


    @Transactional
    public SwimmerEntity addNewSwimmer(String swimmerName, String time){
        SwimmerEntity swimmer = new SwimmerEntity();
        swimmer.setSwimmer_id(UUID.randomUUID());
        swimmer.setSwimmer(swimmerName);
        swimmer.setTime(time);

        return swimmerRepository.save(swimmer);
    }

    @Transactional
    public void delSwimmerById(UUID swimmer_id){

        swimmerRepository.deleteById(swimmer_id);
    }

}
