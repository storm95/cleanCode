package com.ankit.ConfigManagementSystem;

public class Config {
    private final String name;
    private String configXML;

    Config(String name, String configXML) {
        this.name = name;
        this.configXML = configXML;
    }

    void update(String configXML) {
        this.configXML = configXML;
    }

    public String toString() {
        return name+" "+configXML;
    }
}
