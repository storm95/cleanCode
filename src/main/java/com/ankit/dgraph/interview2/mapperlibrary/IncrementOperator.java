package com.ankit.dgraph.interview2.mapperlibrary;

public class IncrementOperator implements Operator {
    public Integer operate(Integer operand) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return operand+1;
    }
}
