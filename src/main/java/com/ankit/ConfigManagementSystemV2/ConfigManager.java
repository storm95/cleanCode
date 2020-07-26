package com.ankit.ConfigManagementSystemV2;

import java.util.List;

public interface ConfigManager {
    void addMachine(String machineName); //add mapping from machineName to machine
    void addBucket(String bucketName); //add mapping from bucketname to bucket
    void addConfig(String bucketName, String configName, String configXML); //add mapping from configName to config
    void updateConfig(String configName, String configXML); //update Config
    void addSubscribers(String bucketName, List<String> machineNames); //add subscribers to bucket
}
