package com.ankit.ConfigManagementSystem;

import com.ankit.ConfigManagementSystem.Exceptions.ConfigNameAlreadyExistException;
import com.ankit.ConfigManagementSystem.Exceptions.ConfigNameDoesnotExistException;
import com.ankit.ConfigManagementSystem.Exceptions.MachineAlreadySubscribed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bucket {
    private final String name;
    private Map<String, Config> configNameToConfig;
    private List<Machine> subscribers;

    Bucket(String name) {
        this.name = name;
        configNameToConfig = new HashMap<>();
        subscribers = new ArrayList<>();
    }

    void addConfig(String configName, String configXML) throws Exception {
        if (configNameToConfig.containsKey(configName)) {
            throw new ConfigNameAlreadyExistException();
        }

        configNameToConfig.put(configName, new Config(configName, configXML));
        updateMachines();
    }

    void updateConfig(String configName, String configXML) throws Exception {
        if (!configNameToConfig.containsKey(configName)) {
            throw new ConfigNameDoesnotExistException();
        }

        Config config = configNameToConfig.get(configName);
        config.update(configXML);
        updateMachines();
    }

    private void updateMachines() {
        List<Config> configs = new ArrayList<>(configNameToConfig.values());
        subscribers.parallelStream().forEach(machine -> machine.update(configs));
    }

    void addSubscriber(Machine machine) throws Exception {
        if (subscribers.contains(machine)) {
            throw new MachineAlreadySubscribed();
        }

        subscribers.add(machine);
    }
}
