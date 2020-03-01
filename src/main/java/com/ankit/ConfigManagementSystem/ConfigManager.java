package com.ankit.ConfigManagementSystem;

import com.ankit.ConfigManagementSystem.Exceptions.BucketAreadyExistsException;
import com.ankit.ConfigManagementSystem.Exceptions.BucketDoesnotExistException;
import com.ankit.ConfigManagementSystem.Exceptions.ConfigNameDoesnotExistException;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static ConfigManager ourInstance = new ConfigManager();
    private Map<String, Bucket> bucketNameToBucket;
    private Map<String, String> configNameToBucketName;

    public static ConfigManager getInstance() {
        return ourInstance;
    }

    private ConfigManager() {
        bucketNameToBucket = new HashMap<>();
        configNameToBucketName = new HashMap<>();
    }

    public void createBucket(String bucketName) throws Exception {
        if (bucketNameToBucket.containsKey(bucketName)) {
            throw new BucketAreadyExistsException();
        }

        bucketNameToBucket.put(bucketName, new Bucket(bucketName));
    }

    public void addConfigToBucket(String bucketName, String configName, String configXML) throws Exception {
        if (!bucketNameToBucket.containsKey(bucketName)) {
            throw new BucketDoesnotExistException();
        }

        Bucket bucket = bucketNameToBucket.get(bucketName);
        bucket.addConfig(configName, configXML);
        configNameToBucketName.put(configName, bucketName);
    }

    public void updateConfig(String configName, String configXML) throws Exception {
        if (!configNameToBucketName.containsKey(configName)) {
            throw new ConfigNameDoesnotExistException();
        }

        String bucketName = configNameToBucketName.get(configName);
        Bucket bucket = bucketNameToBucket.get(bucketName);
        bucket.updateConfig(configName, configXML);
    }

    public void addSubscriber(Machine machine, String bucketName) throws Exception {
        if (!bucketNameToBucket.containsKey(bucketName)) {
            throw new BucketDoesnotExistException();
        }

        Bucket bucket = bucketNameToBucket.get(bucketName);
        bucket.addSubscriber(machine);
    }

}
