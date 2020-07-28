package com.ankit.dgraph.interview1;

// We have to design a concurrent web crawler.
// input = ["dgraph.io", "lyft.com",....]
// It should crawl these webpages, find out the URLs on them and then crawl those after.
// It should return an unordered output list with the all the URLs that it has crawled.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Crawler {

    public volatile String x;
    private final List<String> visitedUrls;
    private final ExecutorService executorService;

    Crawler(int noOfThreads) {
        visitedUrls = new ArrayList<>();
        executorService = Executors.newFixedThreadPool(noOfThreads);
    }

    private void crawlUrls(List<String> urls) {

        for (String url : urls) {
            executorService.submit(() -> {
                synchronized (visitedUrls) {
                    if (visitedUrls.contains(url))
                        return;

                    visitedUrls.add(url);
                }

                System.out.println(url);
                List<String> urlsOnThisPage = getUrlsOnPage(url);
                crawlUrls(urlsOnThisPage);

            });
        }
    }

    public List<String> getUrls(List<String> urls) {
        crawlUrls(urls);
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return visitedUrls;
    }

    private List<String> getUrlsOnPage(String url) {
        //returns a list of urls in this page
        return new ArrayList<>();
    }
}
