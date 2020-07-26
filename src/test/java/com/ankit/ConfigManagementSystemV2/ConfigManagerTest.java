package com.ankit.ConfigManagementSystemV2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class ConfigManagerTest {
    @Test
    public void test() {
        ConfigManager configManager = new ConfigManagerImp();
        configManager.addMachine("Machine 1");
        configManager.addMachine("Machine 2");
        configManager.addBucket("Bucket 1");
        configManager.addConfig("Bucket 1", "Config 1", "XML 1");
        configManager.addSubscribers("Bucket 1", Arrays.asList("Machine 1", "Machine 2"));
        configManager.updateConfig("Config 1", "XML 1.2");
    }
}
