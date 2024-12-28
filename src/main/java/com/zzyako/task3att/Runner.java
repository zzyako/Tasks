package com.zzyako.task3att;

import com.zzyako.task3att.entity.SwimmerEntity;
import com.zzyako.task3att.service.SwimmerService;
import com.zzyako.task3att.service.SwimmerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {

    private final SwimmerService swimmerService;

    public Runner(SwimmerService swimmerService) {
        this.swimmerService = swimmerService;
    }


    @Override
    public void run(String[] args) {
        SwimmerEntity newCar = swimmerService.addNewSwimmer("BMW", "Седан");
        System.out.println("Добавлена новая машина с ID: " + newCar.getSwimmer_id());

        swimmerService.updateSwimmer(UUID.fromString("8eaaa877-5af8-428e-9f2c-423cb3498792"), "Toyota", "Купе");
        System.out.println("обновили машину");

        swimmerService.delSwimmerById(UUID.fromString("a94d8bca-f267-45eb-a266-cbbdeaf42e40"));
        System.out.println("Удалили машину");
    }
}