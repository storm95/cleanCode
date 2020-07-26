package com.ankit.ConfigManagementSystemV2;

public interface Bucket {
    void update(); //should update the machines
    void addSubscriber(Machine machine); //have list of Subscriber
    void addConfig(Config config); //have list of Config
}
