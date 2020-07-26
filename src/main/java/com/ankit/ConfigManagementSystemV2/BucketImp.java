package com.ankit.ConfigManagementSystemV2;

import java.util.ArrayList;
import java.util.List;

public class BucketImp implements Bucket {
    String name;
    List<Machine> machines;
    List<Config> configs;

    BucketImp(String name) {
        this.name = name;
        machines = new ArrayList<>();
        configs = new ArrayList<>();
    }

    public void update() { //should update the machines
        System.out.println(name+" is updated.");
        for (Machine machine : machines) machine.update(configs);
    }

    public void addSubscriber(Machine machine) { //have list of Subscriber
        machines.add(machine);
    }

    public void addConfig(Config config) { //have list of Config
        configs.add(config);
    }
}
