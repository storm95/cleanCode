package com.ankit.ConfigManagementSystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConfigManagerTest {

    @Test
    public void TestConfigManager() throws Exception{
        ConfigManager configManager = ConfigManager.getInstance();
        String bucketName1 = "bucketName1";
        configManager.createBucket(bucketName1);
        String configName1 = "configName1";
        configManager.addConfigToBucket(bucketName1, configName1, "111111");
        configManager.addSubscriber(new LinuxMachine("LinuxMachine1"), bucketName1);
        configManager.updateConfig(configName1, "11111a");
        String configName2 = "configName2";
        configManager.addConfigToBucket(bucketName1, configName2, "2222222");
        configManager.addSubscriber(new LinuxMachine("LinuxMachine2"), bucketName1);
        configManager.updateConfig(configName1, "11111b");
        configManager.updateConfig(configName2, "22222b");
    }
}
