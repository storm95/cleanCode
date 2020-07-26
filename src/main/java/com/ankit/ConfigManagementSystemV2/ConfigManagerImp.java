package com.ankit.ConfigManagementSystemV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManagerImp implements ConfigManager{

    private final Map<String, Machine> machineMap;
    private final Map<String, Bucket> bucketMap;
    private final Map<String, Config> configMap;

    ConfigManagerImp() {
        machineMap = new HashMap<>();
        bucketMap = new HashMap<>();
        configMap = new HashMap<>();
    }

    public void addMachine(String machineName) { //add mapping from machineName to machine
        Machine machine = new MachineImp(machineName);
        machineMap.put(machineName, machine);
    }

    public void addBucket(String bucketName) { //add mapping from bucketname to bucket
        Bucket bucket = new BucketImp(bucketName);
        bucketMap.put(bucketName, bucket);
    }

    public void addConfig(String bucketName, String configName, String configXML) { //add mapping from configName to config
        Bucket bucket = bucketMap.get(bucketName);
        Config config = new ConfigImp(bucket, configName, configXML);
        bucket.addConfig(config);
        configMap.put(configName, config);
    }

    public void updateConfig(String configName, String configXML) { //update the config
        Config config = configMap.get(configName);
        config.update(configXML);
    }

    public void addSubscribers(String bucketName, List<String> machineNames) { //add subscribers to bucket
        Bucket bucket = bucketMap.get(bucketName);
        for (String machineName : machineNames) {
            Machine machine = machineMap.get(machineName);
            bucket.addSubscriber(machine);
        }
    }
}
