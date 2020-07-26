package com.ankit.ConfigManagementSystemV2;

import java.util.List;

public class MachineImp implements Machine {
    String name;

    MachineImp(String name) {
        this.name = name;
    }

    public void update(List<Config> configs) {
      System.out.println(name+" updated.");
    }
}
