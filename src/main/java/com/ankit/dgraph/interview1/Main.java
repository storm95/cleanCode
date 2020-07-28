package com.ankit.dgraph.interview1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Crawler c = new Crawler(4);
        List<String> urls = c.getUrls(Arrays.asList("1", "2", "3", "4"));
    }
}
