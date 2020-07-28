package com.ankit.dgraph.interview2.mapperlibrary;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Mapper {

    public List<Integer> map(List<Integer> operands, Operator operator) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Integer> mappedArray = new Vector<>(Collections.nCopies(operands.size(), 0));
        for(int i=0;i<operands.size();++i) {
            Integer operand = operands.get(i);
            int finalI = i;
            executorService.submit(
                    () -> {
                        mappedArray.set(finalI, operator.operate(operand));
                    }
            );
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mappedArray;
    }
}
