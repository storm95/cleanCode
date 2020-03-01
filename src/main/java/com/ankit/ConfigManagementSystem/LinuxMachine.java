package com.ankit.ConfigManagementSystem;

import java.util.List;

public class LinuxMachine implements Machine {
    private final String name;

    LinuxMachine(String name) {
        this.name = name;
    }

    public void update(List<Config> configs){
        System.out.println(name+" is getting updated!!!");
        for (Config config: configs) {
            System.out.println(config);
        }
    }
}
