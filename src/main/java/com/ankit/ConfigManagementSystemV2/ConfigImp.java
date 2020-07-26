package com.ankit.ConfigManagementSystemV2;

public class ConfigImp implements Config {
    String name, xml;
    Bucket bucket;

    ConfigImp(Bucket bucket, String name, String xml) {
        this.name = name;
        this.xml = xml;
        this.bucket = bucket;
    }

    public void update(String xml) { //should update the bucket
        System.out.println(name+" updated with xml= "+xml);
        this.xml = xml;
        bucket.update();
    }
}
