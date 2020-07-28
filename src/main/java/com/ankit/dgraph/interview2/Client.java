package com.ankit.dgraph.interview2;

import com.ankit.dgraph.interview2.mapperlibrary.IncrementOperator;
import com.ankit.dgraph.interview2.mapperlibrary.Mapper;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String args[]) {
        Mapper mapper = new Mapper();
        IncrementOperator incrementOperator = new IncrementOperator();
        List<Integer> operands = Arrays.asList(1, 2, 3, 4, 5);
        long startTime = System.currentTimeMillis();
        List<Integer> mappedArray = mapper.map(operands, incrementOperator);
        long endTime = System.currentTimeMillis();
        System.out.println(mappedArray);
        System.out.println(endTime-startTime);
    }
}
