package com.ankit.cleanCode;

public class StackFactory {

    public static Stack Make(int size) {
        if (size<0)
            throw new Stack.InvalidSize();

        if (size==0)
            return new ZeroSizeStack(size);
        return new BoundedStack(size);
    }

}
